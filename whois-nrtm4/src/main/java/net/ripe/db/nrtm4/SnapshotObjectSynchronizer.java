package net.ripe.db.nrtm4;

import net.ripe.db.nrtm4.dao.InitialSnapshotState;
import net.ripe.db.nrtm4.dao.NrtmSource;
import net.ripe.db.nrtm4.dao.NrtmVersionInfo;
import net.ripe.db.nrtm4.dao.NrtmVersionInfoRepository;
import net.ripe.db.nrtm4.dao.SnapshotObjectRepository;
import net.ripe.db.nrtm4.dao.WhoisDao;
import net.ripe.db.whois.common.dao.SerialDao;
import net.ripe.db.whois.common.domain.serials.SerialEntry;
import net.ripe.db.whois.common.rpsl.Dummifier;
import net.ripe.db.whois.common.rpsl.RpslObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static net.ripe.db.nrtm4.NrtmConstants.NRTM_VERSION;


@Service
public class SnapshotObjectSynchronizer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SnapshotObjectSynchronizer.class);

    private final DeltaTransformer deltaTransformer;
    private final Dummifier dummifierNrtm;
    private final NrtmVersionInfoRepository nrtmVersionInfoRepository;
    private final SerialDao serialDao;
    private final SnapshotObjectRepository snapshotObjectRepository;
    private final WhoisDao whoisDao;

    SnapshotObjectSynchronizer(
        final DeltaTransformer deltaTransformer,
        final Dummifier dummifierNrtm,
        final NrtmVersionInfoRepository nrtmVersionInfoRepository,
        @Qualifier("whoisSlaveSerialDao") final SerialDao serialDao,
        final SnapshotObjectRepository snapshotObjectRepository,
        final WhoisDao whoisDao
    ) {
        this.deltaTransformer = deltaTransformer;
        this.dummifierNrtm = dummifierNrtm;
        this.nrtmVersionInfoRepository = nrtmVersionInfoRepository;
        this.serialDao = serialDao;
        this.snapshotObjectRepository = snapshotObjectRepository;
        this.whoisDao = whoisDao;
    }

    NrtmVersionInfo initializeSnapshotObjects(final NrtmSource source) {
        final String method = "initializeSnapshotObjects";
        long mark = System.currentTimeMillis();
        LOGGER.info("{} entered", method);
        final InitialSnapshotState initialState = whoisDao.getInitialSnapshotState();
        LOGGER.info("{} Found {} objects", method, initialState.objectData().size());
        LOGGER.info("{} At serial {}", method, initialState.serialId());
        LOGGER.info("{} mark {}ms", method, (System.currentTimeMillis() - mark));
        mark = System.currentTimeMillis();
        final NrtmVersionInfo version = nrtmVersionInfoRepository.createInitialVersion(source, initialState.serialId());
        initialState.objectData().parallelStream().forEach((object) -> {
                final RpslObject rpslObject = RpslObject.parse(object.rpsl());
                if (!dummifierNrtm.isAllowed(NRTM_VERSION, rpslObject)) {
                    return;
                }
                final RpslObject dummyRpsl = dummifierNrtm.dummify(NRTM_VERSION, rpslObject);
                snapshotObjectRepository.insert(version.getId(), object.objectId(), object.sequenceId(), dummyRpsl.toString());
            }
        );
        LOGGER.info("Inserted snapshot objects");
        LOGGER.info("{} mark {}ms", method, (System.currentTimeMillis() - mark));

        // do at the end...
        // CONSTRAINT `snapshot_object__version_id__fk` FOREIGN KEY (`version_id`) REFERENCES `version_info` (`id`)

//        serialDao.getSerialEntriesFromLast(rs -> {
//            final SerialEntry serialEntry = new SerialEntry(
//                rs.getInt(1),
//                Operation.getByCode(rs.getInt(2)),
//                rs.getBoolean(3),
//                rs.getInt(4),
//                rs.getBytes(5),
//                rs.getString(6));
//            if (dummifierNrtm.isAllowed(NrtmConstants.NRTM_VERSION, serialEntry.getRpslObject())) {
//                snapshotObjectRepository.insert(
//                    version.getId(),
//                    serialEntry.getSerialId(),
//                    serialEntry.getRpslObject().getType(),
//                    serialEntry.getPrimaryKey(),
//                    dummifierNrtm.dummify(NrtmConstants.NRTM_VERSION, serialEntry.getRpslObject()).toString());
//            }
//        });
        LOGGER.info("getSerialEntriesFromLast() completed");
        return version;
    }

    boolean synchronizeDeltasToSnapshot(final NrtmSource source, final NrtmVersionInfo version) {
        final NrtmVersionInfo lastSnapshot = nrtmVersionInfoRepository.findLastSnapshotVersion(source);
        final List<SerialEntry> whoisChanges = serialDao.getSerialEntriesBetween(lastSnapshot.getLastSerialId(), version.getLastSerialId())
            .collect(Collectors.toList());
        final List<DeltaChange> deltas = deltaTransformer.toDeltaChange(whoisChanges);
        if (deltas.size() < 1) {
            return false;
        }

//        for (final DeltaChange change : deltas) {
//            if (change.getAction() == DeltaChange.Action.ADD_MODIFY) {
//                final Optional<SnapshotObject> existing = snapshotObjectRepository.getByObjectTypeAndPrimaryKey(change.getObjectType(), change.getPrimaryKey());
//                if (existing.isPresent()) {
//                    snapshotObjectRepository.update(
//                        version.getId(),
//                        change.getSerialId(),
//                        change.getObject().getKey().toString(),
//                        change.getObject().toString()
//                    );
//                } else {
//                    snapshotObjectRepository.insert(
//                        version.getId(),
//                        change.getSerialId(),
//                        change.getObject().getType(),
//                        change.getObject().getKey().toString(),
//                        change.getObject().toString()
//                    );
//                }
//            } else if (change.getAction() == DeltaChange.Action.DELETE) {
//                snapshotObjectRepository.delete(change.getObjectType(), change.getPrimaryKey());
//            }
//        }
        return true;
    }

}
