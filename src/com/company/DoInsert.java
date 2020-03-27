package com.company;

import java.util.concurrent.CountDownLatch;

/**
 * @author ZH
 */
public class DoInsert {
    public static void main(String[] args) {
        long startTimes = System.currentTimeMillis();
        String[] names = new String[]{"LXL", "MQJ", "JOE", "JON", "JACK", "LILY", "LUCY", "NOB", "FDSE", "GTX"};
        int threadCount = 5;
        int total = 5000;
        int every = total / threadCount;
        final CountDownLatch latch = new CountDownLatch(threadCount);
//		ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Worker(latch, names[i], i * every, (i + 1) * every)).start();
        }
        try {
            latch.await();
            long endTimes = System.currentTimeMillis();
            System.out.println("所有线程执行完毕:" + (endTimes - startTimes));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


