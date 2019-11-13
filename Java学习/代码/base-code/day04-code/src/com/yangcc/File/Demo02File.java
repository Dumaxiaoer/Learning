package com.yangcc.File;

import java.io.File;
import java.io.IOException;

public class Demo02File {
    public static void main(String[] args) throws IOException {
        // 创建文件的路径和名称在构造方法给出
        show01();

    }
    private static  void show01() throws IOException {
        File f1=new File("a.txt");
        System.out.println(f1.getAbsolutePath());
        boolean b1=f1.createNewFile();
        File f2=new File("08_F\\ccc");
        f2.mkdirs();
    }
}
