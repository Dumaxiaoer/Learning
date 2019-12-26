package com.yangcc.Anotation.DemoTest;

import com.yangcc.Junit.junit.Calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
简单的测试框架
当主方法执行后，会自动执行被检测的所有方法
 */
public class TestCheck {
    public static void main(String[] args) throws Exception {
        // 1.创建计算器对象
        Calculator c=new Calculator();
        // 2.获取字节码文件对象
        Class aClass = c.getClass();
        // 3.获取所有方法
        Method [] methods=aClass.getMethods();
        int num =0;// 表示出现异常次数
        // 将异常存储到文件
        BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : methods) {
            // 4.判断方法上是否有对应的注解,
            if (!method.isAnnotationPresent(Check.class)){
                try {
                    // 5.有，则执行方法
                    method.invoke(c);
                } catch (Exception e) {
                    // 6.捕获异常
                    // 记录到文件中
                    num++;
                    bw.write(method.getName()+"方法出现异常");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause());
                    bw.newLine();
                    bw.write("异常的原因："+e.getMessage());
                    bw.write("----------------------");
                }
            }
        }
        bw.write("本次测试一共出现"+num+"次异常");
        bw.flush();
        bw.close();
    }
}
