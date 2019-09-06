package com.yangcc.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
// 选择排序
// 效率比冒泡排序高
/*
总结：1.先定位元素  并将其设置为虚拟最小
     2.将定位的元素与后面的依次进行比较，移动虚拟最小及其下标
 */

public class SelectSort {
    public static void main(String[] args) {
//        int arr[] ={101,34,119,1,5,0,294,38,42};
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        selectSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));
        int [] arr =new int[80000];
        for (int i=0;i<80000;i++){
            arr[i]=(int)(Math.random()* 8000000);
        }
        // 测试排序前的时间
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str =simpleDateFormat.format(date1);
        System.out.println("排序前的时间="+date1Str);
        // 测试冒泡排序
        selectSort(arr);
        Date date2=new Date();
        String date2Str =simpleDateFormat.format(date2);
        System.out.println("排序后的时间="+date2Str);
    }


    // 选择排序
    public  static void selectSort(int []arr){
        // 使用逐步推导方式  第一轮 二轮 三轮
        for (int i =0;i<arr.length-1;i++){
            // 假定最小索引  前后比较
            int minIndex=i;
            int min =arr[i];
            for (int j =i+1;j<arr.length;j++){
                if (min>arr[j]){ //说明假定的值不是最小
                    min=arr[j];//重置最小值
                    minIndex=j;// 重置下标
                }
            }
            // 将最小值，与数组开始进行交换
            if (minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
}



