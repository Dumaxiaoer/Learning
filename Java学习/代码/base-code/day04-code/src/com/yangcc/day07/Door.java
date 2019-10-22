package com.yangcc.day07;

public class Door {
    public static void main(String[] args) {
        Student stu=new Student("张三",23);
        Student stu2=new Student("李四",19);
        stu.room="教师222";
        System.out.println(stu.toString()+stu.room);
        System.out.println(stu2.toString()+stu2.room);

    }
}
