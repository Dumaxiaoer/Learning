package com.yangcc.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Element;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/demo01Cookie")
public class Demo01Cookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应格式即编码
        response.setContentType("text/html;charset=utf-8");
        // 1.获取所有的cookie
        Cookie[] cookies=request.getCookies();
        // 2.遍历cookies
        if (cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                // 3.获取cookie的名称
                String name =cookie.getName();
                // 4.判断名称是否是lasttime
                // 如果是，则证明lasttime有值，非第一次访问，则返回时间并显示
                if ("lastTime".equals(name)){
                    // 获取值，并解码
                    String value =cookie.getValue();
                    System.out.println(value);
                    value= URLDecoder.decode(value,"utf-8");
                    System.out.println(value);
                    // 更新cookie值，并重新发送
                    Date date =new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    // 转换编码(否则报错)
                    System.out.println(str_date);
                    // URL编码
                    str_date= URLEncoder.encode(str_date,"utf-8");
                    System.out.println(str_date);
                    cookie.setValue(str_date);
                    // 设置持久化存储
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);
                    // 响应
                    response.getWriter().write("欢迎回来，你上次的访问时间为"+value);
                    break;
                }
            }
        }
        // 5.如果遍历完未发现cookie,则为第一次访问
        Date date =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);
        str_date=URLEncoder.encode(str_date,"utf-8");
        Cookie cookie=new Cookie("lastTime","");
        cookie.setValue(str_date);
        response.addCookie(cookie);
        response.getWriter().write("欢迎首次访问");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
