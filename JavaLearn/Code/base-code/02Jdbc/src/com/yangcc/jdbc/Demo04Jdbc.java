package com.yangcc.jdbc;
/*
查询数据并封装为对象
 */

import com.yangcc.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo04Jdbc {
    public static void main(String[] args) {
        List<Student> list=new Demo04Jdbc().findAll();
        System.out.println(list);

    }


    // 查询所有stdutent对象
    public List<Student> findAll(){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        List<Student> list=new ArrayList<>();
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.连接数据库对象
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javalearn?characterEncoding=utf-8","root","123456");
            // 3.操作sql对象
            stmt=conn.createStatement();
            // 4.定义sql
            String sql="select * from t_student";
            // 5.执行sql
            rs=stmt.executeQuery(sql);
            Student stu;
            // 6.遍历结果集
            while (rs.next()){
                stu = new Student();
                int id =rs.getInt("id");
                String name=rs.getString("name");
                String sex=rs.getString("sex");
                int age=rs.getInt("age");
                String cls=rs.getString("class");
                stu.setId(id);
                stu.setName(name);
                stu.setAge(age);
                stu.setSex(sex);
                stu.setCls(cls);
                list.add(stu);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    conn.close();
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

        return list;
    }

    private void jdbcConnetct(){


    }



}
