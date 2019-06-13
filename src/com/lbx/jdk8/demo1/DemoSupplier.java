package com.lbx.jdk8.demo1;

import java.util.function.Supplier;

/**
 * @date 2019/6/12 17:50
 */
public class DemoSupplier {
    public static void main(String[] args) {

        Supplier<String> sup= String::new;
        sup.get();


    }
}
