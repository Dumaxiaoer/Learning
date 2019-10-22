package com.yangcc.day06;
import java.util.Scanner;
public class Demo01Scanner {
    public static void main(String[] args) {
        // 创建
        Scanner sc=new Scanner(System.in);//从键盘进行输入
        // 获取键盘输入的int数字
        int num =sc.nextInt();
        System.out.println(num);
        // 获取字符串
        String str=sc.next();
        System.out.println(str);
    }


}
