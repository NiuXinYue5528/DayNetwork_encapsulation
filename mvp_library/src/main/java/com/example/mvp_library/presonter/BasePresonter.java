package com.example.mvp_library.presonter;

import com.example.mvp_library.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.WeakReference;

public class BasePresonter<V extends BaseView> {
    public V mView;
    private WeakReference<V> weakReference;
    public void attachView(V view){
        weakReference=new WeakReference<V>(view);
        mView=weakReference.get();
    }
    //返回视图对象
    public LifecycleProvider getLifecycle(){
        return (LifecycleProvider) mView;
    }
    //解绑
    public void destoryView(){
        if (weakReference!=null){
            weakReference.clear();//清空
        }
    }
}
