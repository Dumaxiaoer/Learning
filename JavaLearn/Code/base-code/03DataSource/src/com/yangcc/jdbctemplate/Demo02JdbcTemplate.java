package com.yangcc.jdbctemplate;

import com.yangcc.domain.Student;
import com.yangcc.utils.JDBCUtils;
import jdk.jshell.execution.Util;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Demo02JdbcTemplate {
    // 1.获取template对象
   private  JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());


    // Junit单元测试
    @Test
    public void update(){
        // 2.定义slq
        String sql ="update t_student set salary = 9000 where id =1";
        int count =template.update(sql);
        System.out.println(count);
    }
    /*
    新增
     */
    @Test
    public void add(){
        // 2.定义slq
        String sql ="insert into t_student (name,sex,age)values(?,?,?)";
        int count =template.update(sql,"李妍文","女",26);
        System.out.println(count);
    }
   /*
   查询
    */
   @Test
    public void queryForMap(){
        String sql="select * from t_student where id =1";
        // 长度只能唯一
        Map<String,Object> map=template.queryForMap(sql);
        System.out.println(map);
    }
    @Test
    public void queryForList(){
        String sql="select * from t_student";
        // 长度只能唯一
        List<Map<String,Object>> list=template.queryForList(sql);
        System.out.println(list);
    }
    @Test
    public void query(){
        String sql="select * from t_student";
        // 长度只能唯一
        List<Student> list = template.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                Student student=new Student();
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String sex=rs.getString("sex");
                int age =rs.getInt("age");
                String cls=rs.getString("class");
                double salary =rs.getDouble("salary");
                student.setID(id);
                student.setName(name);
                student.setSex(sex);
                student.setAge(age);
                student.setCls(cls);
                student.setSalary(salary);
                return student;
            }
        });
        System.out.println(list);
    }
    @Test
    public void query2(){
        String sql="select * from t_student";
        List<Student>list=template.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println(list);
    }
    @Test
    public void queryForObject(){
        String sql="select count(ID) from t_student";
        long total =template.queryForObject(sql,Long.class);
        System.out.println(total);
    }
}
