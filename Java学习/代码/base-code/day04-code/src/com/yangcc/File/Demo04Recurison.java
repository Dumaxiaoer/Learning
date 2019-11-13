package com.yangcc.File;

import javax.sound.midi.Soundbank;
import java.io.File;

/*
使用递归打印多级目录
 */
public class Demo04Recurison {
    public static void main(String[] args) {
        File file =new File("D:\\Users\\Administrator\\Desktop\\总文件\\个人资料\\话费电子发票");
        getAllFile(file);
    }
    // 定义方法传递file类型目录
    // 方法中对目录进行遍历
    private static void getAllFile(File dir){
        File[] files=dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                System.out.println(file.toString()+"Begin");
                getAllFile(file);
            }
            System.out.println(file.toString()+"end");
        }
    }
}
