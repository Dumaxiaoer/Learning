package com.yangcc.Thread.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01ThreadPool {
    public static void main(String[] args) {
        // 1.获取线程池
        ExecutorService es= Executors.newFixedThreadPool(2);
        // 3.调用submit方法，传递线程任务
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        // 4.销毁
        es.shutdown();
    }


}
