package com.yangcc.datasoruce.druid;

import com.yangcc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
完成添加操作
 */
public class Demo02Druid {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement psmt = null;
        try {
            // 1.获取连接
             conn = JDBCUtils.getConnection();
            // 2.定义sql
            String sql="insert into t_student values(null,?,?,?,?,?)";
            // 3.获取 数据库操作对象
            psmt=conn.prepareStatement(sql);
            psmt.setString(1,"李妍文");
            psmt.setString(2,"女");
            psmt.setInt(3,27);
            psmt.setString(4,"城轨3班");
            psmt.setDouble(5,5888.888);
            // 4.执行sql
            int count= psmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(psmt,conn);
        }

    }

}
