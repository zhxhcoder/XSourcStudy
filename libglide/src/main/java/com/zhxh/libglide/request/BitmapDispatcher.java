package com.zhxh.libglide.request;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.BlockingQueue;

/**
 * Created by zhxh on 2019/3/26
 */
public class BitmapDispatcher extends Thread {
    private BlockingQueue<BitmapRequest> requestBlockingQueue;
    private Handler handler = new Handler(Looper.getMainLooper());


    public BitmapDispatcher(BlockingQueue<BitmapRequest> requestBlockingQueue) {
        this.requestBlockingQueue = requestBlockingQueue;
    }

    @Override
    public void run() {


        while (!isInterrupted()) {


        }


    }
}
