package com.yangcc.Functional.Predicate;

import java.util.function.Predicate;

public class Demo01Predicate {
    public static void main(String[] args) {
        String s ="acbd";
        boolean b= checkString(s,(str)->{
            // 对参数传递的字符串进行判断
            return str.length()>6;
        });
        System.out.println(b);
    }

    private static boolean checkString(String s, Predicate<String>pre){
        return pre.test(s);
    }
}
