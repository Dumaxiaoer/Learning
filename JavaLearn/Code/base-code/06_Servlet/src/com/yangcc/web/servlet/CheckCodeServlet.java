package com.yangcc.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.创建一个对象，在内存中画图（验证码的图片对象）
        int width=100;
        int height=50;
        BufferedImage image =new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        // 2.美化图片
        // 2.1填充背景色
        Graphics g=image.getGraphics();
        g.setColor(Color.pink);// 设置画笔颜色
        g.fillRect(0,0,width,height);
        // 2.2画边框
        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);
        String str="ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        // 生成随机角标
        Random random=new Random();

        for (int i = 0; i <4; i++) {
            int index= random.nextInt(str.length());
            // 获取字符
            char ch=str.charAt(index);
            g.drawString(ch+"",20+20*i,25);

        }
        // 2.3写验证码



        // 3.将图片输出到页面
        ImageIO.write(image,"jpg",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
