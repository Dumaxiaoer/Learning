package com.yangcc.Junit.test;

import com.yangcc.Junit.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /*
        初始化方法
        用于申请资源，所有的测试方法在执行前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init");
    }
    /*
    释放资源方法，所有测试方法执行结束都会执行该方法
     */
    @After
    public void close(){
        System.out.println("over");
    }

    @Test
    public void testAdd(){
        // 1.创建对象
        Calculator c=new Calculator();
        // 2.调用方法
        int res = c.add(3, 2);
        System.out.println(res);
        // 3.断言  期望值和得到的值
        Assert.assertEquals(5,res);
    }
    @Test
    public void testSub(){
        // 1.创建对象
        Calculator c=new Calculator();
        // 2.调用方法
        int res = c.sub(3, 2);
        // System.out.println(res);
        // 3.断言  期望值和得到的值
        Assert.assertEquals(1,res);
    }

}
