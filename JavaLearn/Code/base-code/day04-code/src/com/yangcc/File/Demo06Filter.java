package com.yangcc.File;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Demo06Filter {
    public static void main(String[] args) {
        File file =new File("D:\\Users\\Administrator\\Desktop\\总文件\\个人资料\\话费电子发票");
        getAllFile(file);
    }
    private static void getAllFile(File dir){
        File[] files=dir.listFiles(new FileFilterImpl());
        for (File file : files) {
            if (file.isDirectory()){
                getAllFile(file);
            }else{
                System.out.println(file.toString());
            }
        }
    }
    // 使用匿名内部类
    private static void getAllFile2(File dir){
        /*File [] files =dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()){
                    return true;
                }
                return pathname.getName().toLowerCase().endsWith(".png");
            }
        });
         */
        File [] files =dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".png");
            }
        });
        for (File file : files) {
            if (file.isDirectory()){
                getAllFile(file);
            }else{
                System.out.println(file.toString());
            }
        }
    }

    // 使用匿名内部类
    private static void getAllFile3(File dir){
        /*File [] files =dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()){
                    return true;
                }
                return pathname.getName().toLowerCase().endsWith(".png");
            }
        });
         */


        File [] files =dir.listFiles((d,name)-> new File(d,name).isDirectory()||name.toLowerCase().endsWith(".png")
        );
        for (File file : files) {
            if (file.isDirectory()){
                getAllFile(file);
            }else{
                System.out.println(file.toString());
            }
        }
    }
}
