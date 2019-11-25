package com.yangcc.File;

import java.io.File;

public class Demo05Recurison {
    public static void main(String[] args) {
        File file =new File("D:\\Users\\Administrator\\Desktop\\总文件\\个人资料\\话费电子发票");
        getAllFile(file);
    }
    private static void getAllFile(File dir){
        File[] files=dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                // System.out.println(file.toString()+"Begin");
                getAllFile(file);
            }
            String s =file.toString();
            if (s.endsWith(".png")){
                System.out.println(s);
            }
        }
    }

}
