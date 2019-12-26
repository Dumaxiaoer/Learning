### 会话 

#### 会话

1.概念：一次会话中包含多次请求和响应

​	一次会话：浏览器第一次给服务器资源发送请求，会话建立，直到一方断开为止

2.功能：在一次会话的范围内的多次请求间，共享数据

3.方式：

​	客户端会话技术：Cookie

​	服务器端会话技术：Session

#### COOKIE

一门客户端会话技术

![image-20191225191550182](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191225191550182.png)

原理

![image-20191225200652361](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191225200652361.png)

细节：

​	1.一次可不可以发送多少个cookie

​		可以

​		可以创建多个cookie对象，使用response调用多次addCookie发送cookie即可

​	2.cookie在浏览器中报错多长时间

​		默认情况下，当浏览器关闭后，Cookie数据被销毁

​		持久化存储：setMaxAge(int seconds)

​					1）正数  将cookie数据写到硬盘文件中，持久化存储，cookie存活时间

​						如设置为30，30s后即删除cookie

​					2）负数   默认值，存在浏览器内存中，关闭即销毁

​					3）零：删除cookie信息

​	3.能不能存中文

​			tomcat8之前，cookie中不能直接存储中文数据

​				-需要转码：url编码

​			tomcat8之后，可以存储中文数据

​	4.获取范围多大

​			1）假设在一个tomcat中，部署了多个web项目，能否共享

​				--默认情况下不能共享

​				-- setPath(string path);设置cookie获取的范围，默认情况下，设置当前的虚拟目录，如果设置为setPath("/")表示服务器下所有项目（对同一个服务器下部署多个项目有效）

​			2）不同服务器间

​				--setDomain(string path):如果设置一级域名相同，那么多个服务器间cookie可以共享，如setDomain(".baidu.com")，那么tieba.baidu.com和news.baidu.com中的cookie可以共享

​	5.cookie的特点

​		1）存储数据在客户端浏览器

​		2）浏览器对于单个cookie大小有限制（4kb），以及对同一个域名下的总cookie数量(20个)有限制

​		3）作用：

​			--用于存储少量的不太敏感的数据

​			-- 在不登陆的情况下，完成服务器对客户端的身份识别

[案例-记住上一次访问时间](E:\YangChengCan\Learning\JavaLearn\Code\base-code\07_CookieAndSession\src\com\yangcc\cookie\Demo01Cookie.java)

![image-20191225210749974](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191225210749974.png)

**注意**：如果要用cookie做一些特殊字符处理，则需要编解码

