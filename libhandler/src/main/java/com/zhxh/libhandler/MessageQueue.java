package com.zhxh.libhandler;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MessageQueue {

    private Message[] messages;
    private int putIndex;
    private int takeIndex;

    private int count;
    private Lock lock;

    private Condition noEmpty;
    private Condition notFull;



    //出队
    public Message next() {

        Message msg = null;

        return msg;
    }
}
