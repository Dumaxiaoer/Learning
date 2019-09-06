package com.yangcc.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        int [] arr ={8,9,1,7,2,3,5,4,6,0};
        //shellSort(arr);
        System.out.println("希尔排序前："+Arrays.toString(arr));
        shellSortMove(arr);
        System.out.println("希尔排序后："+ Arrays.toString(arr));

//        int [] arr =new int[80000];
//        for (int i=0;i<80000;i++){
//            arr[i]=(int)(Math.random()* 8000000);
//        }
//        // 测试排序前的时间
//        Date date1=new Date();
//        SimpleDateFormat simpleDateFormat=  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str =simpleDateFormat.format(date1);
//        System.out.println("排序前的时间="+date1Str);
//        // 测试冒泡排序
//        shellSort(arr);
//        Date date2=new Date();
//        String date2Str =simpleDateFormat.format(date2);
//        System.out.println("排序后的时间="+date2Str);

    }

    // 正式表达式  （希尔排序 ----- 交换法）
    public  static void  shellSort(int [] arr){
        int temp =0;
        for (int gap=arr.length/2;gap>0;gap/= 2){
            // 该数组分为n组，则就将数组的第n+1个元素作为基本位e（需要参与各种比较，寻找自己位置的元素），
            // 这样就必然会留出至少一个比较元素f，若f>e,则位置向前移动，直到<0跳出循环
            for (int i=gap;i<arr.length;i++){
                // 遍历各数组中所有元素（共5组，每组两个元素），步长5
                // 这里的j类似于普通插入排序中的index，一开始就在同一分组的基本位的前一位置
                for (int j=i-gap;j>=0;j-=gap){
                    // 如果当前元素大于加上步长后的那个数，说明交换
                    // 这里类似于冒泡排序，在条件范围内，相邻两元素间进行比较，直到最小元素挪到最前
                    // 本身同一元素移动一轮只能将最小移动至最前而无法改变其序列，但元素是从第一个开始，所以移动过后的序列均为有序序列
                    // 因为其以交换的形式实现序列的排序，因此成为希尔排序，交换法
                    if (arr[j]>arr[j+gap]){
                        temp =arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }
    }

    //使用逐步推导法   （希尔排序 --- 交换法）
    public  static  void  shellSortAnalysis(int [] arr){
        // 希尔排序依次伦
        int temp=0;
        // 第一轮，分为5组
        for (int i=5;i<arr.length;i++){
            // 遍历各数组中所有元素（共5组，每组两个元素），步长5
            for (int j=i-5;j>=0;j-=5){
                // 如果当前元素大于加上步长后的那个数，说明交换
                if (arr[j]>arr[j+5]){
                    temp =arr[j];
                    arr[j]=arr[j+5];
                    arr[j+5]=temp;
                }
            }
        }
        // 第二轮，分为2组
        for (int i=2;i<arr.length;i++){
            // 遍历各数组中所有元素（共5组，每组两个元素），步长5
            for (int j=i-2;j>=0;j-=2){
                // 如果当前元素大于加上步长后的那个数，说明交换
                if (arr[j]>arr[j+2]){
                    temp =arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                }
            }
        }
        // 第三轮，分为1组
        for (int i=1;i<arr.length;i++){
            // 遍历各数组中所有元素（共5组，每组两个元素），步长5
            for (int j=i-1;j>=0;j-=1){
                // 如果当前元素大于加上步长后的那个数，说明交换
                if (arr[j]>arr[j+1]){
                    temp =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    // 希尔排序  ----- 移动法
    public static  void shellSortMove(int [] arr){
        // 定义一个temp ，来保存基本位的数值，用于做比较
        int temp = 0;
        // 定义一个index ，来表示同组中基本位前一位的下标
        int index = 0;
        // 分组，每层/2,取整则能保证每组至少包含两个数
        for (int gap = arr.length/2;gap>0;gap/=2){
            for(int i =gap;i<arr.length;i++){
                temp =arr[i];
                index =i-gap;
                // 如果位置不是你的，继续找，没执行完成这一步，index向前移动，空出开的位置则编程了index+gap
                // 如果是index<0 而跳出循环，表示没有找到位置，只能坐第一排，如果是arr[index]<temp 则表示找到位置，跳出循环
                while (index>=0&&arr[index]>temp){
                    // 向后移动一位，将index 位空出来
                    arr[index+gap]=arr[index];
                    index-=gap;
                }
                // 退出循环则表示位置已经找到  ，确认可以坐在腾出来的位置
                arr[index+gap]=temp;
            }
        }
    }









}
