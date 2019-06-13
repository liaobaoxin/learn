package com.lbx.jdk8.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2019/6/13 9:04
 */
public class DemoStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("张无忌");
        list.add("张三丰");
        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(name->System.out.println(name));

        System.out.println(list);
    }
}
