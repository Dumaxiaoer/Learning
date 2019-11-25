package com.yangcc.Functional.Lambda;

public class Demo01Lambda {
    public static void main(String[] args) {
        String msg1="Hellow";
        String msg2="shit";
        String msg3="fuck";
        // 传递lambda
        showLog(1,()->{
            // 返回一个拼接好的字符串
           return msg1+msg2+msg3;
        });
    }
    /*
    显示日志
     */
    private static void showLog(int lv,MessageBuilder mb){
        // 判断等级
        if (lv==1){
            System.out.println(mb.builderMessage());
        }
    }
}
