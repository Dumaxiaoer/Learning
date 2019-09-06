package com.yangcc.sort;

import java.util.Arrays;

// 快速排序
public class QuickSort {
    public static void main(String[] args) {
       // int [] arr ={8,2,1,7,2,5,9,2,6,5,-1};
        int [] arr ={0,1,2,3,4,5,8,9,3,5,6,7};
        quickSort(arr,0,arr.length-1);
        System.out.println("arr"+ Arrays.toString(arr));
    }

    /**
     *
     * @param arr  数组
     * @param left  最左索引
     * @param right  最右边索引
     */
    public static  void quickSort(int [] arr,int left,int right){
        int l =left;
        int r =right;
        // 中轴
        int pivot = arr[(left+right)/2];
        int temp = 0; //临时变量，作为交换时使用
        // while 循环的目的，是让比pivot小的值放到左边，
        // 比pivot大的放到右边
        while (l<r){
            // 左边一直找，找到大于定于pivot的值，才退出
            while (arr[l]<pivot){
                l+=1;
            }
            while (arr[r]>pivot){
                r-=1;
            }
            // 如果1>=r 说明pivot的左右两边值都按照
            if (l>=r){
                break;
            }
            // 交换
            temp =arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            // 这儿的代码为了使等于pivot的值向中位数靠拢并且必然让两者相等陷入死循环
            // 如果交换完后，发现 arr[l]=pivot ,则前移
            if (arr[l]==pivot){
                r-=1;
            }
            // 如果交换完后，发现 arr[r]=pivot ,则后移
//            if (arr[r]==pivot){
//                l+=1;
//            }
        }
        // 如果l==r 必须 l++ r-- 否则会出现栈溢出
        if (l==r){
            l+=1;
            r-=1;
        }
        // 向左递归
        if (left<r){
            quickSort(arr,left,r);
        }
        if (right>l){
            quickSort(arr,l,right);
        }
    }
}
