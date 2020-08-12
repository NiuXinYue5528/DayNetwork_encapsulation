package com.example.daynetwork_encapsulation.sofaFragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daynetwork_encapsulation.CategoryConstacts.HomeConstacts;
import com.example.daynetwork_encapsulation.CategoryConstacts.ImpHomePresontin;
import com.example.daynetwork_encapsulation.R;
import com.example.daynetwork_encapsulation.adapter.SofaImageRvAdapter;
import com.example.daynetwork_encapsulation.bean.HomeBen;
import com.example.daynetwork_encapsulation.sofabean.SofaBean;
import com.example.daynetwork_encapsulation.sofabean.SofaPresonter;
import com.example.daynetwork_encapsulation.sofabean.SofaView;
import com.example.daynetwork_encapsulation.sofabean.TextBean;
import com.example.daynetwork_encapsulation.sofabean.VideoBean;
import com.example.mvp_library.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagesFragment extends BaseMvpFragment<SofaView, SofaPresonter> implements SofaView{


    @BindView(R.id.rv)
    RecyclerView rv;
    private View inflate;
    private SofaImageRvAdapter sofaImageRvAdapter;
    private ArrayList<SofaBean.DataBean> list;

    public ImagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_images, container, false);
        return inflate;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_images;
    }


    @Override
    protected void initView() {
        rv=inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));

        list = new ArrayList<>();
        sofaImageRvAdapter = new SofaImageRvAdapter(getContext(), list);
        rv.setAdapter(sofaImageRvAdapter);
    }

    @Override
    protected void initEventData() {
        mPresonter.setData();
    }

    @Override
    protected SofaPresonter initPresonter() {
        return new SofaPresonter();
    }


    @Override
    public void onSuccess(String mag, int code) {

    }

    @Override
    public void onCancle() {

    }

    @Override
    public void onSuccess(SofaBean data) {
        list.addAll(data.getData());
        Log.i("111", "onSuccess: "+data.toString());
        sofaImageRvAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {

    }

    @Override
    public void onVideo(VideoBean bean) {

    }

    @Override
    public void onText(TextBean bean) {

    }
}
