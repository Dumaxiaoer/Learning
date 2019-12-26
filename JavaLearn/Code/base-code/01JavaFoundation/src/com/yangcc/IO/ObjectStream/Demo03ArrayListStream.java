package com.yangcc.IO.ObjectStream;

import java.io.*;
import java.util.ArrayList;

public class Demo03ArrayListStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializable();
    }

    /*
    序列化
     */
    private static void serializable() throws IOException, ClassNotFoundException {
        // 1.创建ArrayList集合
        ArrayList<Person> list=new ArrayList<>();
        // 2.存储对象
        list.add(new Person("你",20));
        list.add(new Person("我",26));
        list.add(new Person("他",28));
        // 3.创建流对象
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("D:\\myfile\\test02\\list.txt"));
        // 4.写入
        oos.writeObject(list);
        // 5.创建反序列化
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:\\myfile\\test02\\list.txt"));
        // 6.读取
        Object o =ois.readObject();
        // 7.转化为集合
        ArrayList<Person> list2=new ArrayList<>();
        list2=(ArrayList<Person>)o;
        // 8.遍历
        for (Person person : list2) {
            System.out.println(person);
        }
        // 9.关闭
        oos.close();
        ois.close();
    }

}
