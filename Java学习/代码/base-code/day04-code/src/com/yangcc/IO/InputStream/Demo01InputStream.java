package com.yangcc.IO.InputStream;

import com.yangcc.day5.Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Demo01InputStream {
    public static void main(String[] args) throws  IOException {
        FileInputStream fis=new FileInputStream("D:\\myfile\\test\\b.txt");
        // 读取文件的一个字节并返回，读取到文件的末尾，会返回-1
        int len = 0;  // len 表示读取到的字节
        while ((len = fis.read())!= -1){
            System.out.println(len+"||"+(char)len);
        }
        byte [] bytes="不安".getBytes();
        System.out.println(Arrays.toString(bytes));
        fis.close();

    }
}
