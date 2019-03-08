package com.zhxh.xsourcstudy.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.zhxh.xsourcstudy.R;

public class VolleyActivity extends AppCompatActivity {
    public static RequestQueue queues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
    }
}
