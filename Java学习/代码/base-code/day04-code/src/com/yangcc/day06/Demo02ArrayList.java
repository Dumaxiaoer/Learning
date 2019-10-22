package com.yangcc.day06;

import com.yangcc.day5.Array;

import java.util.ArrayList;

public class Demo02ArrayList {
    public static void main(String[] args) {
        // 常用方法
        ArrayList<String> list = new ArrayList<>();
        // 1.向集合中添加元素，有返回值，代表添加是否成功
        boolean success = list.add("疯子");
        list.add("魔鬼");
        list.add("欲望");
        System.out.println(list);
        // 2.从集合中获取元素
        String name =list.get(2);
        // 3.删除
        String removeWho =list.remove(1);
        // 4.获取长度
        int size =list.size();
    }

}
