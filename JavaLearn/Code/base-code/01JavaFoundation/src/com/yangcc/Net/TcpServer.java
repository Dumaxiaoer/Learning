package com.yangcc.Net;
/*
通信的服务器端，读取并给客户端回写数据
需要指定端口号
必须明确：哪个服务器请求，所以可以使用accpet方法
 */

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        // 1.创建服务器对象
        ServerSocket server=new ServerSocket(8888);
        // 2.获取请求对象的socket
        Socket socket=server.accept();
        // 3.获取输入流
        InputStream is = socket.getInputStream();
        // 4.读取数据
        byte []bts=new byte[1024];
        int len=is.read(bts);
        System.out.println(new String(bts,0,len));
        // 5.回写数据
        OutputStream os = socket.getOutputStream();
        os.write("收到，谢谢".getBytes());
        socket.close();
        server.close();
    }
}
