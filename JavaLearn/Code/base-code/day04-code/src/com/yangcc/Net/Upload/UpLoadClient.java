package com.yangcc.Net.Upload;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class UpLoadClient {
    public static void main(String[] args) throws IOException {
        uploadFile();
    }

    /*
    文件上传初始版
     */
    private static void uploadFile() throws IOException {
        // 1.创建客户端对象
        Socket socket =new Socket("127.0.0.1",8999);
        // 2.创建本地流对象,读取本地文件
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("D:\\myfile\\client\\学位证.jpeg"));
        // 3.获取网络输出流对象
        OutputStream os=socket.getOutputStream();
        // 4.读取本地文件
        byte []bts=new byte[24];
        int len =0;
        while ((len=bis.read(bts))!=-1){
            // 5.将读取的传给服务器
            os.write(bts,0,len);
        }
        socket.shutdownOutput();// 告诉服务器，输出流结束
        // 6.网络输入流，获取服务器信息
        InputStream is =socket.getInputStream();
        byte [] btes=new byte[1024];
        int len2=is.read(btes);
        System.out.println(new String(btes,0,len2));
        // 7.关闭
        os.close();
        is.close();
        bis.close();
        socket.close();

    }


}
