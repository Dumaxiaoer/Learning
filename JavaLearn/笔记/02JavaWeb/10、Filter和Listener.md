### Filter和Listener

1.Filter：过滤器

2.Listener：监听器

3.Servlet：

以上三者共称javaWeb三大组件

#### Filter

1.概念

当访问服务器资源时，过滤器可以将请求拦截下来，完成一些特殊的功能

过滤器的作用：一般用于完成通用的操作，如登录验证，统一编码处理，敏感字符过滤

2.快速入门

步骤：

​	1）定义类，实现接口Filter

​	2)  复写方法

​	3）配置拦截路径

3.过滤器细节

​	1）web.xml配置

```xml
<filter>
    <filter-name>demo01</filter-name>
    <filter-class>com.yangcc.web.filter.Demo01Filter</filter-class>
</filter>
<filter-mapping>
    <filter-name>demo01</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

​	2）执行流程 

![image-20200107192624468](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200107192624468.png)

​	3）生命周期方法

​		在服务器启动时创建filter对象并执行init

​		在服务器关闭销毁filter对象，正常关闭执行destory方法

​		在每次请求被拦截资源时，执行dofilter

![image-20200107193503757](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200107193503757.png)

​		

​		

​	4）过滤器配置详解

​		A.拦截路径的配置

​			 1.具体资源路径：/index.jsp 只有访问index.jsp资源时，过滤器才会被执行

​			 2.目录拦截：/user/*  访问/user下的所有资源时，过滤器都会被执行

​			 3.后缀名：*.jsp   访问所有jsp资源时，过滤器都会被执行

​			 4.拦截所有资源：/*  

​		B.拦截方式配置：资源被访问的方式

 ![image-20200107195000373](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200107195000373.png)

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200107195502222.png" alt="image-20200107195502222" style="zoom:150%;" />

​	5）过滤器链（配置多个过滤器）

​		注解：按照类名的字符串执行

​		xml

**案例**

![image-20200107203220413](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200107203220413.png)



敏感词屏蔽

![image-20200107205103811](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200107205103811.png)

#### 监听器

继承监听器类

Context 在服务器启动时执行里面的方法 ,通常用于初始化某些参数