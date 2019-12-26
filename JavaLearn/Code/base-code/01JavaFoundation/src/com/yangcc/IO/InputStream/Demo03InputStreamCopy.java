package com.yangcc.IO.InputStream;

import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Demo03InputStreamCopy {
    public static void main(String[] args) throws IOException {
        // 输入流 即文件源
        FileInputStream fis = new FileInputStream("D:\\myfile\\test\\国考特训营系统讲义（小班专属）.pdf");
        // 输出流 目标
        FileOutputStream fos = new FileOutputStream("D:\\myfile\\test03\\mmm.pdf");
        // 读取文件
        byte[] bytes =new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
    }
}
