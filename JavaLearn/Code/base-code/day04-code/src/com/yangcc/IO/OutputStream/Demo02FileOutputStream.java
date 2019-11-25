package com.yangcc.IO.OutputStream;

import com.yangcc.day5.Array;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Demo02FileOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream(new File("D:\\myfile\\test\\b.txt"));
        // 数组
        byte [] btes={-65,66,67,68,69};
        // 把字符串转化为字节数组并输入
        byte [] bytes2="不安".getBytes();
        System.out.println(Arrays.toString(bytes2));
        fos.write(bytes2);
        fos.close();

    }
}
