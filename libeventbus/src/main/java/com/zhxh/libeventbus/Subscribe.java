package com.zhxh.libeventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhxh on 2019/3/20
 */

@Target(ElementType.METHOD)
//注解会在class字节码文件中存在，jvm在加载时候可以通过反射获得
@Retention(RetentionPolicy.RUNTIME)
public @interface  Subscribe {
    ThreadMode threadMode() default ThreadMode.MAIN;
}
