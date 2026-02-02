package utils;

import java.util.concurrent.CountDownLatch;

public class SyncManager {

    // Scenario A will wait on this
    // Scenario B will release this
    public static CountDownLatch cartUpdateLatch = new CountDownLatch(1);

}
