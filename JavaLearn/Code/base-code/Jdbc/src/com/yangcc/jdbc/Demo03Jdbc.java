package com.yangcc.jdbc;

import java.sql.*;

@SuppressWarnings("all")
public class Demo03Jdbc {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt= null;
        ResultSet rs=null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.定义sql
            String sql="select * from t_student";
            // 3.获取connn对象
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javalearn?characterEncoding=utf-8","root","123456");
            // 4.通过connection对象获取执行sql的对象
            stmt=conn.createStatement();
            // 5.执行sql
            rs = stmt.executeQuery(sql);
            // 6.处理结果,遍历ResultSet
            // 6.1循环判断结果集是否有下一行
            while (rs.next()){
                int id=rs.getInt(1);
                String name =rs.getString("name");
                System.out.println(id+"--"+name);
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

            if (rs!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
