package com.yangcc.Functional.Function;
/*
 andThen();
 */

import java.util.function.Function;

public class Demo02Test {
    public static void main(String[] args) {
        String s="杨成灿，26";
        int in=change(s,(str)->{
            return str.split("，")[1];
        },(str)->{
            return Integer.parseInt(str)+10;
        },(i)->{
            return i+100;
        });
        System.out.println(in);
    }
    /*
    三次转换
     */
    private static int change(String s, Function<String ,String> f1,Function<String,Integer> f2,Function<Integer,Integer> f3){
        return  f1.andThen(f2).andThen(f3).apply(s);
    }
}
