package com.example.daynetwork_encapsulation.callback;

import android.util.Log;

import com.example.daynetwork_encapsulation.bean.HomeGetBean;
import com.example.http_library.callback.BaseCallBack;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class HomeCallaBack<T> extends BaseCallBack<T> {
    HomeGetBean homeGetBean;


    @Override
    protected T onconver(String result) {
        T t=null;
       homeGetBean= new Gson().fromJson(result.toString(), HomeGetBean.class);
        JsonElement data = homeGetBean.getData();
       // Log.e("111", "onconver: "+data.toString() );
        String message = homeGetBean.getMessage();
        int status = homeGetBean.getStatus();
        switch (status){
            case -1:
                onError(message, status);
                break;
            case 200:
                t=convert(data);
                break;
        }
        return t;
    }
    @Override
    protected boolean isCodeSuccess() {
        if (homeGetBean!=null){
            return homeGetBean.getStatus()==200;
        }
        return false;
    }


}
