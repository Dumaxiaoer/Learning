package com.yangcc.datasoruce.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo01c3p0 {
    public static void main(String[] args) throws Exception {
        // 1.创建数据库连接池对象  不传参使用默认config
        //DataSource ds=new ComboPooledDataSource();
        DataSource ds=new ComboPooledDataSource("otherc3p0");
        for (int i = 0; i < 10; i++) {
            // 2.获取连接对象
            Connection conn = ds.getConnection();
            // 3.打印
            System.out.println(conn);
        }

    }
}
