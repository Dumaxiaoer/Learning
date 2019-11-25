package com.yangcc.jdbc;

import com.yangcc.Util.JdbcUtils;
import com.yangcc.domain.Student;

import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
public class Demo05Jdbc {

    public static void main(String[] args) {
        List<Student> list=new Demo05Jdbc().findAll2();
        System.out.println(list);
    }

    // 查询所有stdutent对象
    public List<Student> findAll2(){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        List<Student> list=new ArrayList<>();
        try {
            conn= JdbcUtils.getConnection();
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
           JdbcUtils.close(rs,stmt,conn);
        }

        return list;
    }

}
