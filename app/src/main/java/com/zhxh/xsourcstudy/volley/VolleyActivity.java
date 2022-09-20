package com.zhxh.xsourcstudy.volley;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zhxh.xsourcstudy.R;

public class VolleyActivity extends Activity {
    @BindView( R.id.title_text)
    public TextView title_text;

    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        ButterKnife.bind(this);

        title_text.setText("请求数据");

        mQueue = Volley.newRequestQueue(this);


        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest mStringRequest = new StringRequest(Request.Method.GET, "https://www.baidu.com/", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        title_text.setText(response.substring(0,20));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                mQueue.add(mStringRequest);
            }
        });

        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQueue.cancelAll("volley");
            }
        });

    }
}
