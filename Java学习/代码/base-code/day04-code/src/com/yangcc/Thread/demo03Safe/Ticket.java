package com.yangcc.Thread.demo03Safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    private  int ticket=100;
    /*
     3.使用lock锁对象
     */
    Lock l=new ReentrantLock();
    /*
     1.创建一个锁对象
     */
    Object obj=new Object();
    @Override
    public void run() {
        while (true){
//            synchronized(obj){
//                if (ticket>0){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("正在卖"+ticket+"票");
//                    ticket--;
//                }
//            }
            l.lock();
            if (ticket>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("正在卖"+ticket+"票");
                ticket--;
            }
            l.unlock();
        }
    }

    /*
        2.定义一个同步方法
        锁对象是实现类对象  new Ticket 即this
     */
    public  synchronized void payTicket(){
        if (ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正在卖"+ticket+"票");
            ticket--;
        }
    }
    /*
        3.静态代码块
     */
    public   void payTicket1(){
        synchronized (Ticket.class){
            if (ticket>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("正在卖"+ticket+"票");
                ticket--;
            }
        }
    }
}
