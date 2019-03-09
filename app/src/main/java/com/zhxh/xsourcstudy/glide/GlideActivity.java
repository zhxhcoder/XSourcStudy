package com.zhxh.xsourcstudy.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.zhxh.xsourcstudy.R;

public class GlideActivity extends AppCompatActivity {
    @BindView( R.id.iv_show)
    public ImageView iv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        ButterKnife.bind(this);

    }
}
