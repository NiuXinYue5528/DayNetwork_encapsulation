package com.example.http_library.client;

import android.text.TextUtils;

import com.example.http_library.HttpGlobalConfig;
import com.example.http_library.HttpManager;
import com.example.http_library.callback.BaseCallBack;
import com.example.http_library.service.ApiService;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

public class HttpClient {
    //请求方式
    Method method;
    //请求参数
    Map<String,Object> paramser;
    //请求头信息
    Map<String,Object> headers;
    //rxjava生命周期绑定
    LifecycleProvider lifecycleProvider;
    //activity的绑定生命周期
    ActivityEvent activityEvent;
    //fragment的生命周期绑定
    FragmentEvent fragmentEvent;
    String baseUrl;
    //拼接url
    String apiUrl;
    //是否是json上传
    boolean isJson;
    //json字符串
    String jsonBody;
    //超时时间
    long time;
    //时间单位
    TimeUnit timeUnit;
    //回调接口
    BaseCallBack baseCallBack;
    //订阅标识
    String tag;

    public HttpClient(Bulider bulider) {
        this.method=bulider.method;
        this.activityEvent=bulider.activityEvent;
        this.fragmentEvent=bulider.fragmentEvent;
        this.apiUrl=bulider.apiUrl;
        this.timeUnit=bulider.timeUnit;
        this.baseUrl=bulider.baseUrl;
        this.isJson=bulider.isJson;
        this.baseCallBack=bulider.baseCallBack;
        this.paramser=bulider.paramser;
        this.lifecycleProvider=bulider.lifecycleProvider;
        this.jsonBody=bulider.jsonBody;
        this.headers=bulider.headers;
        this.tag=bulider.tag;
    }
    public void request(BaseCallBack baseCallBack){
        if (baseCallBack==null){
            new RuntimeException("no have callback,must do Obsercer") ;
        }
        this.baseCallBack=baseCallBack;
        doRequest();
    }

    private void doRequest() {
        //组装obserable，并且根据请求方法返回的对应的obserable，去处理异常结果的回调
        if (TextUtils.isEmpty(tag)){
            tag=System.currentTimeMillis()+"";//当前线程
        }
        baseCallBack.setTag(tag);
        //添加请求的参数
        addPramaers();
        //添加头信息
        addHeaders();
        //创建jsonElement
        Observable observable=createObsercabler();
        HttpObserver builder = new HttpObserver.Builder(observable)
                .setBaseObserver(baseCallBack)
                .setFragmentEvent(fragmentEvent)
                .setActivityEvent(activityEvent)
                .builder();
        builder.observable().subscribe(baseCallBack);
    }

    private Observable createObsercabler() {
        Observable observable=null;
        boolean hasBofyString =!TextUtils.isEmpty(jsonBody);
        RequestBody requestBody=null;
        if (hasBofyString){
            String mediaType = isJson ? "application/json; charset=utf-8" : "text/plain;charset=utf-8";
            requestBody=RequestBody.create(MediaType.parse(mediaType), jsonBody);
        }
        //默认请求post
        if (method==null){
            method=Method.POST;
        }
        if (HttpGlobalConfig.getInstance().getBaseUrl()!=null){
            this.baseUrl=HttpGlobalConfig.getInstance().getBaseUrl();
        }
        if (HttpGlobalConfig.getInstance().getTimeUnit()!=null){
            this.timeUnit=HttpGlobalConfig.getInstance().getTimeUnit();
        }
        if (HttpGlobalConfig.getInstance().getTimeout()!=0){
            this.time=HttpGlobalConfig.getInstance().getTimeout();
        }
        if (this.time==0){
            this.time=HttpConstant.TIME_OUT;
        }
        if (this.timeUnit==null){
            this.timeUnit=HttpConstant.TIME_UNIT;
        }
        ApiService  apiService= HttpManager.getInstance().getRetrofit(baseUrl, time, timeUnit).create(ApiService.class);
        switch (method){
            case POST:
                if (isJson){
                    observable=apiService.jsonPost(apiUrl, requestBody, headers);
                }else {
                    observable=apiService.post(apiUrl, paramser, headers);
                }
                break;
            case GET:
                observable=apiService.get(apiUrl, paramser,headers);
                break;
            case DELETE:
                observable=apiService.get(apiUrl, paramser,headers);
                break;
            case PUT:
                observable=apiService.get(apiUrl, paramser,headers);
                break;
        }
        return observable;
    }

