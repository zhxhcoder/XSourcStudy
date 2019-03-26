package com.zhxh.libglide.lifecycle;

import android.app.Fragment;
import android.content.Context;

/**
 * Created by zhxh on 2019/3/26
 */
public class RequestManagerFragment extends Fragment {

    LifecycleObservable lifeCycleObservable = LifecycleObservable.getInstance();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        lifeCycleObservable.onDestroy();
    }
}
