package com.lbx.aopLearn;

/**
 * Create by lbx on 2018/11/3  14:48
 **/
public class MethodPerformance {
    private Long begin;
    private Long end;
    private String serviceMethod;
    public MethodPerformance(String serviceMethod){
        this.serviceMethod=serviceMethod;
        this.begin=System.currentTimeMillis();
    }

    public void printPerformance(){
        end=System.currentTimeMillis();
        Long elapse=end-begin;
        System.out.println(serviceMethod+"花费"+elapse+"毫秒");
    }
}
