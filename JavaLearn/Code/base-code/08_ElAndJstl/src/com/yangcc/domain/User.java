package com.yangcc.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String name;
    private  int age;
    private Date brithday;

    public String getBirthday(){
        if (brithday!=null){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(brithday);
        }
        return "";
    }

    public User() {
    }

    public User(String name, int age, Date brithday) {
        this.name = name;
        this.age = age;
        this.brithday = brithday;
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

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", brithday=" + brithday +
                '}';
    }
}
