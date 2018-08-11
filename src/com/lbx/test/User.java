package com.lbx.test;

/**
 * Create by lbx on 2018/4/15  11:21
 **/
public class User<T> {
    private String name;
    private String age;

    public static <T> void get(T t){
        System.out.println(t);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
