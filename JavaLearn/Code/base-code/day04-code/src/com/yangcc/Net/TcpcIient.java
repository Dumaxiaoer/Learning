package com.yangcc.Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
tcp通信客户端
不能使用自己创建的流对象
 */
public class TcpcIient {
    public static void main(String[] args) throws IOException {
        // 1.创建一个客户端对象
        Socket socket=new Socket("127.0.0.1",8888);
        // 2.使用soket方法获取流对象
        OutputStream os=socket.getOutputStream();
        // 3.使用流对象的write，给服务器发送数据
        os.write("你好服务器".getBytes());
        // 4.获取流
        InputStream is=socket.getInputStream();
        // 5.读取
        byte [] bts=new byte[1024];
        int len =is.read(bts);
        System.out.println(new String(bts,0,len));
        // 6.关闭
        socket.close();
    }
}
