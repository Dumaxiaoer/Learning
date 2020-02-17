## ASP

program.cs:包含main方法，程序从这里开始

Startup.cs：调用各种中间件，对数据做处理并返回给前台

* app.use();使用await next() 调用下一个中间件

* app.run();为中断中间件
* app.Use
* StaticFiles():允许访问静态页面
* app.UseFileServer():允许注册中间件并网文html页面

Properties-launchSettring.json:初始化配置，包括端口号等

appsettings.json:配置文件，日常要读取的键值对，放在其中

.csproj：右键解决方案->编辑项目文件；可修改其托管方式

### 基本

![image-20191127105245956](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191127105245956.png)

配置

![image-20191127112752370](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191127112752370.png)

#### 中间件

处理http请求

![image-20191127141752574](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191127141752574.png)

当中间件处理请求并发生响应时，请求流程会在管道开始反向传递

总结：

1..NET Core 默认不支持静态文件服务

2.默认的静态文件为wwwroot

3.要使用静态文件，必须使用UseStaticFiles();

4.要定义默认文件，必须使用UseDefaultFiles()

![image-20191127145143892](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191127145143892.png)

#### 开发环境变量

![image-20191127152212504](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191127152212504.png)

#### MVC

![image-20191127152640674](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191127152640674.png)

![image-20191127154521324](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191127154521324.png)

**mvc知识点**

三层和mvc关系：mvc为架构层的东西，而三层为软件工程当中功能模块

1.在mvc下请求的是某个控制器，某个行为，razor一般不直接进行请求

2.在mvc中，访问时，实际访问的时某个类的某个方法，而在asp.net中，访问时，实际访问的是某个类

3.启动程序后，地址栏里访问的是控制器中的行为，行为里将定义的视图返回至页面，不传参的话，默认返回与行为名称一致的视图；该模式完成了页面与行为的解耦

4.App_Start->RouteConfig中的方法定义了路由规则，决定了访问地址构建顺序

#### 开发方式对比

![image-20191128105410545](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191128105410545.png)

![image-20191128105421089](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191128105421089.png)

#### 强类型

行为向视图传递数据：ViewData[""];

#### 行为

其本质就是方法，在控制器中定义为public，就能被访问到

继承ActionResult的类型

* ViewResult   返回页面
* ContentResult   返回文本
* RedirectResult   使用Redirect(String url) 将结果转到其他的action
* JsonResult:使用Json(object data)将data序列化为json数据并返回；默认只接收post
* JsonRequestBehavior.AllowGet:处理get请求，一般结合客户端的ajax请求返回

![image-20200109154550474](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200109154550474.png)

返回Json对象

![image-20200109155233765](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200109155233765.png)



由行为向页面传值：@ViewData["xxxx"]

#### 接收参数的方式

1.request接收

![image-20200109155659041](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200109155659041.png)

页面接收：@ViewBag.Id



![image-20200109161818807](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200109161818807.png)

2.自动装配（本质和第一种一致）

![image-20200109162252231](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200109162252231.png)

高级点的自动装配

![image-20200109165016678](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200109165016678.png)

#### 路由  Route

决定以什么样的形式来访问服务器

在App_Start中的RouteConfig中，有注册路由的方式，其中url便是路由规则，

前两项写死不能变，而第三项则可以作为参数传递的形式

![image-20200205170417339](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200205170417339.png)

如

```
// 自定义路由规则
routes.MapRoute(
                name: "HelloWorld",
                url:"{year}-{month}-{day}-{id}",
                defaults:new 
                { 
                    controller="HelloWorld",
                    action="showWorld"
                },
                constraints: new 
                {
                    year="^\\d{4}$",
                    month="^\\d{1,2}$",
                    day="^\\d{1,2}$"
                }
                );
// 默认路由规则
routes.MapRoute(
                name: "Default",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }
            );
```

Route:   路由规则

RouteData:路由数据 

RouteCollection:路由集合

RouteTable:静态变量对象

#### 区域 

当项目非常多的时候，方便分类管理的

右键->添加->新建搭建基架的项目->mvc