package com.yangcc.Stream;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo04ListTest {
    public static void main(String[] args) {
        // 第一个集合
        List<String> list1=new ArrayList<>();
        list1.add("维鲁斯");
        list1.add("卡兹克");
        list1.add("维克兹");
        list1.add("拉克丝");
        list1.add("马儿扎哈");
        list1.add("虚空遁地兽");
        list1.add("虚空之眼");

        // 过滤
        Stream<String> Stream1 = list1.stream().filter(name -> name.length() == 3).limit(3);
        // 第二集合
        List<String> list2=new ArrayList<>();
        list2.add("卡萨丁");
        list2.add("艾希");
        list2.add("索拉卡");
        list2.add("虚空恐惧");
        list2.add("德邦总管");
        list2.add("德玛西亚之力");
        list2.add("德玛四世");
        list2.add("拉莫斯");
        Stream<String> stream2 = list2.stream().filter(name -> name.contains("德")).skip(1);
        Stream.concat(Stream1,stream2).map(name->new Person(name)).forEach(p-> System.out.println(p));
    }
}
