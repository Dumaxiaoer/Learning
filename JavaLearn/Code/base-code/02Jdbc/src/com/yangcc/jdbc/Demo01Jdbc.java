package com.yangcc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;
import java.sql.Statement;

/*
快速入门
 */
public class Demo01Jdbc {

    public static void main(String[] args) throws Exception {
        // 1.导入驱动jar包
        // 先将jar包复制，再右键add libraliy
        // 2.注册驱动   加载到Driver类中，其中有静态代码块，用于注册驱动
        Class cls = Class.forName("com.mysql.jdbc.Driver");
        // 3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalearn", "root", "123456");
        // 4.定义sql语句
        String sql="update t_student set age =24 where id=1";
        // 5.执行sql对象
        Statement stmt= conn.createStatement();
        // 6.执行sql
        int count = stmt.executeUpdate(sql);
        // 7.打印
        System.out.println(count);
        // 8.释放资源
        stmt.close();
        conn.close();

    }
}
 