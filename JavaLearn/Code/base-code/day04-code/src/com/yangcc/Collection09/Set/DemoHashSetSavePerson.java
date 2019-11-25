package com.yangcc.Collection09.Set;

import java.util.HashSet;

/*
重写hashCode和equals方法
要求：同名同年龄，视为同一个任
 */
public class DemoHashSetSavePerson {
    public static void main(String[] args) {
        // 创建HaseSet集合
        HashSet<Person> set =new HashSet<>();
        Person p1= new Person("你", 20);
        Person p2= new Person("你", 20);
        Person p3= new Person("你", 20);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
    }
}
