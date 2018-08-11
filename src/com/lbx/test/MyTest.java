package com.lbx.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create by lbx on 2018/4/15  8:16
 **/
public class MyTest {

    @Test
    public void fun1() {
        Set<String> hashSet = new HashSet<String>();
        hashSet.add("11");
        hashSet.add("22");
        hashSet.add("33");
        hashSet.add("44");

        Set<String> hashSet1 = new HashSet<String>();
        hashSet1.add("33");
        hashSet1.add("11");

        System.out.println(hashSet.retainAll(hashSet1));
        System.out.println(hashSet);
    }

    @Test
    public void fun2(){
        User user = new User();
        List list=new ArrayList();
    }


    class User<T>{
        private String name;
        private String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public User() {
        }


    }


}
