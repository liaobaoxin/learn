package com.lbx.jdk8.demo1;

/**
 * @date 2019/6/13 11:42
 */
public class DemoObjectMethodReference {

    static void printString(Printable p){
        p.print("hello");
    }

    public static void main(String[] args) {

        MethodRerObject obj = new MethodRerObject();
        printString(obj::printUpperCaseString);
    }
}
