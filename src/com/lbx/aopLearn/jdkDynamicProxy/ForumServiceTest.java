package com.lbx.aopLearn.jdkDynamicProxy;

import com.lbx.aopLearn.primordialAOP.ForumService;
import com.lbx.aopLearn.primordialAOP.ForumServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Create by lbx on 2018/11/3  15:20
 **/
public class ForumServiceTest {

    @Test
    public void proxy(){
        ForumServiceImpl target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        proxy.removeForum(10);
        proxy.removeTopic(1010);



    }
}
