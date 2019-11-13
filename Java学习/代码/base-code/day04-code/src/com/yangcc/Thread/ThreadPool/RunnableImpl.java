package com.yangcc.Thread.ThreadPool;

public class RunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建了新线程");
    }
}
