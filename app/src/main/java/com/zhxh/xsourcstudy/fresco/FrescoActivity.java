package com.zhxh.xsourcstudy.fresco;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhxh.xsourcstudy.R;

public class FrescoActivity extends Activity {
    //@BindView( R.id.simple_drawee_view)
    //public SimpleDraweeView simple_drawee_view;
    private final String imgUrl = "https://www.baidu.com/img/bd_logo1.png";

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);

        Fresco.initialize(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);


        Uri uri = Uri.parse(imgUrl);
        SimpleDraweeView draweeView = findViewById(R.id.simple_drawee_view);
        draweeView.setImageURI(uri);

    }
}
