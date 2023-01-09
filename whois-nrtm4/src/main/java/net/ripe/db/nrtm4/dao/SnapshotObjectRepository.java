package net.ripe.db.nrtm4.dao;

import net.ripe.db.whois.common.dao.jdbc.JdbcStreamingHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


/**
 * `id`          int unsigned NOT NULL AUTO_INCREMENT,
 * `version_id`  int unsigned NOT NULL,
 * `serial_id`   int          NOT NULL,
 * `object_type` int          NOT NULL,
 * `pkey`        varchar(256) NOT NULL,
 * `payload`     longtext     NOT NULL,
 */
@Repository
public class SnapshotObjectRepository {

    private final JdbcTemplate jdbcTemplate;

    public SnapshotObjectRepository(@Qualifier("nrtmDataSource") final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void batchInsert(final List<SnapshotObject> snapshotObjects) {
        jdbcTemplate.execute("INSERT INTO snapshot_object (version_id, object_id, sequence_id, rpsl) VALUES (?, ?, ?, ?)",
            (PreparedStatementCallback<Object>) preparedStatement -> {
                for (final SnapshotObject snapshotObject : snapshotObjects) {
                    preparedStatement.setLong(1, snapshotObject.versionId());
                    preparedStatement.setInt(2, snapshotObject.objectId());
                    preparedStatement.setInt(3, snapshotObject.sequenceId());
                    preparedStatement.setString(4, snapshotObject.rpsl());
                    preparedStatement.addBatch();
                }
                return preparedStatement.executeBatch();
            });
    }

    public SnapshotObject insert(
        final long versionId,
        final int objectId,
        final int sequenceId,
        final String rpsl
    ) {
        final String sql = "" +
            "INSERT INTO snapshot_object (version_id, object_id, sequence_id, rpsl) " +
            "VALUES (?, ?, ?, ?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            final PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setLong(1, versionId);
            pst.setInt(2, objectId);
            pst.setInt(3, sequenceId);
            pst.setString(4, rpsl);
            return pst;
        }, keyHolder);
        return new SnapshotObject(keyHolder.getKeyAs(Long.class), versionId, objectId, sequenceId, rpsl);
    }

    public Optional<SnapshotObject> getByObjectObjectId(
        final int objectId
    ) {
        final String sql = "" +
            "SELECT " +
            "id, version_id, object_id, seqeunce_id, rpsl " +
            "FROM snapshot_object " +
            "WHERE object_id = ? ";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, (rs, rn) ->
                new SnapshotObject(
                    rs.getLong(1),
                    rs.getLong(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5)
                ), objectId));
        } catch (final EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public void update(
        final long versionId,
        final int objectId,
        final int sequenceId,
        final String rpsl
    ) {
        final String sql = "" +
            "UPDATE snapshot_object " +
            "SET " +
            "version_id = ?, " +
            "sequence_id = ?, " +
            "rpsl = ? " +
            "WHERE object_id = ?";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            final PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setLong(1, versionId);
            pst.setInt(2, sequenceId);
            pst.setString(3, rpsl);
            pst.setInt(4, objectId);
            return pst;
        }, keyHolder);
    }

    public void delete(final int objectId) {
        final String sql = "" +
            "DELETE FROM snapshot_object " +
            "WHERE object_id = ? ";
        jdbcTemplate.update(connection -> {
            final PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, objectId);
            return pst;
        });
    }

    public void snapshotCallback(final NrtmSource source, final RowCallbackHandler rowCallbackHandler) {
        final String sql = "" +
            "SELECT so.rpsl " +
            "FROM snapshot_object so " +
            "JOIN version_info v ON v.id = so.version_id " +
            "JOIN source src ON src.id = v.source_id " +
            "WHERE src.name = ? " +
            "ORDER BY so.object_id";
        JdbcStreamingHelper.executeStreaming(
            jdbcTemplate,
            sql,
            pss -> pss.setString(1, source.name()),
            rowCallbackHandler);
    }

    public Stream<String> getSnapshotAsStream(final NrtmSource source) {
        final String sql = "" +
            "SELECT so.rpsl " +
            "FROM snapshot_object so " +
            "JOIN version_info v ON v.id = so.version_id " +
            "JOIN source src ON src.id = v.source_id " +
            "WHERE src.name = ? " +
            "ORDER BY so.object_id";

        return jdbcTemplate.queryForStream(sql, (rs, rn) -> rs.getString(1), source.name());
    }

}