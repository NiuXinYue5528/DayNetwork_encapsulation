package com.example.http_library.callback;

import android.util.Log;

import com.example.http_library.Excption.ExceptionEngine;
import com.google.gson.JsonElement;

public abstract class BaseCallBack<T> extends BaseObserver  {
    //解析成功的标志
    boolean callSuccess=true;

    @Override
    public void onNext(Object t) {
        super.onNext(t);
        //返回的是个json串
        T parse=parse((String) t);
        //Log.i("111", "onNext: "+t.toString());
        if (callSuccess&&isCodeSuccess()){
            onSuccess(parse);
        }
    }

    //返回获取的泛型数据
    protected abstract void onSuccess(T parse);

    //数据返回的状态码成功
    protected abstract boolean isCodeSuccess();

    public T parse(String result){
        T data=null;
        try {
            data = onconver(result);
            callSuccess=true;
        } catch (Exception e) {
            e.printStackTrace();
            callSuccess=false;
            onError("解析数据错误", ExceptionEngine.ANALYTIC_CLIENT_DATA_ERROR);
        }
        return data;

    }

    //将jsonelement转换为response，并且通过子类的视线来获取data数据
    protected abstract T onconver(String result);

    //将我们需要的数据解析出来
    public abstract T convert(JsonElement result);
}
