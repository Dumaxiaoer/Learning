package com.yangcc.IO.ObjectStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
序列化流，将对象保存到文件
以字节流的形式
 */
public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        // 1.创建序列化流对象
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("D:\\myfile\\test02\\obj.txt"));
        // 2.写入对象
        oos.writeObject(new Person("苗青青",28));
        // 3.释放
        oos.close();
   }
}
