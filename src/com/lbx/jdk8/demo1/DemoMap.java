package com.lbx.jdk8.demo1;

import java.util.stream.Stream;

/**
 * @date 2019/6/13 10:17
 */
public class DemoMap {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a", "b", "c", "d");
        stream.map(str->str+str.toUpperCase()).forEach(str-> System.out.println(str));
    }
}
