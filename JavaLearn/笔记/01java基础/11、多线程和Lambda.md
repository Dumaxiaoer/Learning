### P290- 多线程

#### --P297原理  

并发：两个或多个事件在同一时间段内发生--交替执行

并行：两个或多个事件在同一时刻发生---同时发生

**进程**：内存中的一个应用程序

![image-20191106190349849](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191106190349849.png)		**线程**：通向cpu的执行路径，多个线程之间互不影响

![image-20191106191215404](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191106191215404.png)

线程调度：

* 分时调度：轮流
* 抢占式调度：根据优先级

**主线程**：执行主方法 的线程

​	java程序只有一个线程

![image-20191106192246218](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191106192246218.png)

**创建多线程第一种方式继承Thread**   

[实现](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\Thread\demo01)

开启线程后cpu执行情况

![image-20191106194809646](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191106194809646.png)

**多线程内存图**    start方法，开辟新的栈空间

![image-20191106200028562](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191106200028562.png)

#### [P298常用方法](https://www.bilibili.com/video/av62541169/?p=298  )

* 获取当前执行的线程名称

  Thread.currentThread().getName;

* sleep(毫秒);

**创建多线程第二种方式  实现runnable接口**

[实现](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\Thread\demo02)

**好处**：

1.避免了单继承的局限性：一个类只能继承一个类，如果继承Thread就不能继承其他类，runnable可用避免这种情况

2.增强了程序的扩展性，降低了程序耦合性，把设置线程任务和开启新线程进行了分离

实现类中，重写了run方法：用来设置线程任务

创建Thread类对象，调用start方法，开启新线程

[使用匿名内部类创建多线程](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\Thread\demo02\UnknownThread.java)

#### p304线程安全问题

以卖票作为案例

![image-20191106213315137](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191106213315137.png)

**解决线程安全问题三种方式**

* 一、[同步代码块](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\Thread\demo03Safe\Ticket.java)

  synchronized(锁对象){

  }

  1.通过代码块的锁对象，可用使用任意对象

  2.但是必须保证多个线程使用的时同一个锁对象

  3.锁对象作用：将同步代码块锁住，只让一个线程在同步代码块中执行

原理：![image-20191106215640028](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191106215640028.png)

* 二、[同步方法]()

  1.把访问了共享数据的代码抽取出来，放到一个方法中

  2.在方法上添加synchronized修饰符

  修饰符 synchronized 返回值  名称（）{}

* 三、静态方法

  1.锁对象不能是this，this是创建之后产生的，静态方法优先于对象，所以静态方法的锁对象是本类的class属性

* 四、lock锁

  1.创建实现了lock接口的ReentrantLock类对象

  2.在可能出现代码安全问题的代码前调用接口中的lock方法

  3.在可能会出现。。。后调用unlock

#### p312线程状态

![image-20191107191019260](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191107191019260.png)

* [等待唤醒案例](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\Thread\demo03Safe\WaitAndNotify.java)

![image-20191107192057449](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191107192057449.png)

* wait(long m)和sleep类似

  如果在m时间之后还没有被唤醒，将自动唤醒

* 两种唤醒：notify（）和notifyAll();

* **等待唤醒机制**

  [多个线程之间协作机制](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\Thread\NotifyAndWait)

#### p321线程池

原理![image-20191107210207680](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191107210207680.png)

![image-20191107210456137](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191107210456137.png)

### P323 Lambda

标准格式：

1.一些参数

2.一个箭头

3.一段代码

（参数列表）->{重写方法的代码}

（）：接口中抽象方法的参数列表

->:传递的意思，把参数传递给方法体{}

{}：重写接口的抽象方法体

[比较大小](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\Lambda)

* lambda表达式：是可推导，可以省略

  省略：1.（参数列表）:数据类型可以省略

  2.(参时列表)：如果只有一个参数，那么类型和{}都可省略

  3.（一些代码）：如果{}中的代码只有一行，无论是否返回值，都可以省略（{}，return,;）

  注意：要省略前面三个，必须一起省略

* **使用前提**

  1.必须有接口，且接口中有且只有一个抽象方法

  2.必须具有上下文推断：也就是方法的参数或变量类型必须为Lambda对应的接口类型，才能实用

  **注**：有且只有一个抽象方法的接口，称为“**函数式接口**”

* 