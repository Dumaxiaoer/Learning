package com.yangcc.Anotation;
@MyAnno(age=12,show="2",per=Person.p2,anno2=@MyAnno02(name = "Animal"),str = {"1","2","3"})
@MyAnno03
public class Demo02Anotation {
    @MyAnno03
    String name;
    @MyAnno03
    public void show(){

    }

}
