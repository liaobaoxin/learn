package com.lbx.designPattern.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * 具体主题角色：
 * 实现抽象主题角色
 * @author Administrator
 *
 */
public class ConcreteWatched implements BeWatched{
    //创建一个队列来存储一个或多个观察者
    private List<Watcher> al= new LinkedList<>();
    @Override
    public void addWatcher(Watcher watcher) {
        al.add(watcher);//添加观察者到指定队列中
    }
    @Override
    public void removeWatcher(Watcher watcher) {
        al.remove(watcher);//从队列中删除观察者
    }
    @Override
    public void notifyWatchers(String str) {
        //遍历队列
        for(int i=0;i<al.size();i++){
            Watcher watcher = al.get(i);//获取队列中的观察者对象
            watcher.update(str);//调用它的update()方法
        }
    }
}
