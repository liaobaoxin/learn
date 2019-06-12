package com.lbx.InputOutputStream;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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

    @Test
    public void fun3() throws IOException {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("11","22");
        hashMap.put("12","22");
        hashMap.put("13","22");
        Set<String> set = hashMap.keySet();

    }

}
