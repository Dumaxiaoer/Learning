package com.yangcc.IO.Writer;

import java.io.FileWriter;
import java.io.IOException;

/*
FileWriter  将内存中字符数据写入文件
 */
public class Demo01FileWriter {
    public static void main(String[] args) throws IOException {
        // 1.创建
        FileWriter fw =new FileWriter("D:\\myfile\\test\\a.txt");
        // 2.写入
        fw.write(99);
        // 3.刷新 ，将字符写入到内存缓冲区，转化为字节的过程
        fw.flush();
        // 4.关闭
        fw.close();
    }
}
