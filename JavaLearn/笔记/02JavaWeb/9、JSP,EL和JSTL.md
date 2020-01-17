### JSP

1.指令：用于配置jsp页面，导入资源文件

​	格式：<%@ 指令名称  属性名=属性值 %>

​	分类：

​		1）page 配置jsp页面

​			contentType="text/html;charset=gbk"

​			 -- 设置响应体的mime类型以及字符集 

​			 -- 设置当前jsp页面的编码（只能是高级的ide才能生效） 

​			language=“java”

​			buffer="16kb"     缓冲

​			import=“java.util”   导包

​			errorPage="500.jsp"   当前页面发生页面后，会跳到指定的页面

​			isErrorPage=""    标识当前页面是否是错误页面

​		2）include   页面包含的，导入页面资源文件

​			<%@ include file ="xxxx.jsp"%>

​		3）taglib   导入资源

​			引入标签库

​			<%@ taglib prefix="c"    url=""%>

​			prefix为自定义的前缀



2.注释

​		html注释:<!-- --> 只能注释html页面

​		jsp注释：<%-- --%>  可以注释全部，包括脚本内容

3.内置对象

​	在jsp页面中不需要创建，直接使用的对象

​		 变量名                               真实类型                              作用

* pageContext                  PageContext                    当前页面共享数据   获取其他8个内置
* request                          HttpServletRequest       一次请求访问的多个资源（转发）
* session                           HttpSession                     一次对话多个请求间
* application                       ServletContext                 所用用户间共享数据
* response                        HttpServletResponse            响应
* page                                      Object                          当前的servelt
* out                                      JspWriter                          输出对象
* config                                ServletConfig                  Servlet配置对象
* exception                           Throwable                         异常对象



#### MVC

原理

![image-20191227093716579](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191227093716579.png)





#### EL表达式

3.语法：${表达式}

4.忽略表达式：

​	1）jsp页面属性设置： isElIgnore ="true" 忽略当前jsp页面中所有的el表达式

​	2）\ ${表达式} ：忽略当前el表达式

5.使用

​	1.运算

​		算数 运算符

​		比较运算符

​		逻辑运算符 &&(and)  ||(or)  !(not) 

​		空运算符：empty			

​				功能：用于判断字符串，集合，数组对象是否为null并且长度是否为0

​				${empty list} 表示判断list是否为空，如果为空则返回true，否则false

​				${not empty str}: 表示判断字符串，集合，数组对象是否部位null，并且 

​				长度>0

​	2.获取值

​		1）el表达式能从域中获取值

​		2）语法

​			a. ${域名.键名}：指定域中获取指定键的值

​				-- pageScope   -->pageContext

​				--requestScope   -->request

​				-- sessionScope   -->session

​				-- applicationScope   ---> application

​			     比如$(requestScope.name)

​			 b.${键名}：表示依次从最小的域中查找是否有该键值对的值，直到找到位置，基本用于查找操作

​			 c.获取对象，list集合 ，map集合的值

* 获取对象

​			![image-20191227101548918](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191227101548918.png)		**注意**：如上面的brithday   ${u.birthday.xxxx}  其中要获取brithday的属性xxxx必须有相对应的get方法，否则会报错

原理：a.xxxx   来源于  a.getXxxx  --->xxxx

如果要格式化，则在类中定义格式化的方法，并在el表达式中通过属性表示，操作称之为逻辑视图

* List集合：

语法：${域名.键名[索引]}

 ${list[0]} ，去到list集合中的第一个元素

如果集合中存的对象，获取方式${list[0].name}

* Map

  ${域名称.键名.key名称}  

  ${域名.键名["key名称"]}

6.隐式对象

​	el表达式中又11个隐式对象

​	学习：pageContext:

​			1）.获取jsp其他8个内置对象

​				**${pageContext.request.contextPath} 动态获取虚拟目录**

​				比如用于重定向：

​				response.sendRedirect(request.getContextPath()+"")

#### JSTL

1.概念：JavaServer Pages Tag Library  JSP标准标签库

​	开源的免费的jsp标签，用于简化和替换jsp上的java代码

2.使用步骤

​	1）导入jstl相关jar包     [jar](E:\YangChengCan\Learning\JavaLearn\jar\jstl)

​	2）引入标签库：taglib  <%@ taglib%>

3.常用的标签

​	1）if

​	2）choose

![image-20191227114311477](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191227114311477.png)

​	3）foreach

​			完成重复的操作，遍历容器

​			属性：

​				begin：开始值

​				end:结束值

​				var：临时变量

​				step：步长	

​				varStatus:循环状态对象

​						index:容器中元素的索引

​						count:循环次数，从1开始

[案例]()









