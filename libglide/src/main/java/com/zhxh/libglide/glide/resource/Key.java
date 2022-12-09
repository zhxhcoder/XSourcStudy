package com.zhxh.libglide.glide.resource;

import com.zhxh.libglide.glide.util.Tool;

public class Key {
    private String key;

    public Key(String path){
        this.key = Tool.getSHA256StrJava(path);
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
