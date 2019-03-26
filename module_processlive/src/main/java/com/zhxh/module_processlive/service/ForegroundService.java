package com.zhxh.module_processlive.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ForegroundService extends Service {
    private static final int SERVIE_ID = 1;

    public ForegroundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
