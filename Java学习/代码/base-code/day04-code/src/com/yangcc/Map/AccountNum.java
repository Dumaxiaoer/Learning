package com.yangcc.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        // 使用map集合来储存键值对
        Map<Character,Integer> map = new HashMap<>();
        // 将字符串转为字符数组
        char ch[] = in.toCharArray();
        for (char c : ch) {
            if (map.containsKey(c)){
                int value =map.get(c);
                value++;
                map.put(c,value);
            }else {
                map.put(c,1);
            }
        }
        System.out.println(map);
    }
}
