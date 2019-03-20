package com.zhxh.libeventbus;

import java.lang.reflect.Method;

/**
 * Created by zhxh on 2019/3/20
 */
public class SubscribeMethod {


    private Method method;
    private ThreadMode threadMode;
    private Class<?> type;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public ThreadMode getThreadMode() {
        return threadMode;
    }

    public void setThreadMode(ThreadMode threadMode) {
        this.threadMode = threadMode;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public SubscribeMethod(Method method, ThreadMode threadMode, Class<?> type) {

    }
}
