package com.example.daynetwork_encapsulation.sofabean;

import com.example.mvp_library.view.BaseView;

import java.util.List;

public interface SofaView  extends BaseView {
    void onSuccess(SofaBean data);
    void onFail(String error);

    void onVideo(VideoBean bean);
    void onText(TextBean bean);
}
