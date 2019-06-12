package com.lbx.jdk8;

import com.lbx.jdk8.demo1.MyFunctionInterface;
import org.junit.Test;

/**
 * @date 2019/6/12 17:12
 */
public class MyTest {

    static void show(MyFunctionInterface functionalInterface){
        functionalInterface.show();
    }

    @Test
    public void test1(){
        show(()-> System.out.println("222"));
    }

    @Test
    public void test2(){
        new Thread(()-> System.out.println("222112")).start();
    }
}
