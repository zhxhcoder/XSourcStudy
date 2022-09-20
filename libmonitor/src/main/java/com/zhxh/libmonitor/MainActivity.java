package com.zhxh.libmonitor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText edtvTest = null;
    private Button btnTest = null;
    private String info = "";
    Display display;
    private Point mDisplaySize = new Point();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("--------main---------> time0: " + System.currentTimeMillis());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            System.out.println("--------main---------> text: " + savedInstanceState.getString("text"));
        }
        System.out.println("--------main---------> onCreate");
        edtvTest = findViewById(R.id.edtv_test);
        btnTest = findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent();
                it1.setClass(MainActivity.this, TestActivity.class);
                startActivity(it1);
            }
        });
        Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG).show();

        display = getWindowManager().getDefaultDisplay();
        display.getSize(mDisplaySize);
        System.out.println("--------main---------> display="+mDisplaySize.toString());

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        System.out.println("--------main---------> onStart");
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        System.out.println("--------main---------> time1: " + System.currentTimeMillis());
        System.out.println("--------main---------> onRestart");
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        System.out.println("--------main---------> onResume");
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        System.out.println("--------main---------> onPause");
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        System.out.println("--------main---------> onStop");
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        System.out.println("--------main---------> onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("text", edtvTest.getText().toString());
        System.out.println("--------main---------> onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        info = savedInstanceState.getString("text");
        System.out.println("--------main---------> onRestoreInstanceState");

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        System.out.println("--------main---------> time2: " + System.currentTimeMillis());

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        System.out.println("--------main---------> time3: " + System.currentTimeMillis());

    }
}