package com.zhxh.xsourcstudy.leakcanary;

import android.app.Activity;
import android.os.Bundle;
import com.zhxh.xsourcstudy.R;

public class LeakCanaryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_canary);
    }
}
