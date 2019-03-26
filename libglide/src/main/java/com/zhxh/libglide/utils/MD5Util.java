package com.zhxh.libglide.utils;

/**
 * Created by zhxh on 2019/3/26
 */
public class MD5Util {
    //去掉url的特殊值 这里暂时简化处理 删除特殊符号
    public static String md5(String uri) {
        return uri.replaceAll("[^\\w]+", "");
    }
}
