package com.zhxh.libmonitor;

import android.app.Application;

/**
 * Created by zhxh on 2019/3/21
 */
public class MApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        XPrinterForGetBlockInfo.start();
    }
}
