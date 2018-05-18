package com.lbx.designPattern.observer;

/**
 * 测试类
 * @author Administrator
 *
 */
public class ClientTest {
    public static void main(String[] args){
        //创建被观察者对象
        ConcreteWatched watched = new ConcreteWatched();
        //创建观察者
        ConcreteWatcher watcher1 = new ConcreteWatcher();
        ConcreteWatcher watcher2 = new ConcreteWatcher();
        ConcreteWatcher watcher3 = new ConcreteWatcher();
        //添加多个观察者
        watched.addWatcher(watcher1);
        watched.addWatcher(watcher2);
        watched.addWatcher(watcher3);
        //通知观察者
        watched.notifyWatchers("你好！");
        //分割
        System.out.println("--------------------------------");
        //删除一个观察者
        watched.removeWatcher(watcher1);
        //再次通知观察者
        watched.notifyWatchers("很好！");

    }
}
