package net.ripe.db.nrtm4;

import java.util.Random;

import static net.ripe.db.nrtm4.NrtmConstants.DELTA_PREFIX;
import static net.ripe.db.nrtm4.NrtmConstants.SNAPSHOT_PREFIX;


public class FileNameGenerator {



    private static final String chars = "0123456789abcdef";

    static String deltaFileName(final long version) {
        return String.format("%s.%d.%s.json", DELTA_PREFIX, version, randomHexString());
    }

    static String snapshotFileName(final long version) {
        return String.format("%s.%d.%s.json", SNAPSHOT_PREFIX, version, randomHexString());
    }

    static String randomHexString() {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(40);
        for (int i = 0; i < 40; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

}
