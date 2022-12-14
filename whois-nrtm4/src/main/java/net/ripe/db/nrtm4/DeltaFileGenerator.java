package net.ripe.db.nrtm4;

import com.google.common.hash.Hashing;
import net.ripe.db.nrtm4.persist.DeltaFileRepository;
import net.ripe.db.nrtm4.persist.NrtmSource;
import net.ripe.db.nrtm4.persist.NrtmVersionInfo;
import net.ripe.db.nrtm4.persist.NrtmVersionInfoRepository;
import net.ripe.db.nrtm4.publish.PublishableDeltaFile;
import net.ripe.db.whois.common.dao.SerialDao;
import net.ripe.db.whois.common.domain.serials.SerialEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;


@Service
public class DeltaFileGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeltaFileGenerator.class);

    private final DeltaTransformer deltaTransformer;
    private final NrtmVersionInfoRepository nrtmVersionInfoRepository;
    private final SerialDao serialDao;
    private final DeltaFileRepository deltaFileRepository;
    private final JsonSerializer jsonSerializer;

    public DeltaFileGenerator(
        final DeltaTransformer deltaTransformer,
        final NrtmVersionInfoRepository nrtmVersionInfoRepository,
        final SerialDao serialDao,
        final DeltaFileRepository deltaFileRepository,
        final JsonSerializer jsonSerializer
    ) {
        this.deltaTransformer = deltaTransformer;
        this.nrtmVersionInfoRepository = nrtmVersionInfoRepository;
        this.serialDao = serialDao;
        this.deltaFileRepository = deltaFileRepository;
        this.jsonSerializer = jsonSerializer;
    }

    public Optional<PublishableDeltaFile> createDelta(final NrtmSource source) {

        // Find changes since the last delta
        final Optional<NrtmVersionInfo> lastVersion = nrtmVersionInfoRepository.findLastVersion(source);
        if (lastVersion.isEmpty()) {
            throw new IllegalStateException("Cannot create a delta without an initial snapshot");
        }
        final List<SerialEntry> whoisChanges = serialDao.getSerialEntriesSince(lastVersion.get().getLastSerialId());
        if (whoisChanges.size() < 1) {
            LOGGER.info("No Whois changes found -- delta file generation skipped");
            return Optional.empty();
        }
        final List<DeltaChange> deltas = deltaTransformer.toDeltaChange(whoisChanges);
        if (deltas.size() < 1) {
            LOGGER.info("Whois changes found but all were filtered");
            return Optional.empty();
        }
        final int lastSerialId = whoisChanges.get(whoisChanges.size() - 1).getSerialId();
        final NrtmVersionInfo nextVersion = nrtmVersionInfoRepository.incrementAndSave(lastVersion.get(), lastSerialId);
        final PublishableDeltaFile deltaFile = new PublishableDeltaFile(nextVersion, deltas);
        final String payload = jsonSerializer.process(deltaFile);

        final String fileName = FileNameGenerator.fileName(deltaFile);
        final String sha256hex = Hashing.sha256()
            .hashString(payload, StandardCharsets.UTF_8)
            .toString();

        deltaFileRepository.save(
            nextVersion.getId(),
            fileName,
            sha256hex,
            payload
        );
        deltaFile.setFileName(fileName);
        deltaFile.setSha256hex(sha256hex);
        return Optional.of(deltaFile);
    }

}
