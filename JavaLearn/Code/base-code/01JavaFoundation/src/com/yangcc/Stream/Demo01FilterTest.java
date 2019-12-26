package com.yangcc.Stream;

import java.util.ArrayList;
import java.util.List;

public class Demo01FilterTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("苗青青");
        list.add("司空摘星");
        list.add("司徒王朗");
        list.add("诸葛村夫");
        list.add("梁逸风");
        // 使用Stream流对其进行过滤
        list.stream().filter((name)->name.contains("司"))
            .filter(name->name.length()==4)
            .forEach(name-> System.out.println(name));
    }
}
