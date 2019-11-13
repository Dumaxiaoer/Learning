package com.yangcc.IO.OutputStream;


import java.io.FileOutputStream;
import java.io.IOException;

/*
    将内存中数据写入到硬盘
 */
public class Demo01FileOutputStream {
    public static void main(String[] args) throws IOException {
        // 1.创建对象
        FileOutputStream fos=new FileOutputStream("D:\\myfile\\test\\a.txt");
        // 2.将数据写入文件
        fos.write(97);
        // 3.释放资源
        fos.close();
    }

}
