package com.yangcc.Functional.Supplier;

import javax.sound.midi.Soundbank;
import java.util.function.Supplier;

public class Demo01Supplier {
    public static void main(String[] args) {
        String str=getString(()->{
            // 生产一个字符串
            return "苗青青";
        });
        String str2=new Supplier<String>(){
            @Override
            public String get() {
                return null;
            }
        }.get();
        System.out.println(str);
    }

    private static String getString(Supplier<String> sup){
        return  sup.get();
    }
}
