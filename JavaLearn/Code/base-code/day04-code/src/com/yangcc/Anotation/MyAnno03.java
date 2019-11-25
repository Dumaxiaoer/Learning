package com.yangcc.Anotation;

import java.lang.annotation.*;

/**
 *
 */
@Target(value={ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})  // 表示该MyAnno03注解只能作用于类上
@Retention(RetentionPolicy.RUNTIME)  // 当前描述的注解，会保留到class字节码文件中，并被jvm读取到
@Documented     // 注解是否会被抽取到api文档中
@Inherited //
public @interface MyAnno03 {


}
