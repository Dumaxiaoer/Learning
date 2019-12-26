package com.yangcc.Properties;

import java.awt.print.PageFormat;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class Demo02Properties {
    public static void main(String[] args) throws IOException {
        sortFile();
    }
    // 使用properties排序
    private static void sortFile() throws IOException {
        // 创建Properties
        Properties p = new Properties();
        p.load(new FileReader("D:\\myfile\\test02\\utf_8.txt"));
        // 创建MAP
        HashMap<String,String> map =new HashMap<>();
        Set<Object> set = p.keySet();
        for(Object obj: p.keySet()){
            map.put(obj.toString(),p.getProperty(obj.toString()));
            //System.out.println(obj.toString());
        }
        System.out.println(map);

    }
}
