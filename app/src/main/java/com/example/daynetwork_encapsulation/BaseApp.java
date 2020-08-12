package com.example.daynetwork_encapsulation;

import android.app.Application;

import com.example.http_library.HttpGlobalConfig;
import com.example.http_library.client.HttpConstant;

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpGlobalConfig.getInstance()
                .setShowLog(true)
                 .setTimeUnit(HttpConstant.TIME_UNIT)
                .setTimeout(HttpConstant.TIME_OUT)
                .initReady(this);

    }
}
