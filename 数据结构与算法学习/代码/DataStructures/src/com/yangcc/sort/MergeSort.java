package com.yangcc.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr [] ={8,4,5,7,1,3,6,2};
        int temp []= new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("归并排序后="+ Arrays.toString(arr));

    }
    // 分+合的方法
    public  static  void mergeSort(int [] arr,int left ,int right,int [] temp ){
        if (left<right){
            // 向左递归进行分解
            int mid =(left+right)/2;
            mergeSort(arr,left,mid,temp);
            // 向右递归进行分解
            mergeSort(arr,mid+1,right,temp);
            // 到合并
            merge(arr,left,mid,right,temp);
        }
    }

    // 合并的方法
    /**
     *
     * @param arr  排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid  中间索引
     * @param right  右边索引
     * @param temp  做中转的数组
     */
    public  static  void merge(int [] arr,int left,int mid ,int right,int [] temp){
        int i =left;  // 初始化i ，左边有序序列的初始索引
        int j =mid +1;// 初始化j，右边有序序列的初始索引
        int t =0;// 指向temp数组的当前索引
        // 1.先把左右两边的数据（有序），按照规则填充到temp数组
        // 直到左右两边有序序列有一边处理完毕为止
        while (i<=mid&& j<=right){
            // 如果左边序列当前元素，小于等于右边的，则加到temp中
            if (arr[i]<=arr[j]){
                temp[t]=arr[i];
                t++;
                i++;

            }else{
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        // 2.把有剩余数据的一边的数据依次全部填充到temp
        while (i<=mid){  //左边有序序列还有剩余的元素，全部填充到temp
            temp[t]=arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t]=arr[j];
            j++;
            t++;
        }
        // 3.将temp数组的元素拷贝到arr
        // 并不是每次都拷贝所有
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            tempLeft++;
            t++;
        }
    }



}


