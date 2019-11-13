package com.yangcc.File;

import java.io.File;

public class Demo01File {
    public static void main(String[] args) {
        File f1=new File("D:\\myfile\\a.txt");
        String absolutePath=f1.getAbsolutePath();
        File f2 =new File("a.txt");
        System.out.println(absolutePath);
        String obsolutePath2=f2.getAbsolutePath();
        System.out.println(obsolutePath2);
    }
}
