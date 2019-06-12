package com.lbx.thread;

import java.util.concurrent.TimeUnit;

/**
 * Create by lbx on 2018/8/21  20:31
 **/
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        //sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        //busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        //休息5秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleepThread interrupted is "+sleepThread.isInterrupted());
        System.out.println("busyThread interrupted is "+busyThread.isInterrupted());
        //防止sleepThread和busyThread立刻退出
        TimeUnit.SECONDS.sleep(2);

    }


    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