    private void addHeaders() {
        if (headers==null){
            headers=new HashMap<>();
        }
        if (HttpGlobalConfig.getInstance().getBaseHeades()!=null){
            headers.putAll(HttpGlobalConfig.getInstance().getBaseHeades());
        }
    }

    private void addPramaers() {
        if (paramser==null){
            paramser=new HashMap<>();
        }
        if (HttpGlobalConfig.getInstance().getBaseParams()!=null){
            paramser.putAll(HttpGlobalConfig.getInstance().getBaseHeades());
        }
    }


    //Method   的get set方法
    public Method get(){
        return Method.GET;
    }
    public Method post(){
        return Method.POST;
    }
    public Method delete(){
        return Method.DELETE;
    }
    public Method put(){
        return Method.PUT;
    }

    public static  class Bulider{
        //请求方式
        Method method;
        //请求参数
        Map<String,Object> paramser;
        //请求头信息
        Map<String,Object> headers;
        //rxjava生命周期绑定
        LifecycleProvider lifecycleProvider;
        //activity的绑定生命周期
        ActivityEvent activityEvent;
        //fragment的生命周期绑定
        FragmentEvent fragmentEvent;
        String baseUrl;
        //拼接url
        String apiUrl;
        //是否是json上传
        boolean isJson;
        //json字符串
        String jsonBody;
        //超时时间
        long time;
        //时间单位
        TimeUnit timeUnit;
        //回调接口
        BaseCallBack baseCallBack;
        //订阅标识
        String tag;

        public Bulider(){}

        //Method   的get set方法
        public Bulider get(){
            this.method=Method.GET;
            return this;
        }
        public Bulider post(){
            this.method=Method.POST;
            return this;
        }
        public Bulider delete(){
            this.method=Method.DELETE;
            return this;
        }
        public Bulider put(){
            this.method=Method.PUT;
            return this;
        }
        public Map<String, Object> getParamser() {
            return paramser;
        }

        public Bulider setParamser(Map<String, Object> paramser) {
            this.paramser = paramser;
            return this;
        }

        public Map<String, Object> getHeaders() {
            return headers;
        }

        public Bulider setHeaders(Map<String, Object> headers) {
            this.headers = headers;
            return this;
        }

        public LifecycleProvider getLifecycleProvider() {
            return lifecycleProvider;
        }

        public Bulider setLifecycleProvider(LifecycleProvider lifecycleProvider) {
            this.lifecycleProvider = lifecycleProvider;
            return this;
        }

        public ActivityEvent getActivityEvent() {
            return activityEvent;
        }

        public Bulider setActivityEvent(ActivityEvent activityEvent) {
            this.activityEvent = activityEvent;
            return this;
        }

        public FragmentEvent getFragmentEvent() {
            return fragmentEvent;
        }

        public Bulider setFragmentEvent(FragmentEvent fragmentEvent) {
            this.fragmentEvent = fragmentEvent;
            return this;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public Bulider setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public String getApiUrl() {
            return apiUrl;
        }

        public Bulider setApiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
            return this;
        }

        public boolean isJson() {
            return isJson;
        }

        public Bulider setJson(boolean json) {
            isJson = json;
            return this;
        }

        public String getJsonBody() {
            return jsonBody;
        }

        public Bulider setJsonBody(String jsonBody) {
            this.jsonBody = jsonBody;
            return this;
        }

        public long getTime() {
            return time;
        }

        public Bulider setTime(long time) {
            this.time = time;
            return this;
        }

        public TimeUnit getTimeUnit() {
            return timeUnit;
        }

        public Bulider setTimeUnit(TimeUnit timeUnit) {
            this.timeUnit = timeUnit;
            return this;
        }
        public HttpClient build(){
            return new HttpClient(this);
        }
    }

}
