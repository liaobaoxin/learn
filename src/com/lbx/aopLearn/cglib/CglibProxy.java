package com.lbx.aopLearn.cglib;

import com.lbx.aopLearn.primordialAOP.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Create by lbx on 2018/11/3  17:38
 **/
public class CglibProxy implements MethodInterceptor {
     Enhancer enhancer=new Enhancer();


    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName()+"."+method.getName());
        Object result = methodProxy.invokeSuper(obj, args);
        PerformanceMonitor.end();
        return result;
    }
}
