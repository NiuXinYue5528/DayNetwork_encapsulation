package com.example.mvp_library.base;

import com.example.mvp_library.presonter.BasePresonter;
import com.example.mvp_library.view.BaseView;

public abstract   class BaseMvpFragment<V extends BaseView,P extends BasePresonter<V>> extends BaseFragment {

    public  P mPresonter;

    @Override
    protected void initData() {
        mPresonter=initPresonter();
        if (mPresonter!=null){
            mPresonter.attachView((V) this);
            initView();
            initEventData();
        }
    }

    protected abstract void initView();

    protected abstract void initEventData();

    protected abstract P initPresonter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresonter!=null){
            mPresonter.destoryView();
            mPresonter=null;
        }
    }
}
