package com.lbx.properties;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * Create by lbx on 2018/4/18  20:32
 **/
public class PropertiesTest {

    @Test
    public void fun1() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name","zhangsan");
        properties.store(new FileWriter("d:\\a.properties"),"");
    }

    @Test
    public void fun2() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("d:\\a.properties"));
        String name = properties.getProperty("name");
        System.out.println(name);
    }

}
