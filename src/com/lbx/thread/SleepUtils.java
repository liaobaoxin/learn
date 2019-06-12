package com.lbx.thread;

import java.util.concurrent.TimeUnit;

/**
 * Create by lbx on 2018/8/21  20:29
 **/
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
