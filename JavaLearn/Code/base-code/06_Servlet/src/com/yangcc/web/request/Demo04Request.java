package com.yangcc.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/Demo04Request")
public class Demo04Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 1.根据名称获取请求参数
        String username = request.getParameter("username");
        // System.out.println(username);
        // 2.根据名称获取参数数组 多用于复选框
        String [] hobby =request.getParameterValues("hobby");
        for (String s : hobby) {
            System.out.println(s);
        }
        // 3.获取参数名称
        Enumeration<String> parameters=request.getHeaderNames();
        while (parameters.hasMoreElements()){
            String name =parameters.nextElement();
        }

        // 4.获取参数的map
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
        Set<String> strings = parameterMap.keySet();
        for (String name : strings) {
            // 获取值
            String[]values=parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("--------------");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
