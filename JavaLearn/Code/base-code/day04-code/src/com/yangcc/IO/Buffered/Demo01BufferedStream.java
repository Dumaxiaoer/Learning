package com.yangcc.IO.Buffered;

import com.yangcc.day5.Array;

import java.io.*;
import java.util.Arrays;

public class Demo01BufferedStream {
    public static void main(String[] args) throws IOException {
        //bufferedOutput();
        //readAndWriteSingle();
        bufferedInput();
    }
    /*
        字节缓冲输出流
     */
    private static void bufferedOutput() throws IOException {
        // 创建一个流对象
        FileOutputStream fos=new FileOutputStream("D:\\myfile\\test\\bfout.txt");
        // 创建一个缓冲流对象
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        // 写入数据
        fos.write("我会将你们，全部打败，让你们也尝到，痛苦的滋味".getBytes());
        // 刷新
        bos.flush();
        bos.close();
    }
    /*
        字节缓冲输入流
     */
    private static  void bufferedInput() throws IOException {
        // 创建字节输入
        FileInputStream fis =new FileInputStream("D:\\myfile\\test02\\bfout2.txt");
        // 缓冲流
        BufferedInputStream bis =new BufferedInputStream(fis);
        int len =0;
        byte [] bts=new byte[6];
        while ((len=bis.read(bts))!=-1){
            System.out.println(new String(bts,0,len));
        }
        bis.close();
    }




    /*
    测试，一个一个的进行读写,字节流,
    总结：
     */
    private static void readAndWriteSingle() throws IOException {
        FileInputStream fis=new FileInputStream("D:\\myfile\\test\\bfout.txt");
        FileOutputStream fos=new FileOutputStream("D:\\myfile\\test02\\bfout.txt");
        // 读取数据
        int len =0;
        byte [] bts=new byte[2];
        while ((len=fis.read(bts))!=-1){
            fos.write(bts);
//            System.out.println(Arrays.toString(bts));
//            System.out.println(new String(bts));
        }
        //fos.write(fis.read());
    }

}
