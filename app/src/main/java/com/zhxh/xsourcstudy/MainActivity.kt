package com.zhxh.xsourcstudy

import android.content.Intent
import android.app.Activity
import android.os.Bundle
import com.zhxh.xsourcstudy.arouter.ARouterActivity
import com.zhxh.xsourcstudy.butterknife.ButterknifeActivity
import com.zhxh.xsourcstudy.dagger2.Dagger2Activity
import com.zhxh.xsourcstudy.eventbus.EventbusActivity
import com.zhxh.xsourcstudy.fresco.FrescoActivity
import com.zhxh.xsourcstudy.glide.GlideActivity
import com.zhxh.xsourcstudy.leakcanary.LeakCanaryActivity
import com.zhxh.xsourcstudy.lifecycle.ActivityA
import com.zhxh.xsourcstudy.okhttp.OkhttpActivity
import com.zhxh.xsourcstudy.retrofit.RetrofitActivity
import com.zhxh.xsourcstudy.rxjava2.RxJava2Activity
import com.zhxh.xsourcstudy.sophix.SophixActivity
import com.zhxh.xsourcstudy.tinker.TinkerActivity
import com.zhxh.xsourcstudy.volley.VolleyActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //从原生中调用
        title_text.text = stringFromJNI()

        btn_volley.setOnClickListener { startActivity(Intent(this@MainActivity, VolleyActivity::class.java)) }
        btn_retrofit.setOnClickListener { startActivity(Intent(this@MainActivity, RetrofitActivity::class.java)) }
        btn_okhttp.setOnClickListener { startActivity(Intent(this@MainActivity, OkhttpActivity::class.java)) }
        btn_rxjava.setOnClickListener { startActivity(Intent(this@MainActivity, RxJava2Activity::class.java)) }
        btn_eventbus.setOnClickListener { startActivity(Intent(this@MainActivity, EventbusActivity::class.java)) }
        btn_butterknife.setOnClickListener { startActivity(Intent(this@MainActivity, ButterknifeActivity::class.java)) }
        btn_dagger.setOnClickListener { startActivity(Intent(this@MainActivity, Dagger2Activity::class.java)) }
        btn_arouter.setOnClickListener { startActivity(Intent(this@MainActivity, ARouterActivity::class.java)) }
        btn_leakcanary.setOnClickListener { startActivity(Intent(this@MainActivity, LeakCanaryActivity::class.java)) }
        btn_tinker.setOnClickListener { startActivity(Intent(this@MainActivity, TinkerActivity::class.java)) }
        btn_sophix.setOnClickListener { startActivity(Intent(this@MainActivity, SophixActivity::class.java)) }
        btn_glide.setOnClickListener { startActivity(Intent(this@MainActivity, GlideActivity::class.java)) }
        btn_fresco.setOnClickListener { startActivity(Intent(this@MainActivity, FrescoActivity::class.java)) }
        btn_lifecycle.setOnClickListener { startActivity(Intent(this@MainActivity, ActivityA::class.java)) }
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
