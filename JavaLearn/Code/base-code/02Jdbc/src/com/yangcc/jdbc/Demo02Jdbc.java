package com.yangcc.jdbc;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02Jdbc {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt= null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.定义sql
            String sql="insert into t_student values(null,'丁则然','男',27,'园艺2班')";
            // 3.获取connn对象
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javalearn?characterEncoding=utf-8","root","123456");
            // 4.通过connection对象获取执行sql的对象
            stmt=conn.createStatement();
            // 5.执行sql
            int count = stmt.executeUpdate(sql);
            // 6.处理结果
            if (count>0){
                System.out.println("添加成功");
            }else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
