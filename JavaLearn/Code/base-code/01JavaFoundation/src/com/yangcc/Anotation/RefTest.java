package com.yangcc.Anotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
假设的框架类
 */
@SuppressWarnings("all")
@Pro(className = "com.yangcc.Anotation.Student",methodName = "show")
public class RefTest {
    public static void main(String[] args) throws  Exception{
        // 可以创建任意类的对象，可以执行任意方法
        /*
            前提，不能改变该类的任何代码，但可以创建任意类的对象，可以执行任意方法
         */
        // 1.解析注解
        // 1.1获取该类的字节码文件对象
        Class<RefTest> refTestClass = RefTest.class;
        // 2.获取上边的注解对象
        Pro annotation = refTestClass.getAnnotation(Pro.class);  // 其实就是在内存中生成了一个该注解接口的子类实现对象
        /*
            public class ProImpl implements Pro(){
                public String className(){
                    return "com.yangcc.Anotation.Student";
                }
                public String methodName(){
                    return "show"
                }
            }
         */
        // 3.调用注解中定义的抽象方法来获取返回值
        String className=annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className+"||"+methodName);

    }
}
