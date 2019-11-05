package com.yangcc.Exception;

import java.util.Scanner;

public class RegisterExceptionMain {
    private static String[] userNames={"你","我","她"};

    public static void main(String[] args) throws RegisterException {
        Scanner sc =new Scanner(System.in);
        String userName=sc.next();
        check(userName);

    }
    public static void check(String userName) throws RegisterException {
        for (String name : userNames) {
            if (name.equals(userName)){
                throw  new RegisterException("该用户已被注册");
            }
        }
        System.out.println("注册成功");
    }
}
