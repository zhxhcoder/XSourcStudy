package com.zhxh.xsourcstudy.butterknife;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.zhxh.xsourcstudy.R;

public class ButterknifeActivity extends Activity {
    @BindView( R.id.title_text)
    public TextView title_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);

        ButterKnife.bind(this);
    }
}
