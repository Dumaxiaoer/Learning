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



### JSP



1.概念：

​	Java Server Pages:java服务器端页面

​	可以理解为:一个特殊页面，其中既可以指定定义html标签，又可以定义java代码

* 用于简化书写

2.原理

![image-20191226153021780](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191226153021780.png)

java类要被外界访问，那么这个类必须是servlet，而jsp其本质上就是servlet

编译后的内容在

C:\Users\Administrator\.IntelliJIdea2019.2\system\tomcat\_base-code\work\Catalina\localhost\07_CookieAndSession\org\apache\jsp  中，可以通过tomcat中的文件获取

![image-20191226160233240](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191226160233240.png)

3.脚本

JSP定义java代码的方式

​	1）<%  java代码 %>   定义的java代码，在service方法中可以定义的东西，在该脚本中都能定义

​	2） <%!  java代码 %> 定义的java代码，在jsp转换后的java类成员位置（一般用于成员方法，变量）

​	3）<%= java代码%>定义的java代码，会输出到页面上，即输出语句可以定义什么，则该脚本可以定义什么

4.内置对象

​	一共9个

* request
* response
* out:字符输出流对象，可以将数据输出到页面上，和resposne.getwriter()类似，区别在于，response永远先于out输出（会先找response的缓存）

### SESSION

服务器端会话技术，在一次会话的多次请求间共享数据，将数据保存到服务器对象中

httpSession对象：

​	![image-20191226161752621](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191226161752621.png)

原理：session的实现依赖于cookie

![image-20191226162602233](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191226162602233.png)

**细节**

​	1.当客户端关闭后，服务器不关闭，两次session是否为同一个

​		-- 默认情况下不是，但可以创建cookie，设置SESSIONID和最大存活时间到本地，使其一致

​	2.客户端不关闭，服务器关闭，是否同一个

​		不是同一个，但是要确保数据不丢失

​			1）session的钝化

​				在服务器正常关闭前，将session对象系列化到硬盘上

​			2）session的活化

​				在服务器启动后，将session文件反序列化到服务器上

​			3）tomcat会自动序列化与反序列化，而idea只会序列化

​	3.session失效时间	

​			1）服务器关闭

​			2）调用方法invalidate()

​			3）默认失效时间为30分钟

​					

**特点**

​	1.session用于存储一次会话的多次请求的数据，存在服务器端

​	2.可以存储任意大小的数据

​	3.与cookie区别：

​		1）服务器和客户端

​		2）大小有无限制

​		3）session数据相对安全，而cookie不

案例

![image-20191226171122420](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191226171122420.png)

