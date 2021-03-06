package com.zhxh.libglide.request;

import android.content.Context;
import android.widget.ImageView;
import com.zhxh.libglide.listener.RequestListener;
import com.zhxh.libglide.utils.MD5Util;

import java.lang.ref.SoftReference;

/**
 * Created by zhxh on 2019/3/26
 */
public class BitmapRequest {
    //生产者

    //缓存 key --url
    private String uri;
    private SoftReference<ImageView> softReference;//缓存

    private String urlMd5;

    private int loadingResId;
    private Context context;
    private RequestListener requestListener;//监听加载过程

    public BitmapRequest(Context context) {
        this.context = context;
    }


    public BitmapRequest loading(int loadingResId) {
        this.loadingResId = loadingResId;
        return this;
    }


    public BitmapRequest listener(RequestListener requestListener) {
        this.requestListener = requestListener;
        return this;
    }

    public BitmapRequest load(String uri) {
        this.uri = uri;
        this.urlMd5 = MD5Util.md5(uri);
        return this;
    }


    public void into(ImageView imageView) {
        this.softReference = new SoftReference<>(imageView);
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public SoftReference<ImageView> getSoftReference() {
        return softReference;
    }

    public void setSoftReference(SoftReference<ImageView> softReference) {
        this.softReference = softReference;
    }

    public String getUrlMd5() {
        return urlMd5;
    }

    public void setUrlMd5(String urlMd5) {
        this.urlMd5 = urlMd5;
    }

    public int getLoadingResId() {
        return loadingResId;
    }

    public void setLoadingResId(int loadingResId) {
        this.loadingResId = loadingResId;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RequestListener getRequestListener() {
        return requestListener;
    }

    public void setRequestListener(RequestListener requestListener) {
        this.requestListener = requestListener;
    }
}
