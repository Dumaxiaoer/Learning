#### P215 Object

* System.arraycopy(src,0,dest,0,3) 将数组src中数据从第一个开始复制到dest中，复制3个



#### P226 StringBuilder

字符串缓冲区，可以提高字符串的操作效率（可以看成长度可变字符串）

底层为数组，但是没有被final修饰，初始容量为16个，如果超出容量，则可以自动扩容  1倍

#### p231包装类

自动拆箱 

自动装箱

针对于基本数据类型

#### p232 基本类型和字符串转换

* 基本类型》》字符串

基本类型+“”；

包装类的静态方法 toString(int i);

string类的valueOf(int i);

* 字符串》》基本类型

Integer类：static int parseInt(String s)

#### p233 集合框架

* Collection中共性方法

  1.add   boolean

2. remove  boolean 有该元素，可返回成功，否则失败
3. contains 集合元素中是否包含指定对象
4. isEmpty()
5. toArray()   [] ;将集合变成数组
6. clear 清除集合所有元素

#### p235迭代器 Iterator

是一个接口，无法直接使用，需要使用实现类

常用：

1.hasNext();判断集合中是否含有下一个元素

2.next();取出集合中下一个元素

步骤：

1.使用集合中的iterator()，获取迭代器实现类对象，使用Iterator接口进行接收（多态）

2.使用hasnext判断有无元素

3.取出集合下一个元素

​	while(iterator.hasNext()){

​		string a =iterater.next();

​	}

* 实现原理

![image-20191030202227749](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191030202227749.png)

* 增强for循环   只针对集合和数组

底层使用的也是迭代器，只是使用了for循环书写，简化了格式

数组：for(int i :arr){

​		sout(i).....	

}

集合：for(Obj o :list){

​	sout(o);

}

#### P240泛型

是一种未知的数据类型，当我们不知道用什么数据类型时候，可以使用泛型

泛型也可以看成一个变量，用来接收数据类型

​	E e:element 元素

​	T t:Type 元素

创建对象时确定泛型的类型

在接口、类、方法中都能使用

* 通配符

？ 代表任意的数据类型

使用方式：不能创建对象使用，只能作为方法的参数使用

public void print(ArrayList<?> list){}

* 泛型的上下限

  1.？extends E 代表使用的泛型只能是E类型的子类或本身

  2.？super E 只能使用E类型的父类或本身


* 发牌

[发牌案例代码](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\Collection09\List\Poker.java)