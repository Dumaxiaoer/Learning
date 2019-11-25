package com.yangcc.Functional.Lambda;

public class Demo02Runnable {
    public static void main(String[] args) {
        // 调用方法，匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-->>线程启动了");
            }
        });
        // lambda
        startThread(()-> System.out.println(Thread.currentThread().getName())
        );
    }
    // 定义方法
    private static void startThread(Runnable run){
        // 开启多线程
        new Thread(run).start();
    }
}
