package com.yangcc.day08;

public abstract  class Animal {
    // 构造方法不能new  但可作为子类调用
    public Animal(){
        System.out.println("动物");
    }
    public abstract void eat();

}
