package net.ripe.db.nrtm4;

import net.ripe.db.nrtm4.domain.NrtmDocumentType;
import net.ripe.db.nrtm4.domain.NrtmSourceModel;
import net.ripe.db.nrtm4.domain.NrtmVersionInfo;
import net.ripe.db.whois.common.DateTimeProvider;
import net.ripe.db.whois.common.domain.CIString;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SnapshotWindowTest {

    @Test
    void snapshot_is_generated_at_the_right_time_when_window_spans_midnight() {
        final var windowDef = "23:00 - 05:00";
        final var date = LocalDate.of(2023, 3, 14);
        {
            final var time = LocalTime.of(15, 13);
            final var window = new SnapshotWindow(windowDef, getMockDateTimeProvider(date, time));
            assertThat(window.isInWindow(), is(false));
        }
        {
            final var time = LocalTime.of(23, 30);
            final var window = new SnapshotWindow(windowDef, getMockDateTimeProvider(date, time));
            assertThat(window.isInWindow(), is(true));
        }
        {
            final var time = LocalTime.of(1, 50);
            final var window = new SnapshotWindow(windowDef, getMockDateTimeProvider(date, time));
            assertThat(window.isInWindow(), is(true));
        }
        {
            final var time = LocalTime.of(5, 30);
            final var window = new SnapshotWindow(windowDef, getMockDateTimeProvider(date, time));
            assertThat(window.isInWindow(), is(false));
        }
    }

    @Test
    void snapshot_is_generated_at_the_right_time_when_window_does_not_span_midnight() {
        final var windowDef = "01:00 - 05:00";
        final var date = LocalDate.of(2023, 3, 14);
        {
            final var time = LocalTime.of(15, 13);
            final var window = new SnapshotWindow(windowDef, getMockDateTimeProvider(date, time));
            assertThat(window.isInWindow(), is(false));
        }
        {
            final var time = LocalTime.of(23, 30);
            final var window = new SnapshotWindow(windowDef, getMockDateTimeProvider(date, time));
            assertThat(window.isInWindow(), is(false));
        }
        {
            final var time = LocalTime.of(1, 50);
            final var window = new SnapshotWindow(windowDef, getMockDateTimeProvider(date, time));
            assertThat(window.isInWindow(), is(true));
        }
        {
            final var time = LocalTime.of(5, 30);
            final var window = new SnapshotWindow(windowDef, getMockDateTimeProvider(date, time));
            assertThat(window.isInWindow(), is(false));
        }
    }

    @Test
    void is_it_time_to_refresh_the_snapshot() {
        final var windowDef = "01:00 - 05:00";
        final var window = new SnapshotWindow(windowDef, getMockDateTimeProvider(LocalDate.now(), LocalTime.now()));
        {
            final var agesAgo = LocalDateTime.now().minusDays(50);
            final var src = new NrtmSourceModel(666, CIString.ciString("fish"));
            final var file = new NrtmVersionInfo(667L, src, 100L, "xxx-yyy-zzz", NrtmDocumentType.SNAPSHOT, 9999, agesAgo.toEpochSecond(ZoneOffset.UTC));
            assertThat(window.isFileReadyForRefresh(file), is(true));
        }
        {
            final var now = LocalDateTime.now();
            final var src = new NrtmSourceModel(666, CIString.ciString("fish"));
            final var file = new NrtmVersionInfo(667L, src, 100L, "xxx-yyy-zzz", NrtmDocumentType.SNAPSHOT, 9999, now.toEpochSecond(ZoneOffset.UTC));
            assertThat(window.isFileReadyForRefresh(file), is(false));
        }
    }

    private DateTimeProvider getMockDateTimeProvider(
        final LocalDate localDate,
        final LocalTime localTime
    ) {
        return new DateTimeProvider() {
            @Override
            public LocalDate getCurrentDate() {
                return localDate;
            }

            @Override
            public LocalDateTime getCurrentDateTime() {
                return LocalDateTime.of(localDate, localTime);
            }

            @Override
            public ZonedDateTime getCurrentZonedDateTime() {
                return ZonedDateTime.of(getCurrentDateTime(), ZoneId.of("GMT"));
            }

            @Override
            public long getElapsedTime() {
                return 0;
            }
        };
    }

}
