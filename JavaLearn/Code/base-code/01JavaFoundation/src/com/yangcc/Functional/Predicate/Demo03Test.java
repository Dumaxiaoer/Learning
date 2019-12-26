package com.yangcc.Functional.Predicate;

import com.yangcc.day5.Array;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
筛选，名字为3个字，全是女生
 */
public class Demo03Test {
    public static void main(String[] args) {
        String [] s={"苗青青吾，女","司空月，女","孟星魂，男","上官灵越，女"};
        ArrayList list=chooseStr(s,(str)->{
            return str.split("，")[1].equals("女");
        },(str)->{
            return str.split("，")[0].length()==4;
        });
        System.out.println(list);
    }
    private static ArrayList<String> chooseStr(String [] arr, Predicate<String> p1, Predicate<String>p2){
        ArrayList<String> list=new ArrayList<>();
        // 遍历数组
        for (String s : arr) {
           boolean b= p1.and(p2).test(s);
           if (b){
               //成立
               list.add(s);
           }
        }
        return list;
    }

}
