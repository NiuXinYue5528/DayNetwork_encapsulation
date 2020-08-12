package com.example.daynetwork_encapsulation.CategoryConstacts;

import com.example.daynetwork_encapsulation.bean.HomeBen;
import com.example.daynetwork_encapsulation.sofabean.SofaBean;
import com.example.mvp_library.model.BaseModel;
import com.example.mvp_library.model.BaseModelCallBack;
import com.example.mvp_library.model.ModelFractroy;
import com.example.mvp_library.presonter.BasePresonter;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.List;

public class ImpHomePresontin extends BasePresonter<HomeConstacts.HomeView> implements BaseModelCallBack<HomeBen>  {
    @Override
    public void onSuccess(HomeBen homeBen) {
        if (mView!=null){
            mView.showHomeList(homeBen);
        }
    }

    @Override
    public void onError(String msg, int code) {
        mView.onSuccess(msg,code);
    }

    @Override
    public void onCancle() {
        mView.onCancle();
    }


    public void getData() {
        ModelFractroy.createModel(ImpHomeModel.class).getHomeList(this, getLifecycle());
    }

}
