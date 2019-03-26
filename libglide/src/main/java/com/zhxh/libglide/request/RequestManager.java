package com.zhxh.libglide.request;

import android.util.Log;

import java.util.concurrent.LinkedBlockingQueue;

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

    //阻塞式队列
    private LinkedBlockingQueue<BitmapRequest> requestLinkedBlockingQueue = new LinkedBlockingQueue<>();

    public void addBitmapRequest(BitmapRequest request) {
        if (!requestLinkedBlockingQueue.contains(request)) {
            requestLinkedBlockingQueue.add(request);
        } else {
            Log.e("error", "任务已经存在");
        }
    }

    //转发器管理
    private BitmapDispatcher[] dispatchers;


    public void start() {
        stop();
        int threadCount = Runtime.getRuntime().availableProcessors();

        dispatchers = new BitmapDispatcher[threadCount];

        for (int i = 0; i < dispatchers.length; i++) {
            BitmapDispatcher bitmapDispatcher = new BitmapDispatcher(requestLinkedBlockingQueue);
            bitmapDispatcher.start();
            dispatchers[i] = bitmapDispatcher;
        }
    }

    private void stop() {
    }

}
