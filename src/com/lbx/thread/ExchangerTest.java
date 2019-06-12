package com.lbx.thread;


import com.lbx.interFaceAdapter.A;

import java.util.concurrent.Exchanger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by lbx on 2018/9/2  13:57
 **/
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();
    static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水A";
                try {
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";//B录入银行流水数据
                    String A = exgr.exchange(null);
                    System.out.println("A和B数据是否一致：" + A.equals(B) + ",A录入的是" + A + ",B录入的是：" + B);
                } catch (Exception e) {

                }
            }
        });

    threadPool.shutdown();
    }
}
