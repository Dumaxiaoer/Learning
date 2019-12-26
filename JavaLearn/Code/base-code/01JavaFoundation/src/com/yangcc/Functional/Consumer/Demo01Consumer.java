package com.yangcc.Functional.Consumer;

import java.util.function.Consumer;

public class Demo01Consumer {
    public static void main(String[] args) {
        method("我真不知这玩意儿用来干啥",(String name)->{
            System.out.println(name);
        });
    }


    private static void method(String name, Consumer<String> con){
        con.accept(name);
    }
}
