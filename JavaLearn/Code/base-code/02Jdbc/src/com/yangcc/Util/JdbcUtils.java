package com.yangcc.Util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

@SuppressWarnings("all")
public class JdbcUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*
    只需要读取一次即可拿到这些值
     */
    static {
        // 读取资源文件
        Properties pro=new Properties();
        try {
            // 加载文件
            // 类加载器classLoader 默认src为根路径
            ClassLoader cl=JdbcUtils.class.getClassLoader();
            URL res=cl.getResource("jdbc.properties");

            String path=res.getPath();
            //System.out.println(path);
            pro.load(new FileReader(path));
            // 获取值并赋值
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取连接  通过配置连接
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt,Connection conn){
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

    public static void close(PreparedStatement stmt,Connection conn){
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

    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
