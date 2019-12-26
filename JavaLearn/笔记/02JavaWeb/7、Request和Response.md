## Request和Response

### 原理

1.req和res对象由服务器创建，我们来使用

2.req对象是来获取请求消息，res是设置相应消息

  ![image-20191211192318417](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191211192318417.png)

### Request

1.获取请求消息数据

* 获取请求行 [路径](E:\YangChengCan\Learning\JavaLearn\Code\base-code\06_Servlet\src\com\yangcc\web\request\Demo01Request.java)

  ![image-20191211194132769](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191211194132769.png)

  URL:统一资源定位符

  URI:统一资源标识符   比前者大

* 请求头

  [代码](E:\YangChengCan\Learning\JavaLearn\Code\base-code\06_Servlet\src\com\yangcc\web\request\Demo02Request.java)

* [请求体](E:\YangChengCan\Learning\JavaLearn\Code\base-code\06_Servlet\src\com\yangcc\web\request\Demo03Request.java) 

  只有post才有请求体，在请求体中封装了post请求的请求参数   

  步骤：1获取流对象

  ​	BufferedReader  getReader()；获取字符流，只能操作字符

  ​	ServletInputStream getInputStream()；获取字节输入流，可以操作所有类型数据

  ​	2.在从流对象中取数据

* 

**2.其他**  

​	a.获取请求参数通用方式

	* 	String getParameter(String name) 根据参数名称获取参数
	
	 * 	String [] getParameterValues(String name) 根据参数名称获取参数值的数组   用于复选框

 * Enumeration<String> getParameterNames() 获取所有请求参数名称

 * Map<String,String[]> getParameterMap();获取所有参数的map集合

   

​    b.请求转发

​		1.一种在服务器内部的资源跳转方式

​		2.request.getRequestDispatcher(String path).forword(request,response)

​		3.特点：

​				浏览器地址栏路径没有发生变化

​				只能转发到当前服务器内部资源中

​				转发是一次请求

​				

​	c.共享数据

​		域对象：一个有作用范围的对象

​	** request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据			![image-20191212210343582](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191212210343582.png)

![image-20191212210652068](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191212210652068.png)	



d.获取ServletContext



#### 用户登录案例

![image-20191212211754227](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191212211754227.png)

#### 中文乱码问题

tomcat内部将get中的乱码问题已经解决

post虽然是以parameter形式获取，但其底层仍然是流的形式进行获取的

原文链接：https://blog.csdn.net/pengfudian1991/article/details/82468615



#### JavaBean

1.标准的java类

​	类必须被public修饰

​	必须提供空参构造器

​	成员变量必须使用private修饰

​	提供公共的setter和getter方法

2.功能：封装数据

![image-20191212223428957](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191212223428957.png)

3.使用：

* 1.导入beanUtil架包

[架包](E:\YangChengCan\Learning\JavaLearn\jar)

* 转化： BeanUtils.populate(Users,map);

  就会直接将map属性封装到Users对象中



### HTTP 协议

1.请求消息：

2.响应消息

### Response

1.响应行：

* 组成：协议/版本   响应状态码   状态码描述

  状态码：服务器告诉客户端浏览器本次请求和响应的一个状态

  状态码都是3为数字

  分类：1.1xx ：服务器接收客户端消息，但未接收完成，等待一段时间后，发送1xx状态码，询问服务端是否还有消息

  ​			2.成功。

  ​			3.重定向，代表：302（重定向） 304（访问缓存）

  ​			4.客户端错误：404 路径没有对应的资源

  ​				405：请求方式没有对应的doXxx方法

  ​			5.服务器端错误：

  ​				500：表示服务器内部出现异常（代码错误）

  ​				

   2.响应头

​		常见的头：

​		1.Content-Type:服务器告诉客户端本次响应体数据格式及编码格式

​		（浏览器会根据该格式使用相应的字符集，解决中文乱码问题）

​		2.Content-Length:字节个数

​		3.Content-disposition: 服务器告诉客户端，以什么格式打开响应体数据（如果没有设置，则为默认值：in-line,表示在当前页面打开  ；attachment: 以附件形式打开响应体，一般用于文件下载，filename=xxx）

​	3,响应体：传输的数据 ，多为相应的html页面

**Response对象**

​	功能：设置响应消息

​			1.设置响应行：setStatus(int sc)

​			2.设置响应头：setHeader(String name,String value)

​			3.设置响应体：

​					使用步骤：

​					1.获取输出流：

​						字节输出流

​						字符输出流

​					2. 使用输出流，将数据输出到客户端浏览器

​						![image-20191216215636611](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191216215636611.png)





 **案例**

​	1.完成重定向

​		response.sendRedirect("/06_Servlet/demo01")

​		**重定向特点:**redirect

​		a.地址栏发生变化

​		b.可以访问其他站点的资源

​		c.两次请求（本质是两个Request,不能通过其来共享数据）

​		**转发特点：**forword

​		a.地址栏地址不变，

​		b.只能访问当前服务器下的资源

​		c.转发是一次请求（可以使用Request对象共享数据）

​	2.服务器输出字符数据到浏览器

​	3.服务器输出字节数据到浏览器

​	4.验证码 

#### 路径

1.分类：

* 相对路径：通过相对路径不可确定唯一资源

  不以/开头，以.开头  ./代表当前目录，../代表后退一级

  规则：确定访问的当前资源和目标资源之间相对位置关系

* 绝对路径：通过绝对路径可以确定唯一资源

  如：以/开头的路径

  规则：判断定义的路径给谁用

  * 给客户端，浏览器用：则需要加虚拟目录（项目的访问路径），如重定向

    一般用虚拟目录的方式：

    String contextPath=request.getContextPath();

    response.sendRedirect(contextPath+"/demo")

  * 给服务器：不需要加虚拟目录（如请求转发）

#### 输出字符

常出现中文乱码

![image-20191223212848921](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191223212848921.png)

乱码问题：在代码前设置：response.setContentType("text/html;charset=utf-8")

#### 验证码

1.本质就是图片

2.目的，防止恶意表单注册

[代码](E:\YangChengCan\Learning\JavaLearn\Code\base-code\06_Servlet\src\com\yangcc\web\servlet\CheckCodeServlet.java)

点击切换验证码

![image-20191223222141392](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191223222141392.png)

#### ServletContext对象

范围很广，服务器启动时创建，服务器关闭时销毁

1.概念：代表整个web应用，可以和程序的容器（服务器）来通信

2.获取：

* request.getServletContext();
* this.getServletContext();

2.功能：

​	1）获取MIME类型

​		MIME:在互联网通信中定义的一种文件数据类型

​			格式：大类型/小类型   text/html     image/jpge

​		获取：getMimeType(String file)

​	2）域对象:共享数据

​		1.setAttribute(String name,Object value);

​		2.getAttribute(string name);

​		3.removeAtrribute(string name)

​	**对象范围**:共享所有数据

​	3）获取文件的真实路径(部署到服务器上)

​			方法：getRealPath(String path)

![image-20191224203337954](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191224203337954.png)

![image-20191224203558172](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191224203558172.png)

#### 案例 下载

![image-20191224205341107](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191224205341107.png)

[代码](E:\YangChengCan\Learning\JavaLearn\Code\base-code\06_Servlet\web\DownLoad.html)

中文文件名无法正常显示问题：需要用到工具类

​	1.获取客户端使用的浏览器版本信息

​	2.根据不同的版本信息，设置fileName的编码方式不同