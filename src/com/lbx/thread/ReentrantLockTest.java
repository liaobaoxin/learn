package com.lbx.thread;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by lbx on 2018/8/26  21:35
 **/
public class ReentrantLockTest {


    int i = 1;

    @Test
    public void test1() throws InterruptedException {

        Thread thread1 = new Thread(new count());
        Thread thread2 = new Thread(new count());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    class count implements Runnable {
        Lock lock = new ReentrantLock();
        @Override
        public void run() {
            if (lock.tryLock()) {
                try {
                    for (int j = 0; j < 10000; j++) {
                        System.out.println(i++);
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
