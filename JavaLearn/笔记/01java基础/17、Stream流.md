### p410 STREAM流

操作集合跟数组

![image-20191115143518531](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191115143518531.png)

**获取Stream流的两种方法**

* 使用Collection接口
* 使用Stream接口

**特点**：属于管道流，只能消费一次

使用完后，就不能调用其他方法

[获取流](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\Stream\GetStream\Demo01GetStream.java)

**常用方法** [代码](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\Stream\Demo03StreamMethod.java)

* forEach():用来遍历流中的数据，是终结方法，遍历后不能继续调用Stream流中其他方法
* filter();过滤
* map();映射
* count()；统计个数
* limit();取前几个元素
* skip();跳过前几个
* concat();组合

* [过滤练习](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\Stream\Demo04ListTest.java)

#### 方法引用  p424

![image-20191118192456074](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191118192456074.png)

