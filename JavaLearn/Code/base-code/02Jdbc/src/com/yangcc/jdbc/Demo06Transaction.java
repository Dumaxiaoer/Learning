package com.yangcc.jdbc;

import com.yangcc.Util.JdbcUtils;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo06Transaction {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        try {
            // 1.创建连接对象
            conn=JdbcUtils.getConnection();
            // c.开启事务
            conn.setAutoCommit(false);
            // 2.定义sql
            String sql1="update t_student set salary = salary+?  where name =?";
            String sql2="update t_student set salary =salary+? where name =? ";
            pstmt1=conn.prepareStatement(sql1);
            pstmt2=conn.prepareStatement(sql2);
            // 3.设置参数
            pstmt1.setDouble(1,520.1314);
            pstmt1.setString(2,"苗青青");
            pstmt2.setDouble(1,1314.520);
            pstmt2.setString(2,"王婷");
            // 4.执行sql
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();
            conn.commit();
        }catch (Exception e){
            if (conn!=null){
                conn.rollback();
                e.printStackTrace();
            }
        }finally {
            JdbcUtils.close(pstmt1,conn);
            JdbcUtils.close(pstmt2,null);
        }

    }




}
