package com.yangcc.day06;

public class Demo03String {
    public static void main(String[] args) {
        // 1.空参
        String str=new String();
        // 2.字符数组
        char[] charArray={'A','B','C'};
        String str2=new String(charArray);
        // 3.根据字节数组创建
        byte[] byteArray={98,99,87};
        String str3=new String(byteArray);
        System.out.println(str3);
    }
}
