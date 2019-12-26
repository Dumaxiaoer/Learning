package com.yangcc.Net.Upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class UpLoadServer {
    public static void main(String[] args) throws IOException {
        uploadFileoptimize();
    }

    /*
    文件上传  初始版
     */
    private static void uploadFile() throws IOException {
        // 1.创建服务器对象
        ServerSocket ss=new ServerSocket(8999);
        // 2.获取网络流对象
        Socket socket=ss.accept();
        // 3. 得到网络输入流对象
        InputStream is=socket.getInputStream();
        // c.创建文件夹
        File file =new File("D:\\myfile\\server");
        if (!file.exists()){
            file.mkdirs();
        }

        // 4.服务器本地输出流
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file+"\\1.jpeg"));
        // 5.依次读取并存入到硬盘
        byte [] bts=new byte[30];
        int len =0;
        while ((len=is.read(bts))!=-1){
            // 6.存到本地磁盘
            bos.write(bts,0,len);
        }
        // 7.通过网络输出流，告知客户端存储完毕
        OutputStream os =socket.getOutputStream();
        os.write("文件已经上传完毕".getBytes());
        // 8.关闭
        bos.close();
        is.close();
        os.close();
        socket.close();
    }
    /*
    优化版本
     */
    private  static  void uploadFileoptimize() throws IOException {
        // 1.创建服务器对象
        ServerSocket ss=new ServerSocket(8999);
        while (true){
            // 2.获取网络流对象
            Socket socket=ss.accept();
            // 使用多线程提高程序的效率
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 3. 得到网络输入流对象
                        InputStream is=socket.getInputStream();
                        // c.创建文件夹
                        File file =new File("D:\\myfile\\server");
                        if (!file.exists()){
                            file.mkdirs();
                        }
                        String name ="yangcc"+System.currentTimeMillis()+new Random().nextInt(9999)+".jpeg";
                        // 4.服务器本地输出流
                        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file+"\\"+name));
                        // 5.依次读取并存入到硬盘
                        byte [] bts=new byte[30];
                        int len =0;
                        while ((len=is.read(bts))!=-1){
                            // 6.存到本地磁盘
                            bos.write(bts,0,len);
                        }
                        // 7.通过网络输出流，告知客户端存储完毕
                        OutputStream os =socket.getOutputStream();
                        os.write("文件已经上传完毕".getBytes());
                        // 8.关闭
                        bos.close();
                        is.close();
                        os.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }
            });
        }
        //socket.close();
    }



}
