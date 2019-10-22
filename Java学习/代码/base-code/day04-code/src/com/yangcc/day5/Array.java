package com.yangcc.day5;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int [] arr ={3,2,5,10,48,284,22,443,2,5,7,4};
        //System.out.println(searchMax(arr));
        //sortBubble(arr);

        System.out.println(Arrays.toString(arr));
        reverseArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 找出最大值
    public static int searchMax(int arr[]){
        int temp =arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]>temp){
                temp=arr[i];
            }
        }
        return  temp;
    }

    // 冒泡方法
    public static  void  sortBubble(int arr[]){
        int temp=0;
        // 遍历次数,每次能确定一个数，确定length-1个即可
        for (int i =1;i<arr.length;i++){
            //
            for (int j =0;j<arr.length-i;j++){
                if (arr[j]>arr[j+1]){
                   temp=arr[j+1];
                   arr[j+1]=arr[j];
                   arr[j]=temp;
                }
            }
        }
    }
    // 数组元素反转
    // 对称位置的元素交换
    public static void reverseArr(int [] arr){
        int temp=0;
        for (int i=0;i<arr.length;i++){
            if (i>=arr.length-i-1){
                break;
            }
            temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
    }



}
