#### 04 基于事件驱动开发

![image-20200113193337819](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200113193337819.png)

#### 05 Web服务器

IIS

#### 06 网络配置文件和网页生成

![image-20200113201333299](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200113201333299.png)

![image-20200113201921459](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200113201921459.png)

#### 07 页面回发机制引出的问题

![image-20200113212311081](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200113212311081.png)

#### 08 回发问题的解决和page对象

![image-20200113212657210](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200113212657210.png)

![image-20200113213004561](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200113213004561.png)

#### 09 Request和Response使用（网页跳转）

1.用request获取参数 

* Request.QueryString["xxxx"];  只能是通过url方式

* Request.Params["xxxx"];  (除了url其他都可以获取)
* HttpContext.Current.Request["etime"];

2.response 返回结果

* HttpContext.Current.Response.Write(returnJson);

![image-20200114190628939](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200114190628939.png)

#### 10 ViewState(视图状态)

![image-20200114191826964](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200114191826964.png)

#### Session对象

![image-20200114194131157](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200114194131157.png)

获取session内容：string a =Session["xxxxx"];

保存session内容：Session["xxxx"]="a";

![image-20200114201643541](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200114201643541.png)

![image-20200114202217181](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200114202217181.png)

#### Cookie对象

![image-20200114204250306](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200114204250306.png)

![image-20200114204817550](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200114204817550.png)

![image-20200114204949059](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200114204949059.png)



#### 14 Application

通常用于显示在线人数和访问人数

![image-20200114205608688](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200114205608688.png)

![image-20200114210811309](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200114210811309.png)

#### 15 ASP.NET控件

1.html控件

* 运行在客户端
* 没有回传，不能用ViewState状态
* 浏览器完成事件处理（js）
* 如果需要访问后台，典型使用Jquery

2.服务器控件

* 运行在服务器端

* 能回传
* 服务器能完成事件处理（c#后台处理）
* 事件驱动

​	

#### 17 文件上传

![image-20200116102028783](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200116102028783.png)

#### 19 SERVER对象（页面跳转，请求转发）

![image-20200116111933873](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200116111933873.png)

实现页面跳转：	Server.Transfer("~/xxxx.aspx"),相当于请求转发，地址栏不会发生改变

#### 20 数据验证

常用验证方式：

![image-20200116112845516](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200116112845516.png)

常用验证：非空 ， 比较，范围验证



#### 25 使用母版页统一页面布局

添加单独母版页窗体

1.添加>Web窗体母版页

2.添加>包含母版页的web窗体

#### 26 项目核心功能

编写了sqlHelper类

[代码](E:\YangChengCan\Learning\AspCore\Code\WebForm\DAL\Helper)

#### 29 母版页与站点地图

