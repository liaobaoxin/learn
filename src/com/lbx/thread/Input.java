package com.lbx.thread;

/**
 * @Author:
 * @date 2018/3/30 15:19
 */
public class Input implements Runnable {

    private Resource resource;

    public Input(Resource r) {
        this.resource = r;
    }

    @Override
    public void run() {
        int i=0;
        while (true) {
            synchronized (resource) {
                if(resource.flag){
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(i%2==0){
                    resource.name="张三";
                    resource.sex="男";
                }else {
                    resource.name="lisi";
                    resource.sex="nv";
                }

                i++;
                //将对方线程唤醒,标记改为true
                resource.flag = true;
                //唤醒在此对象监视器上等待的单个线程。
                resource.notify();
            }

        }
    }
}
