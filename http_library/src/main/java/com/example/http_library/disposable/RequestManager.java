package com.example.http_library.disposable;

import io.reactivex.disposables.Disposable;

public interface RequestManager {

    //tag  订阅关系的标识
    //disposable  订阅关系

    //添加标签和订阅关系
    void add(String tag, Disposable disposable);

    //移除订阅
    void remove(String tag);

    //取消订阅
    void cancle(String tag);
    //取消所有订阅
    void cancleAll();
}
