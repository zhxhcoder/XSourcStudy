package com.zhxh.module_processlive.activity;

/**
 * Created by zhxh on 2019/3/26
 */
public class KeepManager {

    private volatile static KeepManager instance;

    private KeepManager() {
    }

    public static KeepManager getInstance() {
        if (instance == null) {
            synchronized (KeepManager.class) {
                if (instance == null) {
                    instance = new KeepManager();
                }
            }
        }
        return instance;
    }
}
