package com.yangcc.Exception;
/*
自定义异常类
    提供的不够使用，自定义
    继承Exception或者RuntimeException
 */
public class RegisterException  extends Exception {
    public RegisterException() {
        super();
    }

    public RegisterException(String message) {
        super(message);
    }

}
