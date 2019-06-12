package com.lbx.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Create by lbx on 2018/10/13  19:53
 **/
public class GetChannel {
    private static final int BISZE=1024;

    public static void main(String[] args) throws Exception {
        String file="d:\\data.txt";
        FileChannel fc = new FileOutputStream(file).getChannel();
        fc.write(ByteBuffer.wrap("你".getBytes("UTF-8")));
        fc.close();
        fc=new RandomAccessFile(file,"rw").getChannel();
        System.out.println(fc.size());
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("好".getBytes()));
        fc.close();

        fc=new FileInputStream(file).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BISZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()){
            byte[] bytes = {buff.get(),buff.get(),buff.get()};
            System.out.print(new String(bytes,"UTF-8"));
        }
    }
}
