package com.zhxh.xsourcstudy.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.zhxh.xsourcstudy.R;

public class OkhttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
