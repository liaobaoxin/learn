package com.lbx.thread;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Create by lbx on 2018/8/22  20:18
 **/
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread count1 = new Thread(new count1(),"计算1" );
        count1.start();

        Thread count2 = new Thread(new count2(),"计算2" );
        count1.join();
        count2.start();

        System.out.println("11");



    }

    static class count1 implements Runnable {

        @Override
        public void run() {
            for(int i=0;i<20000;i++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    static class count2 implements Runnable {


        @Override
        public void run() {
            System.out.println("结束");
        }
    }
}
