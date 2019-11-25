package com.yangcc.Functional.Consumer;

import java.util.function.Consumer;

/*
连接两个comsumer接口,再进行消费
谁写前面，谁先消费
 */
public class Demo02AndThen {
    public static void main(String[] args) {
        method("Fuck",(t)->{
            // 将字符串转化为大写
            System.out.println(t.toUpperCase());
        },(t)->{
            System.out.println(t.toLowerCase());
        });

    }

    /*
    定义一个方法，传递一个字符串和两个接口
     */
    private static void method(String s , Consumer<String> con1,Consumer<String> con2){
//        con1.accept(s);
//        con2.accept(s);
        // 使用andthen
        con1.andThen(con2).accept(s);
    }

}
