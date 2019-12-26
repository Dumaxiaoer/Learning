package com.yangcc.Lambda;

import javax.sound.midi.Soundbank;
import java.net.Socket;

public class demo01Cook {
    public static void main(String[] args) {
        // 调用  参数是cook接口，可传递cook的匿名内部类对象
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("its time to eat");
            }
        });
        // 使用lambda
        invokeCook(()->{
            System.out.println("吃饭了");
        });
    }

    // 定义一个方法，参数传递cook接口，方法内部调用cook接口中方法
    public static void invokeCook(Cook cook){
        cook.makeFood();
    }

}
