package com.lbx.producersAndConsumers;

import java.util.concurrent.Callable;

/**
 * 存放业务对象，demo:年龄和姓名
 * Create by lbx on 2018/9/4  16:22
 **/
public class BusinessVO implements Callable<String>{
    private String name;
    private Integer age;

    public BusinessVO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String call() throws Exception {
        return "我叫:"+name+"，年龄："+age;
    }

    @Override
    public String toString() {
        return "BusinessVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
