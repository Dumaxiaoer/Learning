## tomcat

网络通信三要素：

​	ip:

​	端口：

​	传输协议：规定了数据传输的规则

​		1.基础协议：tcp：安全协议，三次握手

​		2.upd：速度快，容易丢失数据

#### web服务器软件

服务器：安装了服务器软件的计算机

服务器软件：接收用户请求，处理请求，做出响应

web服务器软件：在web服务器软件中，可以部署web项目，让用户通过浏览器来访问这些项目，也可成为web容器

**目录结构**

![image-20191128205429728](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191128205429728.png)

启动：bin目录下的startup.bat

关闭：shutdown.bat  或者ctrl+c

**部署tomcat**

1. 直接将项目放到webapps目录下即可

​	如localhost:8080+项目名称+资源名称

* 简化：将项目打成一个war包，再将war包防止到webapps目录下，war包会自动解压

  2.在服务器的conf/server.xml中配置xml文件

 	在<Host>标签体中 配置

<Context  docBase = "E:\YangChengCan\Learning\前端\BootStrapStudy" path="/start" />

其中：docBase指项目存放路径

path：虚拟目录

3.在conf\Catalina\localhost创建任意名称的xml文件，在文件中编写<Context  docBase = "E:\YangChengCan\Learning\前端\BootStrapStudy"  />

* 现在的虚拟目录即xml的名称

**注意**:编码格式要与server.xml一致

**动态项目与静态项目**

* java动态项目的目录结构：

  -- 根目录

  ​	-- WEB-INF 目录

  ​		--web.xml:web项目的核心配置文件

  ​		-- classes目录：放置字节码文件的目录

  ​		--lib目录，放置以来的架包

##### 将tomcat集成到IDEA中，并且创建JavaEE项目，部署项目

Run->EditConfigurations->template->tomcatSetver->local   再进行配置

并将on update action 改为onupdate resource

* 注意配置tomcat Server的虚拟目录，一般改为和项目名称一致

