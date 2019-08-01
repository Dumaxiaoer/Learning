package com.yangcc.stack;

import java.util.List;
import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        // 测试栈
        // 先创建一个ArrayStack
        ArrayStack arrayStack =new ArrayStack(4);
        String key="";
        boolean loop =true;//控制是否退出菜单
        // 扫描器
        Scanner scanner=new Scanner(System.in);
        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:表示退出栈");
            System.out.println("push:表示添加数据到栈");
            System.out.println("pop:表示从栈取出数据");
            System.out.println("请输入你的选则");
            key=scanner.next();
            switch (key){
                case"show":
                    arrayStack.list();
                    break;
                case"push":
                    System.out.println("请输入一个数");
                    int value =scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case"pop":
                    try {
                        int res=arrayStack.pop();
                        System.out.println("出栈的数据为"+res);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case"exit":
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出------");
    }
}
class ArrayStack{
    private int maxSize;
    private int [] stack;//数组模拟栈，数据放在该数组中
    private  int top =-1;
    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[this.maxSize];
    }
    // 栈满
    public  boolean isFull(){
        return top==maxSize-1;
    }
    // 栈空
    public  boolean isEmpty(){
        return top==-1;
    }
    // 入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满了，无法再存放数据");
            return;
        }
        top++;
        stack[top]=value;
    }
    // 出栈 将栈顶的数据返回
    public int pop(){
        if (isEmpty()){
           // 因为有返回值，所以这儿用抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
        // 先取得栈顶的值
        int value=stack[top];
        top--;
        return value;
    }
    // 遍历栈  从栈顶往下遍历
    public void list(){
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for (int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

}