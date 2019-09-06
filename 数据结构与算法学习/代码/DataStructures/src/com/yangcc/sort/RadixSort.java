package com.yangcc.sort;

import java.util.Arrays;

// 基数排序
public class RadixSort {
    public static void main(String[] args) {
        int arr []= {53,3,748,14,214};

        radixSort(arr);
        System.out.println("排序后的数组："+Arrays.toString(arr));
    }
    // 基数排序方法
    public static void radixSort(int [] arr){

        int index=0;
        // 定一个二位数组，表示10个桶，每个桶就是一维数组
        // 1.二维数组包含10个1维数组，
        // 2.为了防止在放入数的时候，数据溢出，则每个一维数组，大小为arr.length
        // 3.很明确的是，基数排序是使用空间换时间的经典算法
        int [][] bucket =new int [10][arr.length];
        // 为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组，
        // 来记录各个通每次放入的数据个数
        int [] bucketElementCounts=new int[10];
        // 1. 先得到数组中最大的位数
        int max =arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        // 得到最大数的位数
        int maxLength =(max+"").length();
        // 使用循环将代码进行处理
        for (int i=0,n=1;i<maxLength;i++,n*=10){
            // 每一轮轮(针对每个元素的各位进行排序)
            // 第一次个位 二次十位  。。。。
            for (int j =0;j<arr.length;j++){
                // 取出每个元素的个位数
                int digitOfElement =arr[j]/n%10;
                // 放入到对应的桶里
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照桶的顺序（一维数组的下标依次取出数据，放入原数组）
            index =0;
            // 遍历每个桶，并将桶中的数据放入到原数组
            for (int k =0;k<bucketElementCounts.length;k++){
                // 如果桶中有数据，才放入到
                for (int l=0;l<bucketElementCounts[k];l++){
                    // 取出元素放入的arr
                    arr[index]=bucket[k][l];
                    index++;
                }
                // 上一轮处理后，需要将每个bucketElementCounts清零
                bucketElementCounts[k]=0;
            }
        }
        //System.out.println("第一轮"+ Arrays.toString(arr));
    }

}
