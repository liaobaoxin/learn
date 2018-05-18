package com.lbx.designPattern.observer;

/**
 * 具体的观察者角色：
 * 实现抽象观察者角色
 * @author Administrator
 *
 */
public class ConcreteWatcher implements Watcher{
    @Override
    public void update(String str) {
        System.out.println("已经收到通知："+str);
    }

}
