package com.lbx.jdk8.demo1;

import java.util.function.Function;

/**
 * @date 2019/6/13 8:31
 */
public class DemoFunction {

    public static void change(String str, Function<String,String> fun1,Function<String,Integer> fun2,Function<Integer,String> fun3){
        String s = fun1.andThen(fun2).andThen(fun3).apply(str);
        System.out.println(s);
    }

    public static void main(String[] args) {
        String str="赵丽颖,20";
        change(str,s ->  s.split(",")[1],s -> Integer.parseInt(s),i->i+100+"");
    }


}
