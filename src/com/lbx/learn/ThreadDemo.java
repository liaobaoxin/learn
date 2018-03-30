package com.lbx.learn;

/**
 * @Author:
 * @date 2018/3/30 15:24
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();


        Input input = new Input(resource);
        Thread in = new Thread(input);
        in.start();

        OutPut out = new OutPut(resource);
        Thread outThread = new Thread(out);
        outThread.start();
    }
}
