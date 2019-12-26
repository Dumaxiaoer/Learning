package com.yangcc.web.request;

/*
获取请求行数据
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo01Request")
public class Demo01Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求方式
        String method =request.getMethod();
        System.out.println(method);
        // 2.获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        // 3.获取servlet路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        // 4.获取请求参数
        String queryString = request.getQueryString();
        // 5.获取请求uri
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
        // 6.客户的协议版本
        String protocol = request.getProtocol();
        // 7.获取客户机的ip地址
        String remoteAddr = request.getRemoteAddr();

    }
}
