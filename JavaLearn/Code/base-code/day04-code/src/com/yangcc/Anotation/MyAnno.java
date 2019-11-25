package com.yangcc.Anotation;

public @interface MyAnno{
    // 字符串类型
    public String show();
    // int
    int age();
    // 默认赋值
    String name() default "苗青青";
    // 枚举类
    Person per();
    // 注解类
    MyAnno02 anno2();
    // 数组类
    String [] str();
}
