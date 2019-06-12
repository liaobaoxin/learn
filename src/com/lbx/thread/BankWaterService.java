package com.lbx.thread;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Create by lbx on 2018/9/4  15:20
 **/
public class BankWaterService implements Runnable {

    /**
     * 创建4个屏障，处理完之后执行当前类的run方法
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);

    /**
     * 假设只有4个sheet，所以只启动4个线程
     */
    private ExecutorService executors = Executors.newFixedThreadPool(4);

    /**
     * 保存每个sheet计算出的银流结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    //计算当前sheet的银流数据
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    try {
                        //银流计算完成,插入一个屏障
                        c.await();
                        System.out.println("我是最后执行的");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result=0;
        //汇总每个sheet计算出的结果
        for(Map.Entry<String,Integer> sheet:sheetBankWaterCount.entrySet()){
            System.out.println(sheet.getKey()+"==="+sheet.getValue());
            result+=sheet.getValue();
        }
        //将结果输出
        sheetBankWaterCount.put("resule",result);
        System.out.println(result);
        executors.shutdown();
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService=new BankWaterService();
        bankWaterService.count();
    }
}
