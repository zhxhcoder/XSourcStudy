package com.zhxh.libglide.request;

/**
 * Created by zhxh on 2019/3/26
 */
public class RequestManager {

    private volatile static RequestManager instance;

    private RequestManager() {
    }

    public static RequestManager getInstance() {
        if (instance == null) {
            synchronized (RequestManager.class) {
                if (instance == null) {
                    instance = new RequestManager();
                }
            }
        }

        return instance;
    }

}
