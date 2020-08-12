package com.example.daynetwork_encapsulation.fragments;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daynetwork_encapsulation.CategoryConstacts.HomeConstacts;
import com.example.daynetwork_encapsulation.CategoryConstacts.ImpHomePresontin;
import com.example.daynetwork_encapsulation.R;
import com.example.daynetwork_encapsulation.adapter.RvAdapter;
import com.example.daynetwork_encapsulation.bean.HomeBen;
import com.example.mvp_library.base.BaseMvpFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment<HomeConstacts.HomeView, ImpHomePresontin> implements HomeConstacts.HomeView {


    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private RvAdapter rvAdapter;
    private ArrayList<HomeBen.DataBean> list;

    public HomeFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
//        unbinder = ButterKnife.bind(this, inflate);

//        return inflate;
//    }

//    private void initView() {
//        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
//        list = new ArrayList<>();
//        rvAdapter = new RvAdapter(getActivity(), list);
//        rv.setAdapter(rvAdapter);
//    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        rvAdapter = new RvAdapter(getActivity(), list);
        rv.setAdapter(rvAdapter);
    }

    @Override
    protected void initEventData() {
        mPresonter.getData();
    }

    @Override
    protected ImpHomePresontin initPresonter() {
        return new ImpHomePresontin();
    }

    @Override
    public void onSuccess(String mag, int code) {

    }

    @Override
    public void showHomeList(HomeBen ben) {
        list.addAll(ben.getData());
        rvAdapter.notifyDataSetChanged();
    }


    @Override
    public void onCancle() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


//
//    private void initData() {
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("pageCount","12");
//        map.put("feedId","0");
//        map.put("userId","0");
//        map.put("feedType","all");
//        new HttpClient.Bulider()
//                .setBaseUrl("http://123.56.232.18:8080/serverdemo/feeds/")
//                .setApiUrl("queryHotFeedsList")
//                .get()
//                .setHeaders(map)
//                .build()
//                .request(new HomeCallaBack<HomeBen>() {
//                    @Override
//                    protected void onError(String msg, int code) {
//                        onError(msg,code);
//                    }
//
//                    @Override
//                    protected void cancle() {
//                    }
//
//                    @Override
//                    protected void onSuccess(HomeBen parse) {
//                        LogUtils.e(parse.toString());
//                        Log.i("111", "onSuccess: "+parse.toString());
//                    }
//
//                    @Override
//                    public HomeBen convert(JsonElement result) {
//                        return JsonUtils.jsonToClass(result, HomeBen.class);
//                    }
//                });
//   }


}
