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

**练习**1

ResultSet:封装查询结果

​	1.getString(1）/getString("列名")

[操作结果集代码](E:\YangChengCan\Learning\Java学习\代码\base-code\Jdbc\src\com\yangcc\jdbc\Demo03Jdbc.java)

**练习2**

查询数据，将其封装为对象，装在集合中返回

抽取jdbc工具类：JdbcUtil







