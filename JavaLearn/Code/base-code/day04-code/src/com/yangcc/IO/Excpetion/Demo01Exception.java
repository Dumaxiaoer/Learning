package com.yangcc.IO.Excpetion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo01Exception {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis=new FileInputStream("D:\\myfile\\test\\b.txt");){
            int len=0;
            if ((len=fis.read())!=-1){
                System.out.println(len);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    // 第二种异常处理方式
    private static void exceptionShow() throws FileNotFoundException {
        FileInputStream fis=new FileInputStream("D:\\myfile\\test\\b.txt");
        try(fis){
            int len=0;
            if ((len=fis.read())!=-1){
                System.out.println(len);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
