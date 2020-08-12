package com.example.http_library.util;

import android.os.Looper;


public class ThreadUtils {

    //是否是主线程
    public static boolean isMainThread(){
        return Looper.getMainLooper().getThread().getId()==Thread.currentThread().getId();
    }
}
