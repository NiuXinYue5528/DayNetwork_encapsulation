package com.example.daynetwork_encapsulation.CategoryConstacts;

import com.example.daynetwork_encapsulation.bean.HomeBen;
import com.example.daynetwork_encapsulation.bean.HomeGetBean;
import com.example.daynetwork_encapsulation.callback.HomeCallaBack;
import com.example.daynetwork_encapsulation.sofabean.SofaBean;
import com.example.http_library.client.HttpClient;
import com.example.http_library.util.JsonUtils;
import com.example.mvp_library.model.BaseModelCallBack;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class ImpHomeModel implements HomeConstacts.HomeModel {
    @Override
        public void getHomeList(BaseModelCallBack<HomeBen> modelCallBack, LifecycleProvider lifecycleProvider) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("pageCount", "12");
        map.put("feedId", "0");
        map.put("userId", "0");
        map.put("feedType", "all");
        new HttpClient.Bulider()
                .setBaseUrl("http://123.56.232.18:8080/serverdemo/feeds/")
                .setApiUrl("queryHotFeedsList")
                .get()
                .setHeaders(map)
                .setLifecycleProvider(lifecycleProvider)//rxjava绑定
                .build()
                .request(new HomeCallaBack<HomeBen>() {
                    @Override
                    protected void onError(String msg, int code) {
                        onError(msg,code);
                    }

                    @Override
                    protected void cancle() {
                        modelCallBack.onCancle();
                    }

                    @Override
                    protected void onSuccess(HomeBen parse) {
                        modelCallBack.onSuccess(parse);
                    }

                    @Override
                    public HomeBen convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, HomeBen.class);
                    }
                });
    }




    public void setData(BaseModelCallBack baseModelCallBack, LifecycleProvider lifecycle) {


    }
    @Override
    public void onError(String msg, int code) {

    }
}
