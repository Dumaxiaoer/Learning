package com.yangcc.IO.Writer;

import java.io.FileWriter;
import java.io.IOException;

/*
    写入字符数据的其他方法
 */
public class Demo02FileWriter {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("D:\\myfile\\test\\a.txt");
        // 1.字符数组写入
        char [] cs={'2','我','f','d','c'};
        fw.write(cs);
        // 2.写入字符数组的一部分
        fw.write(cs,0,3);
        // 3.写字符串
        fw.write("一群傻x");
        // 4.字符串一部分
        fw.write("shitguy可以",3,5);
        fw.close();
    }
}
