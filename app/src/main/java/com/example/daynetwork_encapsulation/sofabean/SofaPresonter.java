package com.example.daynetwork_encapsulation.sofabean;

import com.example.mvp_library.model.ModelFractroy;
import com.example.mvp_library.presonter.BasePresonter;

import java.util.List;

public class SofaPresonter extends BasePresonter<SofaView> implements ImpSofaModel.SofaCallBack {

    @Override
    public void onSuccess(SofaBean data) {
       mView.onSuccess(data);
    }

    @Override
    public void onVideo(VideoBean bean) {
        mView.onVideo(bean);
    }

    @Override
    public void onText(TextBean bean) {
        mView.onText(bean);
    }


    public void setData() {
        ModelFractroy.createModel(ImpSofaModel.class).setData(this,getLifecycle());
    }

    public void videoDatas() {
        ModelFractroy.createModel(ImpSofaModel.class).videoDatas(this,getLifecycle());
    }

    public void setTextData() {
        ModelFractroy.createModel(ImpSofaModel.class).setTextData(this,getLifecycle());
    }
}
