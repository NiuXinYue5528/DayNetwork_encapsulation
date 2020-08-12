package com.example.daynetwork_encapsulation.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.daynetwork_encapsulation.R;
import com.example.daynetwork_encapsulation.adapter.VpAdapter;
import com.example.daynetwork_encapsulation.sofaFragments.ImagesFragment;
import com.example.daynetwork_encapsulation.sofaFragments.TextFragment;
import com.example.daynetwork_encapsulation.sofaFragments.VideoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SofaFragment extends Fragment {


    private ViewPager vp;
    private TabLayout tab;

    public SofaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_sofa, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        tab=inflate.findViewById(R.id.tab);
        vp=inflate.findViewById(R.id.vp);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new ImagesFragment());
        list.add(new VideoFragment());
        list.add(new TextFragment());
        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager(), list);
        vp.setAdapter(vpAdapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("图片");
        tab.getTabAt(1).setText("视频");
        tab.getTabAt(2).setText("文本");
    }

}
