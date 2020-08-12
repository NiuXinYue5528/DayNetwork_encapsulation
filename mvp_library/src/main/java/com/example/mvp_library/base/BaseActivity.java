package com.example.mvp_library.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public  abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutId());
        bind = ButterKnife.bind(this);
        initEvent();
        initData();
    }

    protected abstract void initData();

    protected abstract void initEvent();

    protected abstract View initLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind!=null){
            bind.unbind();
        }
    }
}
