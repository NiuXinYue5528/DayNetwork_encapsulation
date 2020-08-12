package com.example.http_library;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;

public class HttpGlobalConfig {

    private String baseUrl;//接口
    private long timeout;//时间
    private TimeUnit timeUnit;//时间单位
    //公开的请求参数
    private Map<String,Object> baseParams;
    //公开的请求头
    private Map<String,Object> baseHeades;
    //公开的拦截器
    private List<Interceptor> interceptors;
    //日志开关
    private boolean isShowLog;
    //上下文
    private Context context;
    //handler
    private Handler handler;

    //静态内部类
    private static final class HttpGlobalConfigHolder {
        private static HttpGlobalConfig INSTANCE = new HttpGlobalConfig();
    }
        public static HttpGlobalConfig getInstance() {
            return HttpGlobalConfigHolder.INSTANCE;
        }

    public HttpGlobalConfig(){}


    public String getBaseUrl() {
        return baseUrl;
    }

    public HttpGlobalConfig setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return HttpGlobalConfig.getInstance();
    }

    public long getTimeout() {
        return timeout;
    }

    public HttpGlobalConfig setTimeout(long timeout) {
        this.timeout = timeout;
        return HttpGlobalConfig.getInstance();
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public HttpGlobalConfig setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        return HttpGlobalConfig.getInstance();
    }

    public Map<String, Object> getBaseParams() {
        return baseParams;
    }

    public HttpGlobalConfig setBaseParams(Map<String, Object> baseParams) {
        this.baseParams = baseParams;
        return HttpGlobalConfig.getInstance();
    }

    public Map<String, Object> getBaseHeades() {
        return baseHeades;
    }

    public HttpGlobalConfig setBaseHeades(Map<String, Object> baseHeades) {
        this.baseHeades = baseHeades;
        return HttpGlobalConfig.getInstance();
    }

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public HttpGlobalConfig setInterceptors(List<Interceptor> interceptors) {
        this.interceptors = interceptors;
        return HttpGlobalConfig.getInstance();
    }

    public boolean isShowLog() {
        return isShowLog;
    }

    public HttpGlobalConfig setShowLog(boolean showLog) {
        isShowLog = showLog;
        return HttpGlobalConfig.getInstance();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public HttpGlobalConfig initReady(Context context){
        this.context=context.getApplicationContext();
        handler=new Handler(Looper.getMainLooper());//主线程
        return HttpGlobalConfig.getInstance();
    }

}
