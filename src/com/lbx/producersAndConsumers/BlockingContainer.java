package com.lbx.producersAndConsumers;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * 中间容器，消费者和生产者共用的容器
 * Create by lbx on 2018/9/4  16:31
 **/
public class BlockingContainer {
    private volatile static BlockingContainer instance;

    public static LinkedBlockingDeque<BusinessVO> businessVOS = new LinkedBlockingDeque<>();

    public static BlockingContainer getInstance() {
        if (instance == null) {
            synchronized (BlockingContainer.class) {
                if (instance == null) {
                    instance = new BlockingContainer();
                }
            }
        }
        return instance;
    }

    public boolean put(String name, Integer age) {
        boolean b = businessVOS.add(new BusinessVO(name, age));
        return  b;
    }


    public BusinessVO take() throws InterruptedException {
        return businessVOS.take();
    }

}
