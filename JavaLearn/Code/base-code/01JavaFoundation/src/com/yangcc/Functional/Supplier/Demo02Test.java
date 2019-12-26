package com.yangcc.Functional.Supplier;

import java.util.function.Supplier;

public class Demo02Test {
    public static void main(String[] args) {
       // 定义数组
       int arr[]={200,120,47,28,385};
       // 调用方法
        int max=getMax(()->{
            // 获取数组最大值并返回
            int maxTemp=arr[0];
            // 遍历数组，获取最大值
            for(int i=1;i<arr.length;i++){
                if (maxTemp<arr[i]){
                    maxTemp=arr[i];
                }
            }
            return maxTemp;
        });
        System.out.println(max);
    }
    // 定义方法，用于获取数组元素的最大值
    private static int getMax(Supplier<Integer> sup){
        return sup.get();
    }
}
