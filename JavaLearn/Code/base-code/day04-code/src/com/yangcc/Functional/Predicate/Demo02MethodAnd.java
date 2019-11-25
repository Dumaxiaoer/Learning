package com.yangcc.Functional.Predicate;

import java.util.function.Predicate;

public class Demo02MethodAnd {
    public static void main(String[] args) {
        String s ="dsfgrere";
        boolean b=checkString(s,(str)->{
            return str.length()>5;
        },(str)->{
            return str.contains("f");
        });
        System.out.println(b);
    }


    /*
    定义方法，做俩个判断
     */
    public  static boolean checkString(String s , Predicate<String> p1,Predicate <String> p2){
            //return p1.and(p2).test(s);
            return p1.negate().test(s);
    }
}
