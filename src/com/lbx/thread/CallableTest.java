package com.lbx.thread;

import java.util.concurrent.*;

/**
 * Create by lbx on 2018/9/4  15:59
 **/
public class CallableTest implements Callable<String> {

    static  CountDownLatch c=new CountDownLatch(1);

    @Override
    public String call() throws Exception {
//        c.countDown();
        TimeUnit.SECONDS.sleep(5);
        return "我是返回值";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> submit = executorService.submit(new CallableTest());
//        c.await();
        System.out.println(submit.get());
        System.out.println(submit.isDone());

        executorService.shutdown();
    }
}
