package com.yangcc.jdbctemplate;

import com.yangcc.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/*
入门学习
 */
public class Demo01JdbcTemplate {
    public static void main(String[] args) {
        // 1.导入jar包
        // 2.创建JDBCTemplate对象
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        // 3.调用方法
        String sql="update t_student set salary =6000 where id = ?";
        int count = template.update(sql,2);
        System.out.println(count);

    }
}
