package com.example.http_library.client;

import android.os.Build;

import com.example.http_library.Excption.ExceptionEngine;
import com.example.http_library.callback.BaseObserver;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class HttpObserver {

    //rxjava生命周期绑定
    LifecycleProvider lifecycleProvider;
    //activity的绑定生命周期
    ActivityEvent activityEvent;
    //fragment的生命周期绑定
    FragmentEvent fragmentEvent;

    Observable observable;

    BaseObserver baseObserver;

    public HttpObserver(Builder builder) {
        this.fragmentEvent=builder.fragmentEvent;
        this.activityEvent=builder.activityEvent;
        this.observable=builder.observable;
        this.lifecycleProvider=builder.lifecycleProvider;
        this.baseObserver=builder.baseObserver;
    }

    //错误消息的分类回调
    public Observable onErrorResumeNext(){
        return bindLifecycle().onErrorResumeNext(new Function<Throwable, ObservableSource>() {
            @Override
            public ObservableSource apply(Throwable throwable) throws Exception {
                return Observable.error(ExceptionEngine.handleException(throwable));
            }
        });
    }

    //监听取消订阅的操作
    public Observable doOnDispose(){
        if (baseObserver!=null){
            return onErrorResumeNext().doOnDispose(new Action() {
                @Override
                public void run() throws Exception {
                    baseObserver.canclend();
                }
            });
        }
        return observable;
    }
    //设置线程的切换
    public Observable observable(){
        return doOnDispose().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //初始化返回值
    public Observable map(){
        return observable.map(new Function<JsonElement,Object>() {
            @Override
            public Object apply(JsonElement jsonElement) throws Exception {
                return new Gson().toJson(jsonElement);
            }
        });
    }
    //rxjava生命周期绑定
    private Observable bindLifecycle(){
        Observable observable=map();
       if (lifecycleProvider!=null){
           if (activityEvent!=null||fragmentEvent!=null){
               //两个同时存在，以activity为准
               if (activityEvent!=null&&fragmentEvent!=null){
                   return map().compose(lifecycleProvider.bindUntilEvent(activityEvent));
               }
               if (activityEvent!=null){
                   return map().compose(lifecycleProvider.bindUntilEvent(activityEvent));
               }
               if (fragmentEvent!=null){
                   return map().compose(lifecycleProvider.bindUntilEvent(fragmentEvent));
               }
           }else {
               return map().compose(lifecycleProvider.bindToLifecycle());
           }
       }
        return observable;
    }
    public static final class Builder{
        //rxjava生命周期绑定
        LifecycleProvider lifecycleProvider;
        //activity的绑定生命周期
        ActivityEvent activityEvent;
        //fragment的生命周期绑定
        FragmentEvent fragmentEvent;

        Observable observable;

        BaseObserver baseObserver;



        public LifecycleProvider getLifecycleProvider() {
            return lifecycleProvider;
        }

        public Builder setLifecycleProvider(LifecycleProvider lifecycleProvider) {
            this.lifecycleProvider = lifecycleProvider;
            return this;
        }

        public ActivityEvent getActivityEvent() {
            return activityEvent;

        }

        public Builder setActivityEvent(ActivityEvent activityEvent) {
            this.activityEvent = activityEvent;
            return this;
        }

        public FragmentEvent getFragmentEvent() {
            return fragmentEvent;
        }

        public Builder setFragmentEvent(FragmentEvent fragmentEvent) {
            this.fragmentEvent = fragmentEvent;
            return this;
        }

        public Observable getObservable() {
            return observable;
        }

        public Builder setObservable(Observable observable) {
            this.observable = observable;
            return this;
        }

        public BaseObserver getBaseObserver() {
            return baseObserver;
        }

        public Builder setBaseObserver(BaseObserver baseObserver) {
            this.baseObserver = baseObserver;
            return this;
        }
        public Builder (Observable observable){
            this.observable=observable;
        }
        public HttpObserver builder(){
            return new HttpObserver(this);
        }
    }
}
