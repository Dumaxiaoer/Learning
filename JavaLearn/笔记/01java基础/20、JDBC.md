### JDBC

概念：Java DataBase Connectivity ；即java数据库连接，java语言操作数据库

本质：官方定义的一套操作所有关系型数据库的规则（即接口），各个数据库厂商去实现这套接口，提供数据库驱动jar包，我们可以使用这套接口（JDBC）编程，真正执行的代码时驱动jar包中的实现类（多态）

#### JDBC各各类的详解

​	**准备：**

1.先在该mould下创建一个文件夹

2.将jar包复制至文件夹中

3.右键->add as libriary

(jar包中会有com.mysql.jdbc.Driver)

* DriverManager：驱动管理对象

  1.注册驱动:告诉程序该使用哪一个数据库驱动架包

  ​	Class.forName("com.mysql.jdbc.Driver"),在导入的jdbc包中，通过查看源码发现，在com.mysql.jdbc.Driver中存在静态代码块,

  2.获取数据库连接

  ​	url语法：jdbc:mysql://localhost:3306/test

* Connection：数据库连接对象

  1.功能：

  ​	1.获取执行sql的对象

  ​	2.管理事务

  		* 开启事务
  		* 提交事务
  		* 回滚事务

  ​		

* Statement:执行sql对象

  1.执行sql

  * boolean execute(string slq)
  * int executeUpdate(String sql):执行DML;DDL;返回影响的行数
  * ResultSet executeQuery(String sql)

* ResultSet:结果集对象

* ReparedStatement:执行sql对象

  1.sql注入：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接，会造成安全性问题

  2.解决：使用preparedStatement

  3.预编译的sql：参数使用？作为占位符

  [防止sql注入](E:\YangChengCan\Learning\JavaLearn\Code\base-code\Jdbc\src\com\yangcc\jdbc\Demo03Jdbc.java)

**练习**1

ResultSet:封装查询结果

​	1.getString(1）/getString("列名")

[操作结果集代码](E:\YangChengCan\Learning\Java学习\代码\base-code\Jdbc\src\com\yangcc\jdbc\Demo03Jdbc.java)

**练习2**

查询数据，将其封装为对象，装在集合中返回

抽取jdbc工具类：JdbcUtil

**解决操作sql乱码问题：** https://blog.csdn.net/dzz_bc/article/details/80207724 

#### 使用JDBC控制事务

1.在执行sql之前开启事务 conn.setAutoCommit()

2.当所有sql都执行完 提交 conn.commit();

3.catch到异常，回滚：conn.rollback();

#### 数据库连接池

概念：就是一个存放数据库连接的容器

当系统初始化好后，容器被创建，容器会申请一些连接对象，当用户访问时，取对象，访问完成归还对象

实现：

​	1.接口：DataSource   

​			1.获取连接:getConnection

​			2.归还连接：如果连接对象Connection是从连接池中获取，那么调用close()方法			

​	2.一般不实现接口，由数据库厂商实现

​		1.C3P0:数据库连接池技术

​		2.Druid:数据库连接池  阿里巴巴提供的

**C3P0**

​	步骤：1.导入架包

​	 c3p0-0.0.5.2.jar  

 	mechange-commons-java-0.2.12.jar

​	驱动架包：mysql-connector-java-5.1.44-bin.jar 

​	2.定义配置文件：

		* 名称：c3p0.properties 或者c3p0-config.xml

* 路径：直接将文件放在src下面即可

   3.创建核心对象  数据库连接池对象 ComboPooledDataSource

​	4.获取连接  getConnection()	

**Druid**  [代码](E:\YangChengCan\Learning\JavaLearn\Code\base-code\DataSource\src\com\yangcc\datasoruce\druid)

​	1.导入jar包：druid-1.0.9-jar

​	2.定义配置文件 

​			* druid.properties

​			* 可以叫任意名称，可以放到任何目录下

​	3.加载配置文件 Properites

​	4.获取连接池对象：通过工厂类来获取

​		DruidDataSourceFactory

​	5.getConnection

#### 连接池工具类

[实现](E:\YangChengCan\Learning\JavaLearn\Code\base-code\DataSource\src\com\yangcc\datasoruce\utils\JDBCUtils.java)

#### JDBC Template

Spring JDBC 框架对JDBC进行简单的封装

步骤：

​	1.导入jar包[架包](E:\YangChengCan\Learning\JavaLearn\jar)

​	2.创建JdbcTemplate对象，依赖于数据源DataSource

​	3.调用方法来完成crud操作

常用方法：

* update():执行DML语句，主要是增，删，改

* queryForMap();将查询的结果封装为map集合，列表名作为key，值作为value，长度只能为1

* queryForList();查询结果封装为list集合

  将每一条记录封装为map，再将map装在list中

* query();查询结果，封装为JavaBean对象

  参数为RowMapper；

  一般使用BeanPropertyRowMapper实现类，可以完成数据到bean的自动封装

  ```
  new BeanPropertyRowMapper<Student>(Student.class)
  ```

* queryForObject:将查询结果，封装为对象

   

**练习** [Template的使用](E:\YangChengCan\Learning\JavaLearn\Code\base-code\DataSource\src\com\yangcc\jdbctemplate\Demo02JdbcTemplate.java)







