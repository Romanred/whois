package net.ripe.db.nrtm4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.ripe.db.nrtm4.dao.DeltaFileDao;
import net.ripe.db.nrtm4.dao.NotificationFileDao;
import net.ripe.db.nrtm4.dao.NrtmVersionInfoRepository;
import net.ripe.db.nrtm4.dao.SnapshotFileRepository;
import net.ripe.db.nrtm4.domain.NotificationFile;
import net.ripe.db.nrtm4.domain.NrtmVersionInfo;
import net.ripe.db.nrtm4.domain.PublishableNotificationFile;
import net.ripe.db.nrtm4.domain.SnapshotFile;
import net.ripe.db.nrtm4.domain.DeltaFileVersionInfo;
import net.ripe.db.whois.common.dao.VersionDateTime;
import net.ripe.db.whois.common.domain.Timestamp;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class NotificationFileGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationFileGenerator.class);

    private final String baseUrl;
    private final DeltaFileDao deltaFileDao;
    private final NotificationFileDao notificationFileDao;
    private final NrtmVersionInfoRepository nrtmVersionInfoRepository;
    private final SnapshotFileRepository snapshotFileRepository;

    public NotificationFileGenerator(
        @Value("${nrtm.baseUrl}") final String baseUrl,
        final DeltaFileDao deltaFileDao,
        final NotificationFileDao notificationFileDao,
        final NrtmVersionInfoRepository nrtmVersionInfoRepository,
        final SnapshotFileRepository snapshotFileRepository
    ) {
        this.baseUrl = baseUrl;
        this.deltaFileDao = deltaFileDao;
        this.notificationFileDao = notificationFileDao;
        this.nrtmVersionInfoRepository = nrtmVersionInfoRepository;
        this.snapshotFileRepository = snapshotFileRepository;
    }

    void createInitialNotification(final NrtmVersionInfo version) {
        final SnapshotFile snapshotFile = snapshotFileRepository.getByVersionID(version.id()).orElseThrow();
        final String timestamp = new VersionDateTime(version.created()).toString();
        final PublishableNotificationFile publishableNotificationFile = new PublishableNotificationFile(version, timestamp, null, convert(version, snapshotFile), null);
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            final String json = objectMapper.writeValueAsString(publishableNotificationFile);
            final NotificationFile notificationFile = NotificationFile.of(version.id(), json);
            notificationFileDao.save(notificationFile);
        } catch (final JsonProcessingException e) {
            LOGGER.error("Saving notification file failed for {}", version.source().getName());
            throw new RuntimeException(e);
        }
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
    void updateNotification() {
        for (final NrtmVersionInfo version : nrtmVersionInfoRepository.findLastVersionPerSource()) {
            final Optional<NotificationFile> lastNotificationFile = notificationFileDao.findLastNotification(version.source());
            if (lastNotificationFile.isEmpty()) {
                LOGGER.error("Expected a previous notification file for {}, but there wasn't one", version.source().getName());
                continue;
            }
            final NrtmVersionInfo lastNotificationFileVersion = nrtmVersionInfoRepository.findById(lastNotificationFile.get().versionId());
            final SnapshotFile snapshotFile = snapshotFileRepository.getLastSnapshot(version.source()).orElseThrow();
            final NrtmVersionInfo lastSnapshotVersion = nrtmVersionInfoRepository.findById(snapshotFile.versionId());
            final Timestamp oneDayAgo = Timestamp.from(LocalDateTime.now().minusDays(1));
            final List<DeltaFileVersionInfo> deltaFiles = deltaFileDao.getDeltasForNotification(lastSnapshotVersion, oneDayAgo.getValue());
            if (deltaFiles.isEmpty()) {
                return;
            }
            final DeltaFileVersionInfo lastDelta = deltaFiles.get(deltaFiles.size() - 1);
            try {
                final PublishableNotificationFile lastNotificationUpdate = new ObjectMapper().readValue(lastNotificationFile.get().payload().getBytes(StandardCharsets.UTF_8), PublishableNotificationFile.class);
                // if notification file is < 1 day old and nothing changed, do nothing.
                final List<PublishableNotificationFile.NrtmFileLink> newDeltas = convert(deltaFiles);
                if (lastNotificationUpdate.getDeltas() != null && lastNotificationUpdate.getDeltas().equals(newDeltas) && lastNotificationFileVersion.created() > oneDayAgo.getValue()) {
                    return;
                }
                final String timestamp = new VersionDateTime(lastDelta.versionInfo().created()).toString();
                final PublishableNotificationFile publishableNotificationFile = new PublishableNotificationFile(lastDelta.versionInfo(), timestamp, null, convert(lastSnapshotVersion, snapshotFile), newDeltas);
                final String json = new ObjectMapper().writeValueAsString(publishableNotificationFile);
                final NotificationFile notificationFile = NotificationFile.of(lastDelta.versionInfo().id(), json);
                notificationFileDao.save(notificationFile);
            } catch (final IOException e) {
                LOGGER.error("Failed to update notification file for {}", version.source().getName(), e);
            }
        }
    }

    private List<PublishableNotificationFile.NrtmFileLink> convert(final List<? extends DeltaFileVersionInfo> files) {
        final List<PublishableNotificationFile.NrtmFileLink> links = files.stream()
            .map(file -> new PublishableNotificationFile.NrtmFileLink(
                file.versionInfo().version(), urlString(file.versionInfo().sessionID(), file.deltaFile().name()), file.deltaFile().hash()))
            .toList();
        if (links.isEmpty()) {
            return null;
        }
        return links;
    }

    private PublishableNotificationFile.NrtmFileLink convert(final NrtmVersionInfo version, final SnapshotFile file) {
        return new PublishableNotificationFile.NrtmFileLink(version.version(), urlString(version.sessionID(), file.name()), file.hash());
    }

    private String urlString(final String sessionID, final String fileName) {
        return String.format("%s/%s/%s", baseUrl, sessionID, fileName);
    }

}