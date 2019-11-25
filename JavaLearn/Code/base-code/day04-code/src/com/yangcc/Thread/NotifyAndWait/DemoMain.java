package com.yangcc.Thread.NotifyAndWait;

public class DemoMain {
    public static void main(String[] args) {
        // 包子对象
        Baozi bz=new Baozi();
        // 包子铺线程
        new BaoZiPu(bz).start();
        // 顾客
        new Guke(bz).start();
    }
}
