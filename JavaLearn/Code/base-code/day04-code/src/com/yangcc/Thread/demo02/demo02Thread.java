package com.yangcc.Thread.demo02;

public class demo02Thread {
    public static void main(String[] args) {
        RunnableImpl run=new RunnableImpl();
        Thread t=new Thread(run);
        t.start();

    }
}
