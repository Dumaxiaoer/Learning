package com.yangcc.domain;

public class Student {
    private Integer ID;
    private String name;
    private String sex;
    private Integer age;
    private String cls;
    private Double salary;

    public Student() {
    }

    public Student(Integer ID, String name, String sex, Integer age, String cls, Double salary) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.cls = cls;
        this.salary = salary;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String
    toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", cls='" + cls + '\'' +
                ", salary=" + salary +
                '}';
    }
}
