package com.lbx.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @date 2018/5/18 9:40
 */
class Observe extends Observable {
    // 程序的入口
    public static void main(String args[]) {
        Observe watched = new Observe();// 创建被观察对象
        FirstObserver watch = new FirstObserver();// 创建观察者对象（可以创建多个）
        watched.addObserver(watch);
        watched.toWatchers("你好！");
    }

    // 通知观察者的方法
    public void toWatchers(String str) {
        this.setChanged();// 被观察者发生变化，把changed设置为true
        this.notifyObservers(str);// 通知观察者
    }
}

class FirstObserver implements Observer {
    // 重写更新方法
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("被观察者发生变化，观察者已收到通知：" + arg);
    }
}
