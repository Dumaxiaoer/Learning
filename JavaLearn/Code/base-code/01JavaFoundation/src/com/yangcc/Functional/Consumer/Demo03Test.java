package com.yangcc.Functional.Consumer;

import java.util.function.Consumer;

public class Demo03Test {
    public static void main(String[] args) {
        String[]arr={"苗青青,女","slime,男","麻哥,男"};
        // 调用
        printInfo(arr,(message)->{
            // 消费方式，对msg进行切割
            String name = message.split(",")[0];
            System.out.print("姓名："+name);
        },(message)->{
            // 消费方式，对msg进行切割
            String age = message.split(",")[1];
            System.out.println("；年龄："+age+"。");
        });

    }
    /*
    定义方法，传递数组和两个接口
     */
    private static void printInfo(String []arr, Consumer<String> con1,Consumer<String>con2){
        for (String message : arr) {
            con1.andThen(con2).accept(message);
        }
    }
}
