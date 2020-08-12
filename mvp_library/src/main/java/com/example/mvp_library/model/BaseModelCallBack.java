package com.example.mvp_library.model;

public interface BaseModelCallBack<T> {
    void onSuccess(T t);
    void onError(String msg,int code);
    void onCancle();
}
