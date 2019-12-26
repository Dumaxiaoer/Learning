package com.yangcc.Functional.Lambda;

import java.util.Arrays;
import java.util.Comparator;

/*
函数式接口作为返回类型
 */
public class Demo03Comparator {
    public static void main(String[] args) {
        String []arr={"aaa","bb","cccc","d"};
        // 调用sort,对数组进行排序
        Arrays.sort(arr,getComparator());
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,((o1, o2) -> o1.length()-o2.length()));
        System.out.println(Arrays.toString(arr));
    }



    public static Comparator<String> getComparator(){
//        return  new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                // 降序
//                return o2.length()-o1.length();
//            }
//        };
        /*
        优化，返回lambda表达式
         */
//        return (String o1,String o2)->{
//            return o2.length()-o1.length();
//        };
        return (o1,o2)->o2.length()-o1.length();
    }
}
