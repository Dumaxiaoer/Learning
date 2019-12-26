package com.yangcc.Stream;

import java.util.*;
import java.util.stream.Stream;

public class Demo01GetStream {
    public static void main(String[] args) {
        // 将集合转化为Stream
        List<String> list=new ArrayList<>();
        Stream<String> stream=list.stream();
        // Set
        Set<String> set=new HashSet<>();
        stream=set.stream();
        // Map
        Map<String,String> map=new HashMap<>();
        Set<String> keySet=map.keySet();
        Stream<String> stream3=keySet.stream();
        // 存储到Collection集合中
        Collection<String> values=map.values();
        Stream<String> stream4=values.stream();
        // 获取键值对（键与值的映射关系）
        Set<Map.Entry<String,String>> entries=map.entrySet();
        Stream<Map.Entry<String, String>> stream1 = entries.stream();
        // 2.将转化数组
        Integer [] arr={1,32,4,5,3,5};
        Stream<Integer> stream6= Stream.of(32,4,2);
        Stream<Integer> stream7=Stream.of(arr);
    }
}
