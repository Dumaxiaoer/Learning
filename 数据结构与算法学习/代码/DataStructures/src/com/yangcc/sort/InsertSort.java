package com.yangcc.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int arr[] ={101,34,119,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 插入排序
    public static void insertSort(int [] arr){
        // 使用逐步推导的方式
        // 第一个数字就当成是有序列表   从第二个数字开始定位
        for (int i=1;i<arr.length;i++){
            // 定义待插入的数
            int insertValue =arr[i];
            // arr[1]前面这个数的下标
            int insertIndex=i-1;
            // 给insertValue找到插入的位置
            // 1.保证给insertValue找插入位置时不越界
            // 2.insertValue<arr[insertIndex] 待插入的数，还没找到插入位子位置
            // 3.将arr[insertIndex] 后移
            while (insertIndex>=0&&insertValue<arr[insertIndex]){
                // 把与之比较的值向后挪一位
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex --;
            }
            // 当退出插入循环时，说明插入的位置找到
            // 如果位置有进行移动
            if (insertIndex!=i-1){
                arr[insertIndex+1]=insertValue;
            }
        }
    }
}
