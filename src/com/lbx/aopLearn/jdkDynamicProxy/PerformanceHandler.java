package com.lbx.aopLearn.jdkDynamicProxy;

import com.lbx.aopLearn.primordialAOP.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Create by lbx on 2018/11/3  15:09
 **/
public class PerformanceHandler implements InvocationHandler {
    private Object target;
    public PerformanceHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
        Object obj = method.invoke(target, args);
        PerformanceMonitor.end();
        return obj;
    }
}
