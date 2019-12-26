package com.yangcc.Properties;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class Demo01Properties {
    public static void main(String[] args) throws IOException {
        //show01();
        //storeData();
        loadData();
    }

    /*
        使用Properties集合存储数据，遍历取出Properties集合中数据

     */
    private static void show01(){
        // 创建集合对象
        Properties prop=new Properties();
        // 添加数据
        prop.setProperty("he", "32");
        prop.setProperty("you", "23");
        prop.setProperty("me", "28");
        // 把集合中的键取出
        Set<String> set = prop.stringPropertyNames();
        // 遍历取出properteis
        for (String key : set) {
            // 获取值
            String value = prop.getProperty(key);
            System.out.println(key+"="+value);
        }
    }
    /*
    store方法的使用，写入到硬盘
    注释一般不使用中文，因为默认unicode编码，会乱码
    字节流不能写中文
     */
    private static  void  storeData() throws IOException {
        // 1.创建集合对象 并添加数据
        Properties prop=new Properties();
        prop.setProperty("he", "32");
        prop.setProperty("you", "23");
        prop.setProperty("me", "28");
        // 2.创建字符流
        FileWriter fw=new FileWriter("D:\\myfile\\test\\prop.txt");
        // 3.使用方法，持久化数据
        prop.store(fw,"save data");
        fw.close();
    }
    /*
        读取
        字节流不能读取中文字符串
        文件中：键值对中默认连接符  = 或者空格
        # 进行注释
     */
    private static  void loadData() throws IOException {
        Properties prop=new Properties();
        prop.load(new FileReader("D:\\myfile\\test\\prop.txt"));
        System.out.println(prop);

    }

}
