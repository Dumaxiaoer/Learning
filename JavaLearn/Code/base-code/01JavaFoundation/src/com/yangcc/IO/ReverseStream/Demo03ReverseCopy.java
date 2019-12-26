package com.yangcc.IO.ReverseStream;

import java.io.*;
import java.util.Arrays;

public class Demo03ReverseCopy {
    public static void main(String[] args) throws IOException {
        utf_8ToGbk();
    }
    private static void utf_8ToGbk() throws IOException {
        // 输入流
        InputStreamReader isr=new InputStreamReader(new FileInputStream("D:\\myfile\\test02\\utf_8.txt"),"utf-8");
        // 输出流
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("D:\\myfile\\test02\\gbk.txt"),"gbk");
        // 读取并输出
        char [] cs =new char[20];
        int len=0;
        while ((len=isr.read(cs))!=-1){
            //System.out.println(Arrays.toString(cs));
            osw.write(cs,0,len);
        }
        isr.close();
        osw.close();
    }
}
