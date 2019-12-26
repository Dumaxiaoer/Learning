package com.yangcc.IO.PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo01PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        // 创建
        PrintStream ps =new PrintStream("D:\\myfile\\test02\\print.txt");
        // 写数据
        ps.write(97);
        ps.println(97);
        ps.close();
    }
}
