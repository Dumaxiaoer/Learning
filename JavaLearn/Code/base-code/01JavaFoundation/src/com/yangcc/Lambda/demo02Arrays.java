package com.yangcc.Lambda;
import com.yangcc.day5.Array;
import java.util.Arrays;
import java.util.Comparator;

public class demo02Arrays {
    public static void main(String[] args) {
        // 使用数组存储多个person
        Person [] arr={new Person("ni",36),
                    new Person("我",28),
                    new Person("她",29)};
        // 按年龄对其排序
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();// 升序
            }
        });
        for (Person person : arr) {
            System.out.println(person);
        }
        // 使用lambda
        Arrays.sort(arr,(Person o1,Person o2)->{
            return o1.getAge()-o2.getAge();
        });
        // 省略
        Arrays.sort(arr,(o1,o2)->o1.getAge()-o2.getAge());
    }
}
