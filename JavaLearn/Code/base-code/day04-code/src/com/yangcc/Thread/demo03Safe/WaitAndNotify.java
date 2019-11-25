package com.yangcc.Thread.demo03Safe;
/*
    线程之间的通信

 */

public class WaitAndNotify {
    public static void main(String[] args) {
        // 创建锁对象，保证唯一
        Object obj=new Object();
        // 创建一个顾客线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 保证等待和唤醒只有一个执行
                synchronized (obj){
                    System.out.println("告诉老板要的食品种类及数量");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 唤醒后代码
                    System.out.println("已做好，可用吃");
                }
            }
        }).start();
        // 老板的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 花5妙做食品
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj){
                    System.out.println("做好");
                    obj.notify();
                }
            }
        }).start();

    }
}
