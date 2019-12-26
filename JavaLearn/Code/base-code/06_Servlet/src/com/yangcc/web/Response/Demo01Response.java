package com.yangcc.web.Response;
/*
    重定向
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo01Response")
public class Demo01Response extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----demo01被访问了");
        // 访问该资源，会自动跳转到demo02
        // 1.设置状态码为302
        response.setStatus(302);
        // 2.设置响应头为location
        response.setHeader("location","/06_Servlet/Demo02Response");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }


}
