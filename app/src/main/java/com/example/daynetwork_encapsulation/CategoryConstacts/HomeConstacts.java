package com.example.daynetwork_encapsulation.CategoryConstacts;

import com.example.daynetwork_encapsulation.bean.HomeBen;
import com.example.mvp_library.model.BaseModel;
import com.example.mvp_library.model.BaseModelCallBack;
import com.example.mvp_library.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.List;

public interface HomeConstacts {
    interface HomeView extends BaseView{
       void  showHomeList(HomeBen ben);
    }
    interface HomePresonter{
        void getHomePresonter();
    }

    interface HomeModel extends BaseModel{
        void getHomeList(BaseModelCallBack<HomeBen> modelCallBack, LifecycleProvider lifecycleProvider);
        void onError(String msg,int code);
    }
}
