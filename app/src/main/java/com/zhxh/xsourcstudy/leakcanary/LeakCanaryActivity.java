package com.zhxh.xsourcstudy.leakcanary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.zhxh.xsourcstudy.R;

public class LeakCanaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_canary);
    }
}
