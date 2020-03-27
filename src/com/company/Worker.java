package com.company;

import java.util.concurrent.CountDownLatch;

class Worker implements Runnable {

    //static String sql = "INSERT INTO `lajihuamax` (`msg`) VALUES (?);";
	static String sql = "INSERT INTO `lajihuamin` (`msg`) VALUES (?);";
    int start = 0;
    int end = 0;
    String name = "";
    CountDownLatch latch;

    public Worker(CountDownLatch latch, String name, int start, int end) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在执行。。");
            //String url_Words = HttpRequest.sendPost("https://nmsl.shadiao.app/api.php?from=oohuo", null);
			String url_Words = HttpRequest.sendPost("https://nmsl.shadiao.app/api.php?level=min", null);
            System.out.println(url_Words);
            Object[] params = new Object[]{url_Words};
            JdbcUtils.insert(sql, params);
        }
        latch.countDown();
    }

}
