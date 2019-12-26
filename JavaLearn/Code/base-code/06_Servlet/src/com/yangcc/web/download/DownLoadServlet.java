package com.yangcc.web.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet( "/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数
        String fileName=request.getParameter("fileName");
        // 2.使用字节流加载
        // 2.1找到服务器真实路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + fileName);
        // 2.2 使用字节流关联
        FileInputStream fis=new FileInputStream(realPath);
        // 3.设置response响应头
        // 3.1设置响应头类型
        String mimeType = servletContext.getMimeType(fileName);
        response.setHeader("content-type",mimeType);
        // 3.2设置响应头打开方式
        response.setHeader("content-disposition","attachment;filename="+fileName);
        // 3.将输入流的数据写出到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte [] bts =new byte[1024*2];
        int len =0;
        while ((len=fis.read(bts))!=-1){
            outputStream.write(bts,0,len);
        }
        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
