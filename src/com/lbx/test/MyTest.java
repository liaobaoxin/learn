package com.lbx.test;


import com.lbx.utils.DateUtils;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Test;

import java.io.*;
import java.util.*;

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
    public void fun2() {
        User user = new User();
        List list = new ArrayList();
    }


    class User<T> {
        private String name;
        private String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public User() {
        }


    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        System.out.println(System.getProperty("file.encoding"));
    }

    @Test
    public void test4() throws Exception {
        ZipArchiveOutputStream zaos = new ZipArchiveOutputStream(new File("d:\\text.zip"));
        File file = new File("D:\\test.txt");
        InputStream is = new FileInputStream(file);
        ZipArchiveEntry entry = new ZipArchiveEntry(file, file.getName());
        zaos.putArchiveEntry(entry);
        IOUtils.copy(is,zaos);
        zaos.closeArchiveEntry();
        is.close();
        zaos.finish();
        zaos.close();
    }

    @Test
    public void test5(){
        File file=new File("D:\\centos6.5");
        System.out.println(DateUtils.dateToDateTime(new Date(file.lastModified())));

        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.length() / 1024/1024 < 100) {
                    System.out.println(file.getName());
                    return true;
                }
                return false;
            }
        });
        System.out.println(files.length);
    }



}
