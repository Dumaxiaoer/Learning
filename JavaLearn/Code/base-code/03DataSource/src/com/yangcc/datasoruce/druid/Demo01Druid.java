package com.yangcc.datasoruce.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Demo01Druid {
    public static void main(String[] args) throws Exception {
        // 1.导入架包
        // 2.定义配置文件
        // 3.加载配置文件
        Properties ps =new Properties();
        // 通过类加载器获取src下面的文件
        InputStream is = Demo01Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        ps.load(is);
        // 3.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(ps);
        // 4.获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
