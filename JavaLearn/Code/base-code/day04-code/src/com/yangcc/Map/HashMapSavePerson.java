package com.yangcc.Map;

import java.util.HashMap;
import java.util.Set;

/*
    用HashMap存储自定义的键值对
    Map集合必须保证Key是唯一的  所以必须重写hashCode和equals方法
 */
public class HashMapSavePerson {
    public static void main(String[] args) {
        show02();
    }

    /*
     * key使用String value使用类
     * String 类重写了haseCode和equals方法，可以保证值是唯一的
     */
    private static void show01(){
        // 创建集合
        HashMap<String,Person> map=new HashMap<>();
        // 往集合中添加元素
        map.put("北京",new Person("你",28));
        map.put("重庆",new Person("我",27));
        Set<String> set= map.keySet();
        for (String key : set) {
            Person value = map.get(key);
            System.out.println(key+"--------"+value);
        }
    }
    /*
    key 使用Person，必须保证唯一,重写equal和hashcode方法
     */
    private static void show02(){
        // 创建集合
        HashMap<Person,String> map=new HashMap<>();
        // 往集合中添加元素
        map.put(new Person("你",28),"北京");
        map.put(new Person("我",27),"重庆");
        map.put(new Person("我",27),"重庆");
        Set<Person> set= map.keySet();
        for (Person key : set) {
            String value = map.get(key);
            System.out.println(key+"--------"+value);
        }

    }
}
