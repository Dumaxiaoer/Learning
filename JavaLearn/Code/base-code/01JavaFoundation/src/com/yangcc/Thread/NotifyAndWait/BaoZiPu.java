package com.yangcc.Thread.NotifyAndWait;
/*
    包子铺和顾客线程关系》》通信（互斥）
    必须同时同步技术保证俩线程只有一个执行
    因此包子对象作为参数传给两线程
 */

import jdk.swing.interop.SwingInterOpUtils;

import javax.sound.midi.Soundbank;

public class BaoZiPu extends Thread {
    // 1.创建一个包子变量
    private Baozi bz;

    // 2.为包子赋值
    public BaoZiPu(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        // 定义变量
        int count = 0;
        while (true) {
            synchronized (bz) {
                if (bz.flag == true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 被唤醒后执行
                if (count % 2 == 0) {
                    // 生产
                    bz.pi = "薄皮";
                    bz.xian = "三鲜";
                } else {
                    // 生产
                    bz.pi = "西瓜皮";
                    bz.xian = "牛批";
                }
                count++;
                System.out.println("正在生产" + bz.pi + bz.xian + "包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 修改状态
                bz.flag = true;
                bz.notify();
                System.out.println("生产完毕，可用食用");
            }
        }
    }
}
