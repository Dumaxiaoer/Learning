package com.yangcc.IO.ObjectStream;

import java.io.Serializable;

/*
Serializable接口也叫标记性接口，要序列化和反序列化的类，必须实现该接口

 */
public class Person implements Serializable {
    // 声明序列号，防止反序列化时因序列号不同而出现的异常
    private static final long serialVersionUID=1L;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
