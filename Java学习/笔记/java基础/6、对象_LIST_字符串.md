#### p96-p108 对象

* 一个对象的内存图

![1571560532025](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1571560532025.png)

* 两个对象使用同一个方法的内存

![1571561177813](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1571561177813.png)

* 使用对象类型作为参数

![1571564216467](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1571564216467.png)

**注意**：当一个对象作为参数传递到方法中时，实际上传递的是对象的地址值

* 局部变量和成员变量的区别

  1.定义的位置，成员：类当中，方法外；局部：方法中

  2.作用范围：局部：方法当中能用；成员：整个类通用

  3.默认值：局部：无默认值，若使用，需手动赋值

  ​	成员：没赋值会有默认值

  4.内存的位置不同：局部：位于栈内存；成员：堆内存

  5.生命周期：局部：随着方法进栈而诞生，随着方法出栈而消失；

  成员：随着对象创建而诞生，随着对象被垃圾回收而消失

* 面向对象三大特征：封装   继承  多态  

   封装：就是将一些细节隐藏起来，对于外界不可见

  1.方法就是一种封装

  2.关键字private也是一种封装

* private 

  1.本类中可以访问，超出本类不能直接访问

  2.使用get  set 方法向其中存取数据（方法中可以写if语句以对数据进行限制）

* this（主要用来在重名情况下区分的作用）

  1.当方法的局部变量和类的成员变量重名时，根据就近原则，有限使用局部变量

  2.如果要访问本类中的成员变量，需使用格式：this.

  3.通过谁调用的方法，谁就是this

#### p112 -114

* 构造方法

  1.名称与类名完全一致

  2.无返回值类型

  3.不能return

  4.如果没有编写任何构造方法，编译器默认赠送一个

  5.一旦编写了至少一个构造方法，编译器不再赠送，需自己

  写上

* 一个标准的类

  1.所有成员变量使用private关键字

  2.为每个成员比变量编写一对Getter Setter方法

  3.编写一个无参构造方法

  4.编写一个全参构造方法

  这样的类，也叫Java Bean

  鼠标放在变量上，按alt+insert选择生成

* 常用api

#### p115 -120 Scanner与匿名对象

* **Scanner** 

  1.其功能可以实现键盘输入，到程序当中

  导包：Import 包路径 、类名称

  只有java.lang包下的内容不需要导包

[代码](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\day06\Demo01Scanner.java)



* 匿名对象

1.只有右边的对象，没有左边的名字和赋值运算符

2.匿名对象只能使用唯一的一次，下次使用不得不再创建

3.如果确定一个对象只会使用一次，则可使用匿名对像



#### p121-124 Ramdom随机类

int num =new Random().nextInt(3);

左闭右开为 0-2

练习：用代码模拟猜数字的小游戏

#### p125-132集合 对象数组

ArrayList<E> list =new ArrayList<>();

E:泛型，只能是引用类型而不能是基本类型

与数组的区别：数组长度不可变，ArrayList可变

注：对于ArrayList集合来说，直接打印得到的不上地址值，而是内容

常用的方法：

[代码](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\day06\Demo02ArrayList.java)

* 如果要保存基本数据类型，则需在泛型中给其转化为包装类

  但接收可以用基本数据类型

  **装箱**：基本类型--》包装类型   拆箱：引用--》基本类型

#### P133- 142字符串

**1.字符串的内容用不可变**

2.因为其字符串不可变，所以字符串是可以共享使用

3.字符串效果上相当于char[]字符组，但是底层原理是byte[]字节

* 创建字符串

  1.public String();空白字符串

  2.public String(char[] array)；根据字符数组的内容，创建对应字符串

  3.public String(byte[],array);根据字节数组内容创建

  [代码](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\day06\Demo03String.java)

* **字符串的常量池**

  1.程序中直接写上的双引号字符串，就在常量池中，

  new 的，不在常量池中

  2.对于基本类型  == 是数值的比较

  ​	对于引用类型  ==是地址值的比较

  ​	

  ![1571658487632](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1571658487632.png)

* 常用的方法

1.equals  比较两者的内容

推荐写法：“abc”.equals(str)

2.public boolean equalsIgnoreCase(String str)

忽略大小写进行比较

3.public int length  

获取字符串当中含有的字符个数，拿到字符串长度

4.String concat(String str) 

将当前字符串和参数字符串拼接成为返回值新的字符串

5.char charAt(int index)  

获取指定索引位置的单个字符

**6.indexOf(String str)** 

查找参数字符串在本字符串中首次出现的索引位置，没有则返回-1

7.substring(int index) 

截取从参数位置一直到字符串末尾，返回新的字符串

subString(int begin ,int end)

截取中间的，左闭右开，含左不含右

8.char[] toCharArray()

将当前字符串拆分为字符数组作为返回值

9.byte [] getBytes()   IO流会用到

获得当前字符串底层的字节数据

10.String replace(CharSequence oldString,CharSequence newString)

将所有出现的老字符串，替换为新字符串，返回替换后的新结果

11.public String [] split(string regex)

按照参数的规则，将字符串分成若干部分

 regex实际上是一个正则表达式，如果按照英文“.”进行拆分，则必须写“\\\\.”(两个反斜杠+.)

#### p143-147 Static

* 一旦类中有变量使用static关键字，那么这个变量不在属于自己，而是属于所在的类，多个对象共享同一份数据

  **可以用该关键字实现id自增**

  [代码](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\day07\Student.java)

* 对于静态方法、静态比那辆，可以通过对象名和类名进行调用

  **推荐使用类名称进行调用，以区分静态方法和普通方法**

  对于本类当中静态方法，可以省略类名称

* 注意：1非静态能访问静态，而静态不能访问非静态

  静态方法中不能使用this关键字

![1571744529648](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1571744529648.png)

* 静态代码块

  当第一次用到本类时，静态代码块执行唯一一次

  **静态内容优于非静态，静态代码块比构造方法先执行**

  用途：用来一次性对静态成员变量进行赋值



#### Arrays 与数组相关工具类

常用：

1.public static String toString();

​	将参数数组变成字符串

2.public static void sort(数组)

​	按照升序对数组元素进行排序

​	如果数值  则升序

​	字符串   则字母升序

​	自定义：那这个类需要有Comparable或者Comparator接口支持

#### Math 数学相关类

1.public static double abs(double num)  绝对值

2.public static double ceil(double num) 向上取整

3.public static double floor(double num) 向下取整

4.public static long  round(double num) 四舍五入