## Servlet

概念：server+applet 

​	运行在服务器端的小程序

	* 本质上就是一个接口，定义了java类被浏览器访问到（tomcat识别的规则）
	* 定义一个类，实现servlet接口，复写方法

#### 快速入门

1.创建一个javaEE项目

2.实现servlet接口

3.实现其中抽象方法

4.配置

在web.xml中配置

```java
<!--配置servlet--><servlet>  
<servlet-name>demo</servlet-name>    <servlet-class>com.yangcc.web.servlet.Demo01Servlet</servlet-class></servlet><servlet-mapping>    <servlet-name>demo</servlet-name>    <url-pattern>/demo</url-pattern></servlet-mapping> 
```

#### Servlet执行原理

![image-20191209203627007](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191209203627007.png)

![image-20191209203645405](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191209203645405.png)

#### Servlet生命周期

**方法**

* init 初始化方法

  在servlet被创建时执行，只会执行一次(第一次被访问时创建，上图的反射机制)

* service 提供服务方法

  每一次Servlet访问时，执行，执行多次

* destory 销毁

  在服务器正常关闭时执行，执行一次

* getServletInfo获取servlet信息，如版本，作者等

**生命周期**

1.被创建：init 

​	默认情况下，第一次被访问时，servlet被创建

​	但可以通过配置指定servlet创建时机

​	在servlet标签下配置信息中使用<load-on-startup>正数/负数</load-on-startup> 0或正在服务器启动

servlet的init方法，说明Servlet在内存中只创建一个对象，则会出现线程安全问题

解决：尽量不要在servlet中定义成员变量，即使定义了，也不要对其修改值

2.提供服务：service

每次访问servlet时，service都会被调用	

3.被销毁：执行destory方法，只执行一次

服务器正常关闭时，被销毁

#### Servlet注解

使用注解进行配置

在实现了的servlet类中，使用@WebServlet("/资源路径")来配置文件，注，一定不要将"/"给漏掉

#### IDEA和Tomcat相关配置

1.idea会为每个tomcat部署的项目，单独建立一份配置文件

部署的项目信息在启动服务时

Using CATALINA_BASE:   	"C:\Users\Administrator\.IntelliJIdea2019.2\system\tomcat\_base-code" 路径中

使用的第三种热部署方式

2.工作空间项目  和 tomcat 部署的项目不同

tomcat 部署的web项目=out->artifacts->部署的项目

tomcat真正访问的是“tomcat部署的web项目” ，其与工作空间中的文件一一对应，工作空间的文件被编译后会放在部署项目的 WEB-INF->classes文件夹下

工作空间中WEB-INF目录下的资源不能被浏览器直接访问

3.断点调试：tomcat中如何断点调试：断点，并点击启动旁的按钮进行调试

#### Servlet体系结构

​	Servlet   ---接口

​	GenericServlet    ---抽象类

​		将servlet中其他的方法做了空实现，只将service方法做了抽象

​	HttpServlet   ---抽象类 

![image-20191210201041172](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191210201041172.png)

注：表单提交时，action中的注解没有"/"

#### Servlet相关配置

1.urlpartten :即Servlet的访问路径

2.路径的定义规则

* /xxx
* /xxx/xxx   称之为目录结构
* *.do

#### HTTP

**概念：**hyper text transfer protocal 超文本传输协议

* 传输协议：定义了，客户端和服务器端通信时，发送数据的格式

* 特点：1.基于tcp/ip的高级协议，安全的，三次握手

  ​	2.默认端口：80

  ​	3.基于请求/响应模型    一一对应

  ​	4.无状态的：每次请求之间相互独立，不能交互数据

**请求消息数据格式**

​	1.请求行

​		请求方式  请求url  请求协议/版本

​		GET    /login.html    HTTP/1.1

  * 请求方式
    http有7中请求方式，常用的有2种

    * get 

      1.请求参数在请求行中，在url后面

      2.请求的url长度有限制

      3.不太安全

    * post

      2.请求参数在请求体中

      3.请求url长度无限制

      4.相对安全

​	2.请求头

​		请求头名称：请求头值

​		常见的请求头：

​			1.User-agent：浏览器告诉服务器，我访问你使用的浏览器版本信息(可以在服务器端获取该头信息，解决兼容问题)

​			2.Refer:告诉服务器，当前请求从哪儿来，

​			作用：a.防止别人盗取连接

​			b.统计工作	

​			3.Connection:keep-alive  可以被复用

​	3.请求空行

​		空行 做分割作用

​	4.请求体（正文）

​		封装post请求消息的请求参数的

**响应消息数据格式**