package com.yangcc.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
遍历Map集合
两种方法：1.先获取key的集合，再根据key得到value
2.使用entrySet();
 */
public class EntrySet {
    public static void main(String[] args) {
        Map<String,Integer> map =new HashMap<>();
        map.put("你",33);
        map.put("我",26);
        map.put("她",28);
        // 1.使用map集合中的方法entrySet()，把Map集合中多个entry对象取出来，存到集合中
        Set<Map.Entry<String,Integer>> set=map.entrySet();
        // 2.遍历set集合获取每个对象
        Iterator<Map.Entry<String,Integer>> it =set.iterator();
        while (it.hasNext()){
            Map.Entry<String,Integer> entry=it.next();
            // 3.使用Entry对象的方法getKey和value
            String key =entry.getKey();
            int value =entry.getValue();
        }

    }
}
