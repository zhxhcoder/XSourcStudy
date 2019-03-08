package com.zhxh.xsourcstudy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.zhxh.xsourcstudy.volley.VolleyActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //从原生中调用
        title_text.text = stringFromJNI()


        btn_volley.setOnClickListener { startActivity(Intent(this@MainActivity, VolleyActivity::class.java)) }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
