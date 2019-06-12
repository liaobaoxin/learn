package com.lbx.jdk8.demo1;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Create by lbx on 2019/6/12  20:44
 **/
public class DemoConsumer {

    public static void show(String name, Consumer<String> con) {
        con.accept(name);
    }

    public static void show1(String name, Consumer<String> con1, Consumer<String> con2) {
        con1.andThen(con2).accept(name);
    }

    public static void show2(String array[], Consumer<String> con1, Consumer<String> con2) {
        for (String arr : array) {
            con1.andThen(con2).accept(arr);
        }
    }


    public static void main(String[] args) {
        show("aa", name -> System.out.println(name.toUpperCase()));
        show1("aa", name -> System.out.println(name + "1"), name -> System.out.println(name + "2"));

        String[] array = {"迪丽热巴，女", "古力娜扎，女", "马尔扎哈，男"};
        System.out.println(Arrays.toString(array));

        show2(array, name -> System.out.print("姓名：" + name.split("，")[0] + "，"), name -> System.out.println("性别：" + name.split("，")[1]));


    }

}
