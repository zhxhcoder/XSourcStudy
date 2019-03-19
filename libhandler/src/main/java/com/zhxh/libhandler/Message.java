package com.zhxh.libhandler;

public class Message {
    public Handler target;
    public Object obj;
    public int what;
    public Message(){

    }

    @Override
    public String toString() {
        return obj.toString();
    }


}
