package com.yangcc.IO.ReverseStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
转换流，字符输出
字符通向字节的桥梁，看懂的转为看不懂的，过程编码
 */
public class Demo01OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        //write_utf_8();
        write_gbk();
    }
    /*
    使用转换流OutputStream 写utf-8
     */
    private static  void write_utf_8() throws IOException {
        // 1.创建转化输出流
        OutputStreamWriter osw =new OutputStreamWriter(new FileOutputStream("D:\\myfile\\test\\utf_8.txt"),"utf-8");
        // 2.写入
        osw.write("罪恶将知道，什么是痛苦");
        // 3.刷新
        osw.flush();
        // 4.关闭
        osw.close();
    }
    /*
   使用转换流OutputStream 写gbk
    */
    private static  void write_gbk() throws IOException {
        // 1.创建转化输出流
        OutputStreamWriter osw =new OutputStreamWriter(new FileOutputStream("D:\\myfile\\test\\gbk.txt"),"gbk");
        // 2.写入
        osw.write("罪恶将知道，什么是痛苦");
        // 3.刷新
        osw.flush();
        // 4.关闭
        osw.close();
    }
}
