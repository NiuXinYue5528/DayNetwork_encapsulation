package com.example.daynetwork_encapsulation.sofaFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daynetwork_encapsulation.R;
import com.example.daynetwork_encapsulation.adapter.RvAdapter;
import com.example.daynetwork_encapsulation.adapter.VideoAdapter;
import com.example.daynetwork_encapsulation.bean.HomeBen;
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
public class VideoFragment extends BaseMvpFragment<SofaView, SofaPresonter> implements SofaView {

    private RecyclerView rv;
    private View inflate;
    private ArrayList<VideoBean.DataBean> list;
    private VideoAdapter videoAdapter;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_video, container, false);
        return inflate;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    public void onSuccess(SofaBean data) {

    }

    @Override
    public void onFail(String error) {

    }



    @Override
    protected void initView() {
        rv=inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();

        videoAdapter = new VideoAdapter(getContext(), list);
        rv.setAdapter(videoAdapter);
    }

    @Override
    protected void initEventData() {
        mPresonter.videoDatas();
    }

    @Override
    protected SofaPresonter initPresonter() {
        return new SofaPresonter();
    }

    @Override
    public void onSuccess(String mag, int code) {

    }
    @Override
    public void onVideo(VideoBean bean) {
        list.addAll(bean.getData());
        videoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onText(TextBean bean) {

    }

    @Override
    public void onCancle() {

    }
}
