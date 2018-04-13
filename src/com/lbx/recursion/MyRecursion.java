package com.lbx.recursion;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/**
 * @date 2018/4/13 8:28
 */
public class MyRecursion {

    @Test
    public void fun1() {
        getAllJava("E:\\DEMO");
    }

    /**
     * 遍历所有的.java文件
     */
    public static void getAllJava(String dir) {
        File file = new File(dir);
        File[] listFiles = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.isDirectory()){
                    return true;
                }
                return pathname.getName().toLowerCase().endsWith(".java");
            }
        });
        for (File file1 : listFiles) {
            if (file1.isDirectory()) {
                getAllJava(file1.getAbsolutePath());
            } else {
                System.out.println(file1.getName());
            }
        }

    }

}
