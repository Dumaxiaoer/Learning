package com.yangcc.IO.ReverseStream;

import com.sun.source.tree.WhileLoopTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
解码
 */
public class Demo02InputStreamReader {
    public static void main(String[] args) throws IOException {
        read_utf_8();

    }
    private static void read_utf_8() throws IOException {
        // 1.创建
        InputStreamReader isr=new InputStreamReader(new FileInputStream("D:\\myfile\\test\\gbk.txt"),"gbk");
        // 2.读取
        int len =0;
        while((len=isr.read())!=-1){
            System.out.println((char)len);
        }
        // 3.释放资源
        isr.close();
    }

}
