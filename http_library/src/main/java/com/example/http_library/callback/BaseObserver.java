package com.example.http_library.callback;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.example.http_library.Excption.ApiExcption;
import com.example.http_library.Excption.ExceptionEngine;
import com.example.http_library.HttpGlobalConfig;
import com.example.http_library.disposable.ImpRequestManager;
import com.example.http_library.util.ThreadUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver implements Observer {
    String tag;
    @Override
    public void onSubscribe(Disposable d) {
        if (!TextUtils.isEmpty(tag)){
            ImpRequestManager.getInstance().add(tag, d);
        }

    }

    @Override
    public void onNext(Object o) {
        if (!TextUtils.isEmpty(tag)){
            ImpRequestManager.getInstance().remove(tag);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ApiExcption){
            ApiExcption apiExcption= (ApiExcption) e;
            onError(apiExcption.getMsg(),apiExcption.getCode());
        }else {
            onError("未知异常", ExceptionEngine.UN_KNOWN_ERROR);
        }
        if (!TextUtils.isEmpty(tag)){
            ImpRequestManager.getInstance().remove(tag);
        }
    }

    //回调错误的信息
    protected abstract void onError(String msg, int code);


    @Override
    public void onComplete() {
        if (!ImpRequestManager.getInstance().isdispoable(tag)){
            ImpRequestManager.getInstance().cancle(tag);
        }
    }

    //标识订阅
    public void setTag(String tag) {
        this.tag = tag;

    }

    //网络请求取消
    public void canclend(){
        if (!ThreadUtils.isMainThread()){
            HttpGlobalConfig.getInstance().getHandler().post(new Runnable() {
                @Override
                public void run() {
                    cancle();
                }
            });
        }
    }

    protected abstract void cancle();
}
