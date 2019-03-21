package com.zhxh.libmonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    private EditText edtvTest = null;
    private Button btnTest = null;
    private String info = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        if (savedInstanceState != null) {
            System.out.println("--------test---------> text: " + savedInstanceState.getString("text"));
        }
        System.out.println("--------test---------> onCreate");
        edtvTest = findViewById(R.id.edtv_test);
        btnTest = findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent();
                it1.setClass(TestActivity.this, MainActivity.class);
                startActivity(it1);
            }
        });
        Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        System.out.println("--------test---------> onStart");
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        System.out.println("--------test---------> onRestart");
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        System.out.println("--------test---------> onResume");
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        System.out.println("--------test---------> onPause");
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        System.out.println("--------test---------> onStop");
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        System.out.println("--------test---------> onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("text", edtvTest.getText().toString());
        System.out.println("--------test---------> onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        info = savedInstanceState.getString("text");
        System.out.println("--------test---------> onRestoreInstanceState");

    }
}
