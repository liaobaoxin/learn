package com.lbx.producersAndConsumers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Create by lbx on 2018/9/4  16:56
 **/
public class ComsumeTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                LinkedBlockingDeque<BusinessVO> messageQueue = BlockingContainer.getInstance();
                try {
                    while (true) {
                        System.out.println(messageQueue.size());
                        BusinessVO businessVO = messageQueue.take();
                        System.out.println(businessVO.toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
