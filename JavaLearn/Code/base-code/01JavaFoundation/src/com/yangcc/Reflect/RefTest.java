package com.yangcc.Reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
假设的框架类
 */
public class RefTest {
    public static void main(String[] args) throws  Exception{
        // 可以创建任意类的对象，可以执行任意方法
        /*
            前提，不能改变该类的任何代码，但可以创建任意类的对象，可以执行任意方法
         */
        // 1.加载配置文件
        // 1.1创建
        Properties pro=new Properties();
        // 1.2 加载配置文件并转化为集合
        // 1.2.1 获取class目录下文件   类加载器
        ClassLoader classLoader = RefTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        pro.load(resourceAsStream);

        // 2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        // 3.加载该类进内存
        Class cls = Class.forName(className);
        // 4.创建对象
        Object obj=cls.newInstance();
        // 5.获取方法
        Method method = cls.getMethod(methodName);
        // 6.执行方法
        method.invoke(obj);
    }
}
