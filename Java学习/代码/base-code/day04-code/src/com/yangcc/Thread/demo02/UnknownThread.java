package com.yangcc.Thread.demo02;

public class UnknownThread {
    public static void main(String[] args) {
        // 接口
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("fuck u " + i);
                }
            }
        });
        t.start();
        // 实现类
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <20 ; i++) {
                    System.out.println("T"+i);
                }
            }
        };
        for (int i = 0; i < 20; i++) {
            System.out.println("shit" + i);
        }
    }

}
