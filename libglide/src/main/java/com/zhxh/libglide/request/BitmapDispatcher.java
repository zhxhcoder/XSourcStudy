package com.zhxh.libglide.request;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import java.util.concurrent.BlockingQueue;

/**
 * Created by zhxh on 2019/3/26
 */
public class BitmapDispatcher extends Thread {
    //消费者
    private BlockingQueue<BitmapRequest> requestBlockingQueue;
    private Handler handler = new Handler(Looper.getMainLooper());


    public BitmapDispatcher(BlockingQueue<BitmapRequest> requestBlockingQueue) {
        this.requestBlockingQueue = requestBlockingQueue;
    }

    @Override
    public void run() {


        while (!isInterrupted()) {

            try {
                BitmapRequest request = requestBlockingQueue.take();

                showLoadingImage(request); //先展示loading

                Bitmap bitmap = findBitmap(request);

                //显示UI
                deliveryUIThread(request, bitmap);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

    private void deliveryUIThread(final BitmapRequest request, Bitmap bitmap) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                //防止图片错乱
                ImageView imageView=request.getSoftReference().get();


            }
        });
    }


    private void showLoadingImage(BitmapRequest request) {
    }

    private Bitmap findBitmap(BitmapRequest request) {

        return null;

    }
}
