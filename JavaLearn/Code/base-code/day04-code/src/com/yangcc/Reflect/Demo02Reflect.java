package com.yangcc.Reflect;

import java.lang.reflect.Field;

public class Demo02Reflect {
    public static void main(String[] args) throws Exception {
        // 0.获取class对象
        Class<Person> personClass = Person.class;
        // 1.获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("二-------------");
        // 2.获取所有成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        // 私有的成员变量无法访问，要想访问，必须手动忽略
        Person p=new Person();
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);// 暴力反射
        Object value=name.get(p);
        System.out.println(value);
    }
}
