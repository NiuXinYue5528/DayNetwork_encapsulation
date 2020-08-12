package com.example.daynetwork_encapsulation.sofabean;

import com.example.daynetwork_encapsulation.callback.HomeCallaBack;
import com.example.http_library.client.HttpClient;
import com.example.http_library.util.JsonUtils;
import com.example.mvp_library.model.BaseModel;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.List;

public class ImpSofaModel implements BaseModel {
    interface SofaCallBack{
        void onSuccess(SofaBean data);
        void onVideo(VideoBean bean);
        void onText(TextBean bean);
    }
    public void setTextData(SofaCallBack sofaCallBack, LifecycleProvider lifecycle) {
        new HttpClient.Bulider()
                .setLifecycleProvider(lifecycle)
                .setBaseUrl("http://123.56.232.18:8080/serverdemo/feeds/")
                .setApiUrl("queryHotFeedsList?pageCount=12&feedId=0&userId=0&feedType=text")
                .get()
                .build()
                .request(new HomeCallaBack<TextBean>() {
                    @Override
                    protected void onError(String msg, int code) {

                    }

                    @Override
                    protected void cancle() {

                    }

                    @Override
                    protected void onSuccess(TextBean parse) {
                        sofaCallBack.onText(parse);
                    }

                    @Override
                    public TextBean convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, TextBean.class);
                    }
                });
    }


    public void videoDatas(SofaCallBack sofaCallBack, LifecycleProvider lifecycle) {
        new HttpClient.Bulider()
                .setBaseUrl("http://123.56.232.18:8080/serverdemo/feeds/")
                .setApiUrl("queryHotFeedsList?pageCount=12&feedId=0&userId=0&feedType=video")
                .get()
                .setLifecycleProvider(lifecycle)
                .build()
                .request(new HomeCallaBack<VideoBean>() {
                    @Override
                    protected void onError(String msg, int code) {

                    }

                    @Override
                    protected void cancle() {

                    }

                    @Override
                    protected void onSuccess(VideoBean parse) {
                        sofaCallBack.onVideo(parse);
                    }

                    @Override
                    public VideoBean convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, VideoBean.class);
                    }
                });

    }


    void setData(SofaCallBack sofaCallBack, LifecycleProvider lifecycle){
        new HttpClient.Bulider()
                .setLifecycleProvider(lifecycle)
                .setBaseUrl("http://123.56.232.18:8080/serverdemo/feeds/")
                .setApiUrl("queryHotFeedsList?pageCount=12&feedId=0&userId=0&feedType=pics")
                .get()
                .build()
                .request(new HomeCallaBack<SofaBean>() {
                    @Override
                    protected void onError(String msg, int code) {
                    }

                    @Override
                    protected void cancle() {
                    }

                    @Override
                    protected void onSuccess(SofaBean beans) {
                        sofaCallBack.onSuccess(beans);
                    }

                    @Override
                    public SofaBean convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, SofaBean.class);
                    }
                });
    }


}
