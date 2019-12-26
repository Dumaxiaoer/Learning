package com.yangcc.web.Response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Demo03Response")
public class Demo03Response extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 在获取流对象之前，设置流的默认编码
        //response.setCharacterEncoding("GBK");
        // 告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码(该步骤可省略上一布)
        //response.setHeader("content-type","text/html;charset=utf-8");
        // 简单的形式，设置编码(该步可省略上步操作)
        response.setContentType("text/html;charset=utf-8");
        // 1.获取字符输出流
        PrintWriter pw = response.getWriter();
        pw.write("<h1>亲爱的，我想你了</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 1.获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("hello".getBytes());
    }

}
