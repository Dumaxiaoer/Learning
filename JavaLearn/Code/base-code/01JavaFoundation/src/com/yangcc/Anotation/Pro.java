package com.yangcc.Anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述需要执行的类名，方法名
 */
@Target({ElementType.TYPE}) //作用于类上面
@Retention(RetentionPolicy.RUNTIME)  // 保留在class文件中
public @interface Pro {
    String className();
    String methodName();
}
