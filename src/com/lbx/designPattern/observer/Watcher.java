package com.lbx.designPattern.observer;

/**
 * 抽象观察者角色：为所有观察者定义一个接口，在接到主题角色的通知时更新自己
 *
 */
public interface Watcher {

    //更新自己
    public void update(String str);

}
