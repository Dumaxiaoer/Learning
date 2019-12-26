package com.yangcc.IO.InputStream;

import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Demo02InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("D:\\myfile\\test\\b.txt");
        byte [] bytes =new byte[2];
        // len在这里表示有效字节个数
        int len=fis.read(bytes);
        System.out.println(len);
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));
        fis.close();
    }
}
