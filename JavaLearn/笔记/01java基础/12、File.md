### P331 File类

File类是一个与系统无关的类，任何操作系统都可以使用这个类中的方法

* 三个单词：

  1.file：文件

  2.directory：文件夹/目录

  3.path：路径

静态方法：

File.pathSeparator:路径分隔符，window：分号，linus：冒号

File.separator:文件名称分隔符,window:\  linius:/

* 绝对路径与相对路径

#### file类的常用方法

* 构造

  创建的相对路径实在该项目的根目录下

* 获取

  String getAbsolutePath();

  String getPath();

  String getName();

  long length();//只能获取文件大小 字节

* 判断

  boolean  exists();是否存在

  boolean  isDirectory();是否为目录

  boolean isFile();是否为文件

* 创建删除  boolean

  mkdir();创建由此file表示的文件或目录  单级

  mkdirs(); 创建多级或者单级

  createNewFile();创建文件  路径不存在则抛出异常

  delete();文件和文件夹均可删除

#### File类遍历

String [] list();string类型数组，文件目录下的所有子文件或目录

File[] listFiles()：将文件及文件夹封装到File数组中

遍历的都是构造方法中给出的目录

如果路径不存在，会抛出空指针异常

#### 递归

使用前提：调用方法时，方法主体不变，但每次调用方法的参数不同，则可以使用递归，构造方法禁止递归

* 直接递归
* 间接递归

[递归打印多级目录](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\File\Demo04Recurison.java)

#### 文件过滤器

File[] listFiles(Filter fileter)

File [] listFiles(FilenameFilter filter)

两者都是接口，需要自己重写实现类及其方法

原理：

 ![image-20191111214829392](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191111214829392.png)

[实现](E:\YangChengCan\Learning\Java学习\代码\base-code\day04-code\src\com\yangcc\File\Demo06Filter.java)





