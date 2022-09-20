package com.zhxh.xsourcstudy.glide;

import android.graphics.drawable.Drawable;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.zhxh.xsourcstudy.R;

public class GlideActivity extends Activity {
    @BindView(R.id.iv_show)
    public ImageView iv_show;


    private final String imgUrl = "https://www.baidu.com/img/bd_logo1.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        ButterKnife.bind(this);

        RequestOptions myOptions = new RequestOptions()
                .fitCenter()
                .placeholder(R.mipmap.ic_red)
                .override(100, 100);

        Glide.with(this)
                .load(imgUrl)
                .apply(myOptions)
                .into(iv_show);

    }
}
