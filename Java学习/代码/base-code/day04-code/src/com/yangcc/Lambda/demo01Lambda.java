package com.yangcc.Lambda;

import javax.sound.midi.Soundbank;

public class demo01Lambda {
    public static void main(String[] args) {
        // 创建一个普通线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        }).start();
        // 使用lambda表达式，实现多线程
        new Thread(()->{
            System.out.println("新线程创建了");
        }).start();
        // 省略
        new Thread(()-> System.out.println("创建新线程"));

    }
}
