package com.yangcc.IO.Reader;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
/*
    字符输入流
 */
public class Demo01Reader {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("D:\\myfile\\test\\b.txt");
        FileInputStream fis=new FileInputStream("D:\\myfile\\test\\b.txt");
        int len =0;
        byte[] btes=new byte[20];
        char[] bts=new char[30];
        while ((len=fr.read(bts))!=-1){
            System.out.println(Arrays.toString(bts));
            System.out.println(new String(bts,0,len));
        }
//        fis.read(btes);
//        System.out.println(Arrays.toString(btes));
//        while ((len=fr.read())!=-1){
//            System.out.println((char)len);
//        }
        fr.close();
    }
}
