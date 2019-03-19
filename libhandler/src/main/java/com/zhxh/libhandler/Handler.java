package com.zhxh.libhandler;

public class Handler {

    private Looper looper;
    public MessageQueue queue;


    public Handler() {

        Looper mLooper = Looper.myLooper();

    }

    public void sendMessage(Message msg) {
        msg.target = this;

    }

    //处理消息
    public void handleMessage(Message msg) {

    }

    public void dispatchMessage(Message msg) {
        handleMessage(msg);
    }
}
