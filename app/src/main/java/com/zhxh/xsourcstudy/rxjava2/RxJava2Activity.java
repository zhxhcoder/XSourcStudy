package com.zhxh.xsourcstudy.rxjava2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.zhxh.xsourcstudy.R;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxJava2Activity extends Activity {

    private static final String TAG = "rxbus";
    private static final CharSequence LINE_SEPARATOR = "\n";
    Button btn;
    TextView textView;
    TextView tvBus;
    TextView tvKitBus;
    protected CompositeDisposable mDisposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java2);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);
        tvBus = findViewById(R.id.tvBus);
        tvKitBus = findViewById(R.id.tvKitBus);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSomeWork2();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        /*注册*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*注销*/

        if (mDisposables != null) {
            mDisposables.clear();
        }
    }

    private void doSomeWork() {

        Disposable disposable = Observable.create((ObservableOnSubscribe<String>) e -> {

            e.onNext("嘟嘟");
            Thread.sleep(5);
            e.onNext("团团");
            e.onComplete();

        }).timeout(2, TimeUnit.MILLISECONDS)
                //子线程运行
                .subscribeOn(Schedulers.io())
                //主线程收到通知
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d(TAG, " accept : " + s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, " throwable : " + throwable.getMessage());
                    }
                });

        mDisposables.add(disposable);
    }

    private void doSomeWork2() {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d("xxxxx", "subscribe " + +System.currentTimeMillis());

                emitter.onNext("嘟嘟");
                emitter.onNext("团团");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("xxxxx", "onSubscribe " + System.currentTimeMillis());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("xxxxx", "onNext " + +System.currentTimeMillis());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("xxxxx", "onError " + +System.currentTimeMillis());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("xxxxx", "onComplete " + +System.currentTimeMillis());
                    }
                });
    }

    private Observer<String> getObserver() {
        return new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(String value) {
                textView.append(" onNext : value : " + value);
                textView.append(LINE_SEPARATOR);
                Log.d(TAG, " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append(LINE_SEPARATOR);
                Log.d(TAG, " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append(LINE_SEPARATOR);
                Log.d(TAG, " onComplete");
            }
        };
    }


}
