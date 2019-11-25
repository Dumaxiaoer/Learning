package com.yangcc.domain;
/*
实体类，封装数据
 */
public class Student {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String cls;

    public Student() {
    }

    public Student(int id, String name, String sex, int age, String cls) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.cls = cls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", cls='" + cls + '\'' +
                '}';
    }
}
