package com.zhxh.libeventbus;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhxh on 2019/3/16
 */
public class EventBus {

    private static volatile EventBus instance;
    private Map<Object, List<SubscribeMethod>> cacheMap;

    private Handler mHandler;
    private ExecutorService executorService;

    private EventBus() {
        cacheMap = new HashMap<>();
        mHandler = new Handler(Looper.getMainLooper());
        executorService = Executors.newCachedThreadPool();
    }


    public static EventBus getDefault() {
        if (instance == null) {
            synchronized (EventBus.class) {
                if (instance == null) {
                    instance = new EventBus();
                }
            }
        }

        return instance;
    }


    public void register(Object obj) {

        List<SubscribeMethod> list = cacheMap.get(obj);
        if (list == null) {
            list = findSubscribeMethods(obj);
            cacheMap.put(obj, list);
        }
    }


    public void unregister(Object obj) {

        List<SubscribeMethod> list = cacheMap.get(obj);
        if (list != null) {
            cacheMap.remove(obj);
        }
    }

    private List<SubscribeMethod> findSubscribeMethods(Object obj) {
        List<SubscribeMethod> list = new ArrayList<>();
        Class<?> clazz = obj.getClass();

        while (clazz != null) {//同时也要寻找父类

            //判断当前是否是系统类，如果是，就退出玄幻
            String name = clazz.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                break;
            }

            //得到类中所有方法
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                //通过注解 subscribe找到我们需要注册Eventbus中方法
                Subscribe subscribe = method.getAnnotation(Subscribe.class);
                if (subscribe == null) {
                    continue;
                }
                //获取方法中的参数，并判断是否唯一

                Class<?>[] types = method.getParameterTypes();
                if (types.length != 1) {
                    Log.e("错误", "方法只接受一个参数");

                }

                //获取线程模式
                ThreadMode threadMode = subscribe.threadMode();
                SubscribeMethod subscribeMethod = new SubscribeMethod(method, threadMode, types[0]);

                list.add(subscribeMethod);
            }

            //遍历父类

            clazz = clazz.getSuperclass();
        }

        return list;
    }


    public void post(final Object msg) {

        Set<Object> set = cacheMap.keySet();

        for (final Object obj : set) {
            List<SubscribeMethod> list = cacheMap.get(obj);

            if (list != null) {
                for (final SubscribeMethod subscribeMethod : list) {
                    //对比两个类是否一致
                    if (subscribeMethod.getType().isAssignableFrom(msg.getClass())) {

                        switch (subscribeMethod.getThreadMode()) {
                            case MAIN:
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    invoke(subscribeMethod, obj, msg);
                                } else {
                                    mHandler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            invoke(subscribeMethod, obj, msg);
                                        }
                                    });
                                }

                                break;
                            case BACKGROUND:
                                if (Looper.myLooper() == Looper.getMainLooper()) {

                                    executorService.execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            invoke(subscribeMethod, obj, msg);
                                        }
                                    });
                                } else {
                                    invoke(subscribeMethod, obj, msg);
                                }

                                break;
                        }

                    }

                }
            }
        }
    }

    private void invoke(SubscribeMethod subscribeMethod, Object obj, Object msg) {

        Method method = subscribeMethod.getMethod();

        try {
            method.invoke(obj, msg);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}
