package com.yangcc.Thread.NotifyAndWait;

import javax.sound.midi.Soundbank;

public class Guke extends Thread{
    private Baozi bz;

    public Guke(Baozi bz) {
        this.bz = bz;
    }
    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if (bz.flag==false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 被唤醒后执行的代码
                System.out.println("正在吃"+bz.pi+bz.xian);
                // 吃完修改状态
                bz.flag=false;
                // 唤醒
                bz.notify();
                System.out.println("一吃完，开始生产");
            }

        }

    }
}
