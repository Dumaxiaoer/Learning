package com.yangcc.Stream;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo03StreamMethod {
    public static void main(String[] args) {
        // 0.创建集合并转化为流
        List<String> list=new ArrayList<>();
        list.add("维鲁斯");
        list.add("卡兹克");
        list.add("维克兹");
        list.add("拉克丝");
        list.add("马儿扎哈");
        list.add("虚空遁地兽");
        list.add("虚空之眼");
        Stream<String> stream=list.stream();
        Integer arr[]={3,5,2,5,65,23};
        Stream <Integer> iStream= Stream.of(arr);
        String strArr[]={"3","4","6","23","31"};
        Stream <String> sStream= Stream.of(strArr);

        // 1.调用forEach,输出内容
        // forEach();
        // 2.过滤
        //filterStream(stream);
        // 3.映射
        // mapStream(sStream);
        // 4.统计个数
        //countStream(iStream);

        // 7.组合
        Stream.concat(stream,sStream).forEach(name-> System.out.println(name));
    }
    /*
       1.forEach();
     */
    private static void forEach(){
        Stream<String> stream = Stream.of("你", "我", "他", "you", "he", "me");
//        stream.forEach((name)->{
//            System.out.println(name);
//        });
        stream.forEach(name-> System.out.println(name));
    }
    /*
        2.filter
     */
    private static void filterStream(Stream<String> stream){
        // 对元素进行过滤
        stream.filter(name->name.contains("克")).forEach(name-> System.out.println(name));

    }
    /*
        3.映射
     */
    private static void mapStream(Stream<String> stream){
        Stream<Integer> integerStream = stream.map(s -> Integer.parseInt(s));
        integerStream.forEach(name-> System.out.println(name));
    }
    /*
        4.统计个数,
     */
    private static void countStream(Stream<Integer> stream){
        System.out.println(stream.count());
    }

    /*
        5.取用前几个
     */
    private static void limitStream(Stream<String>stream){
        Stream<String> limit = stream.limit(3);
        limit.forEach(name-> System.out.println(name));
    }
    /*
        6.跳过前几个
     */
    private static void skipStram(Stream<String>stream){
        stream.skip(3).forEach(name-> System.out.println(name));
    }


}
