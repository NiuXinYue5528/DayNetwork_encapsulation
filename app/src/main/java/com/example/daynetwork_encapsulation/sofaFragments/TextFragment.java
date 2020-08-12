package com.example.daynetwork_encapsulation.sofaFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daynetwork_encapsulation.R;
import com.example.daynetwork_encapsulation.adapter.TextAdapter;
import com.example.daynetwork_encapsulation.sofabean.SofaBean;
import com.example.daynetwork_encapsulation.sofabean.SofaPresonter;
import com.example.daynetwork_encapsulation.sofabean.SofaView;
import com.example.daynetwork_encapsulation.sofabean.TextBean;
import com.example.daynetwork_encapsulation.sofabean.VideoBean;
import com.example.mvp_library.base.BaseMvpFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends BaseMvpFragment<SofaView, SofaPresonter> implements SofaView {


    private View inflate;
    private RecyclerView rv;
    private ArrayList<TextBean.DataBean> list;
    private TextAdapter textAdapter;

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_text, container, false);
        return inflate;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_text;
    }

    @Override
    public void onSuccess(SofaBean data) {

    }

    @Override
    public void onFail(String error) {

    }

    @Override
    public void onVideo(VideoBean bean) {

    }


    @Override
    protected void initView() {
        rv=inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        textAdapter = new TextAdapter(getContext(), list);
        rv.setAdapter(textAdapter);
    }

    @Override
    protected void initEventData() {
        mPresonter.setTextData();
    }

    @Override
    protected SofaPresonter initPresonter() {
        return new SofaPresonter();
    }

    @Override
    public void onSuccess(String mag, int code) {

    }


    @Override
    public void onText(TextBean bean) {
        list.addAll(bean.getData());
        textAdapter.notifyDataSetChanged();
    }
    @Override
    public void onCancle() {

    }
}
