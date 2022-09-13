package com.zhxh.libglide.core;

import android.app.Activity;
import android.app.FragmentManager;
import com.zhxh.libglide.lifecycle.RequestManagerFragment;
import com.zhxh.libglide.request.BitmapRequest;

/**
 * Created by zhxh on 2019/3/26
 */
public class Glide {
    public static BitmapRequest with(Activity activity) {

        FragmentManager fm = activity.getFragmentManager();

        RequestManagerFragment current = new RequestManagerFragment();

        fm.beginTransaction().add(current, "glide").commitAllowingStateLoss();

        if (current==null) {

        }
        return new BitmapRequest(activity);
    }
}
