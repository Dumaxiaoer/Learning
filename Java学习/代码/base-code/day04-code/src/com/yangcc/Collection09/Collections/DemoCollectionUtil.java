package com.yangcc.Collection09.Collections;

import com.yangcc.day5.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
collections常用方法
 */
public class DemoCollectionUtil {
    public static void main(String[] args) {
        ArrayList<String>list =new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        ArrayList<Person> list3=new ArrayList<>();

        // 1.向集合中添加多个元素
        Collections.addAll(list,"a","v","d");
        // 2.将集合中元素升序排序
        // 注意：使用前提，被排序的集合存储的元素，必须实现comparable
        /*
        comparable排序规则：自己-参数=升序    参数-自己=降序
         */
        Collections.sort(list2);
        Collections.sort(list3);
        // 或者  升序 该方法不用在类里实现接口
        Collections.sort(list3, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result= o1.getAge()-o2.getAge();
                if (result==0){
                    result=o1.getName().charAt(0)-o2.getName().charAt(0);
                };
                return result;
            }
        });


        // 3.
    }
}
