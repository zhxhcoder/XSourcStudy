package com.zhxh.libglide.lifecycle;


/**
 * Created by zhxh on 2019/3/26
 */
public class LifecycleObservable {


    private volatile static LifecycleObservable instance;

    private LifecycleObservable() {
    }

    public static LifecycleObservable getInstance() {
        if (instance == null) {
            synchronized (LifecycleObservable.class) {
                if (instance == null) {
                    instance = new LifecycleObservable();
                }
            }
        }

        return instance;
    }

    public void onDestroy() {
    }
}
