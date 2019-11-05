package com.yangcc.Collection09.List;
/*
斗地主
1.准备牌
2.洗牌
3.发牌
4.看牌

 */

import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    public static void main(String[] args) {
        // 1.准备牌
        // 定义一个存储54张牌的集合
        ArrayList<String> poker=new ArrayList<>();
        // 定义两个数组组装牌
        String [] colors={"♥","♠","♣","♦"};
        String [] numbers={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        // 先把大小王放到扑克中
        poker.add("🃏");
        poker.add(("🃏"));
        // 循环遍历两个数组，组装52张牌
        for (String number : numbers) {
            for (String color : colors) {
                // 将组装的牌存到集合中
                poker.add(color+number);
            }
        }
        System.out.println(poker);
        // 2.洗牌 使用集合工具类
        // 使用shuffle   打乱集合顺序
        Collections.shuffle(poker);
        System.out.println(poker);
        // 3.发牌
        // 定义四个集合来存储玩家的牌
        ArrayList<String> p1 = new ArrayList<>();
        ArrayList<String> p2 = new ArrayList<>();
        ArrayList<Object> p3 = new ArrayList<>();
        ArrayList<String> under = new ArrayList<>();
        // 遍历扑克集合，获取每张牌
        for (int i = 0; i <poker.size() ; i++) {
            // 预留底牌
            if (i>=51){
                under.add(poker.get(i));
            }else if(i%3==0){
                p1.add(poker.get(i));
            }else if (i%3==1){
                p2.add(poker.get(i));
            }else if (i%3==2){
                p3.add(poker.get(i));
            }
        }
        // 看牌
        System.out.println("你"+p1);
        System.out.println("我"+p2);
        System.out.println("他"+p3);
        System.out.println("底牌"+under);
    }
}
