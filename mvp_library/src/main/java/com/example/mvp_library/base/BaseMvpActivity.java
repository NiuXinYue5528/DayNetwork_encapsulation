package com.example.mvp_library.base;

import com.example.mvp_library.presonter.BasePresonter;
import com.example.mvp_library.view.BaseView;

public abstract class BaseMvpActivity<V extends BaseView,P extends BasePresonter<V>>extends BaseActivity{

    public P mPersonter;

    @Override
    protected void initEvent() {
        mPersonter=initPresonter();
        if (mPersonter!=null){
            mPersonter.attachView((V) this);
        }
    }

    protected abstract P initPresonter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPersonter!=null){
            mPersonter.destoryView();
            mPersonter=null;
        }
    }
}
