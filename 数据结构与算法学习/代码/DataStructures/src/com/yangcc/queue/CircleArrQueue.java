package com.yangcc.queue;

import java.util.Scanner;

public class CircleArrQueue {
    public static void main(String[] args) {
        // 创建一个队列
        CircleArr arrayQueue = new CircleArr(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(show):添加数据到队列");
            System.out.println("d(get):从队列取数据");
            System.out.println("h(head):查看队列头数据");
            key=scanner.next().charAt(0);
            switch (key){
                case's':
                    arrayQueue.showQueue();
                    break;
                case'a':
                    System.out.println("请输入一个数字");
                    int value =scanner.nextInt();
                    arrayQueue.add(value);
                    break;
                case'd':
                    // 取数据
                    try {
                        int res= arrayQueue.del();
                        System.out.printf("取出的数据为%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case'h': // 查看队列头数据
                    try {
                        int res= arrayQueue.headQueue();
                        System.out.printf("头部数据为%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case'e':
                    scanner.close();
                    loop=false;
                    System.out.println("程序退出");
                    break;
            }
        }
    }
}

class CircleArr{
    private int maxSize;//数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 存放数据的数组

    public  CircleArr(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = 0; // 指向队列头部，
        rear = 0; // 指向队列尾部，指向队列尾部的数据的后一个
    }
    // 判断队列是否满
    public  boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    // 判断队列是否为空
    public boolean isNull() {
        //return  front==-1||front==maxSize-1;
        return rear == front;
    }

    // 添加数据到队列
    public void add(int a) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，无法添加数据");
            return;
        }
        // 直接将数据加入
        arr[rear]=a;
        // 将rear后移动
        rear=(rear+1)%maxSize;
    }

    // 取出数据
    public int del() {
        // 判断队列是否为空
        if (isNull()) {
            // 通过判处异常处理
            throw new RuntimeException("队列为空，不能取数据");
        }
        // front是指向队列的第一个元素
        int value =arr[front];
        front=(front+1)%maxSize;
        return  value;
    }

    // 显示队列所有数据
    public void showQueue() {
        if (isNull()) {
            System.out.println("空队列");
            return;
        }
        // 从front开始遍历

        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i]);
        }
    }
    // 当前队列有效数据个数
    public  int size(){
        return (rear+maxSize-front)%maxSize;
    }


    // 显示队列头数据
    public int headQueue() {
        if (isNull()) {
            throw new RuntimeException("空数组");
        }
        return arr[front + 1];
    }
}


