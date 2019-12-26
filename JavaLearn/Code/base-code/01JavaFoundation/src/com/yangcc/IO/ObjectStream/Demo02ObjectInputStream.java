package com.yangcc.IO.ObjectStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/*
反序列化，将文件中的对象，读取到内存
 */
public class Demo02ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1.创建对象
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:\\myfile\\test02\\obj.txt"));
        // 2.读取
        Object o=ois.readObject();
        // 3.释放
        ois.close();
        // 4.使用
        System.out.println((Person)o);
    }
}
