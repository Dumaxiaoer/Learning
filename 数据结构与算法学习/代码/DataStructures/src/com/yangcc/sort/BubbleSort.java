package com.yangcc.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;

// 冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
//        int arr [] ={2,-3,9,4,29,4};
//        bubbleSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));
        // 测试一下冒泡排序的速度O（n^2）,给80000 个数据，测试
        // 创建80000个的随机数组
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
        bubbleSort(arr);
        Date date2=new Date();
        String date2Str =simpleDateFormat.format(date2);
        System.out.println("排序后的时间="+date2Str);
    }

    // 将前面的冒泡排序封装为一个方法
    public  static  void bubbleSort(int [] arr){
        // 第一趟排序，就是将最大的数排在最后
        int temp=0; //临时变量 用于比较
        boolean flag =false;//标识变量，表示是否进行过交换

        for (int i =0;i<arr.length-1;i++){
            for (int j =0;j<arr.length-1-i;j++){
                // 如果前面数比后面大则交换
                if (arr[j]>arr[j+1]){
                    flag =true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            //System.out.println("第"+(i+1)+"次排序");
            //System.out.println(Arrays.toString(arr));
            if (!flag){  // 说明在一趟大的排序中，一次交换都没有发生
                break;
            }else {
                flag=false;// 重置flag，进行下次判断
            }
        }

    }
}
