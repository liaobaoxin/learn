package com.lbx.learn;

/**
 * @Author:
 * @date 2018/3/30 15:23
 */
public class OutPut implements Runnable {
    private Resource resource;

    public OutPut(Resource resource) {
        this.resource = resource;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (resource) {
                if (!resource.flag) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(resource.name + "...." + resource.sex);

                //标记改成false,唤醒对方线程
                resource.flag = false;
                resource.notify();
            }
        }
    }
}
