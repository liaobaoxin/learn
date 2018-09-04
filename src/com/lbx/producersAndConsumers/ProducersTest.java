package com.lbx.producersAndConsumers;

import java.util.concurrent.*;

/**
 * Create by lbx on 2018/9/4  16:49
 **/
public class ProducersTest {
    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolExecutor executor=new ScheduledThreadPoolExecutor(1);
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                LinkedBlockingDeque<BusinessVO> messageQueue = BlockingContainer.getInstance();
                System.out.println("开始添加");
                messageQueue.push(new BusinessVO("小明",10));
            }
        },0,1, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(5);

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                LinkedBlockingDeque<BusinessVO> messageQueue = BlockingContainer.getInstance();
                try {
                    while (true) {
                        System.out.println(messageQueue.size());
//                        BusinessVO businessVO = messageQueue.take();
//                        System.out.println(businessVO.toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }



}
