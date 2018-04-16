package com.lbx.InputOutputStream;

import org.junit.Test;

import java.io.*;

/**
 * @date 2018/4/16 8:26
 */
public class FileCopy {

    @Test
    public void fun1() {
        InputStream fis = null;
        OutputStream fos = null;
        try {


            fis = new FileInputStream("D:\\copy.txt");
            fos = new FileOutputStream("F:\\copy.txt");

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("文件复制错误");
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException("关闭输出流失败");
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new RuntimeException("关闭输入流失败");
                    }
                }
            }

        }

    }
}
