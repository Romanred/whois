package net.ripe.db.whois.api.nrtm4;

import com.google.common.net.HttpHeaders;
import net.ripe.db.nrtm4.dao.DeltaFileSourceAwareDao;
import net.ripe.db.nrtm4.dao.NrtmKeyConfigRepository;
import net.ripe.db.nrtm4.dao.UpdateNotificationFileSourceAwareDao;
import net.ripe.db.nrtm4.dao.SnapshotFileSourceAwareDao;
import net.ripe.db.nrtm4.dao.NrtmSourceDao;
import net.ripe.db.nrtm4.domain.NrtmDocumentType;
import net.ripe.db.nrtm4.domain.NrtmSource;
import net.ripe.db.nrtm4.util.NrtmFileUtil;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.Optional;

@Component
@Path("/")
public class NrtmClientService {

    public static final String SOURCE_LINK_PAGE = "<html><header><title>NRTM Version 4</title></header><body>%s<body></html>";
    private final SnapshotFileSourceAwareDao snapshotFileSourceAwareDao;
    private final DeltaFileSourceAwareDao deltaFileSourceAwareDao;
    private final UpdateNotificationFileSourceAwareDao updateNotificationFileSourceAwareDao;
    private final NrtmSourceDao nrtmSourceDao;
    private final NrtmKeyConfigRepository nrtmKeyConfigRepository;
    final String nrtmUrl;

    @Autowired
    public NrtmClientService(@Value("${nrtm.baseUrl:}") final String nrtmUrl,
                             final NrtmSourceDao nrtmSourceDao,
                             final UpdateNotificationFileSourceAwareDao updateNotificationFileSourceAwareDao,
                             final SnapshotFileSourceAwareDao snapshotFileSourceAwareDao,
                             final NrtmKeyConfigRepository nrtmKeyConfigRepository,
                             final DeltaFileSourceAwareDao deltaFileSourceAwareDao) {
        this.snapshotFileSourceAwareDao = snapshotFileSourceAwareDao;
        this.deltaFileSourceAwareDao = deltaFileSourceAwareDao;
        this.updateNotificationFileSourceAwareDao = updateNotificationFileSourceAwareDao;
        this.nrtmSourceDao = nrtmSourceDao;
        this.nrtmKeyConfigRepository = nrtmKeyConfigRepository;
        this.nrtmUrl = nrtmUrl;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sourcesLinkAsHtml() {
        final StringBuilder sourceLink = new StringBuilder();

        nrtmSourceDao.getSources().forEach(sourceModel ->
                sourceLink.append(
                        String.format("<a href='%s'>%s</a><br/>",
                                        String.join("/", nrtmUrl, sourceModel.getName().toString(), "update-notification-file.json"),
                                        sourceModel.getName().toString()
                                    )
                )
        );

        return String.format(SOURCE_LINK_PAGE, sourceLink);
    }

    @GET
    @Path("{source}/{filename}")
    @Produces({MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_JSON})
    public Response nrtmFiles(
            @Context final HttpServletRequest httpServletRequest,
            @PathParam("source") final String source,
            @PathParam("filename") final String fileName) {

        if(fileName.startsWith(NrtmDocumentType.NOTIFICATION.getFileNamePrefix())) {
            final String payload = updateNotificationFileSourceAwareDao.findLastNotification(getSource(source))
                    .orElseThrow(() -> new NotFoundException("update-notification-file.json does not exists for source " + source));

            return getResponse(payload);
        }

        validateSource(source, fileName);
        if(fileName.startsWith(NrtmDocumentType.SNAPSHOT.getFileNamePrefix())) {
            return snapshotFileSourceAwareDao.getByFileName(fileName)
                    .map( snapshot -> getResponse(snapshot.getPayload(), snapshot.getSnapshotFile().hash(), fileName))
                    .orElseThrow(() -> new NotFoundException("Requested Snapshot file does not exists"));
        }

        final String filenameExt  = filenameWithExtension(fileName);
        if(fileName.startsWith(NrtmDocumentType.DELTA.getFileNamePrefix())) {
            return deltaFileSourceAwareDao.getByFileName(filenameExt)
                    .map( delta -> getResponse(delta.payload()))
                    .orElseThrow(() -> new NotFoundException("Requested Delta file does not exists"));
        }

        throw new BadRequestException("Invalid Nrtm filename");
    }

    private void validateSource(final String source, final String fileName) {
        if(!NrtmFileUtil.getSource(fileName).equals(source)) {
            throw new BadRequestException("Invalid source and filename combination");
        }
    }

    private NrtmSource getSource(final String source) {
        return nrtmSourceDao.getSources().stream().filter(sourceModel -> sourceModel.getName().equals(source)).findFirst().orElseThrow(() -> new BadRequestException("Invalid source"));
    }

    private String filenameWithExtension(final String filename) {
        //ExtensionOverridesAcceptHeaderFilter removes file extension
        return filename.endsWith(".json") ? filename : String.join("", filename, ".json");
    }
    private Response getResponse(final byte[] payload,  final String hash, final String filename) {
        return Response.ok(new ByteArrayInputStream(payload))
                .header(HttpHeaders.CONTENT_LENGTH, payload.length)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.ETAG, hash)
                .build();
    }

    private Response getResponse(final String payload) {
        return Response.ok(payload)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .build();
    }

    public String getSignedUpdateNotificationFile(final byte[] payload) throws CryptoException {
        final Signer signer = new Ed25519Signer();
        signer.init(true, new Ed25519PrivateKeyParameters(nrtmKeyConfigRepository.getPrivateKey(), 0));
        signer.update(payload, 0, payload.length);
        byte[] signature = signer.generateSignature();
        return Base64.getUrlEncoder().encodeToString(signature);
    }
}
