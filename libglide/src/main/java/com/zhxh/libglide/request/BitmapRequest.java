package com.zhxh.libglide.request;

import android.content.Context;
import android.widget.ImageView;
import com.zhxh.libglide.listener.RequestListener;

import java.lang.ref.SoftReference;

/**
 * Created by zhxh on 2019/3/26
 */
public class BitmapRequest {

    //缓存 key --url
    private String uri;
    private SoftReference<ImageView> softReference;

    private String urlMd5;

    private int loadingResId;
    private Context context;
    private RequestListener requestListener;



}
