package com.yangcc.day06;

/*
* 1.首先产生一个随机数字，
* 2.需要键盘输入
* 3.获取键盘输入的数字
* 4.如果太大/小，提示太大/小，重试
* 5.循环次数不确定，while
* */


import java.util.Random;
import java.util.Scanner;

public class GuessRandomNum {
    public static void main(String[] args) {
        Random r=new Random();
        int randomNum=r.nextInt(100)+1;//1-100
        Scanner sc=new Scanner(System.in);

        while (true){
            System.out.println("请输入猜测的数字");
            int guessNum=sc.nextInt();
            if (randomNum<guessNum){
                System.out.println("太大，重试");
            }else if (randomNum>guessNum){
                System.out.println("太小，重试");
            }else{
                System.out.println("猜中");
                break;
            }
        }


    }
}
