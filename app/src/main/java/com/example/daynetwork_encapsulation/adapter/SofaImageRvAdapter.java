package com.example.daynetwork_encapsulation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.daynetwork_encapsulation.R;
import com.example.daynetwork_encapsulation.sofabean.SofaBean;

import java.util.ArrayList;

public class SofaImageRvAdapter extends RecyclerView.Adapter<SofaImageRvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<SofaBean.DataBean> list;

    public SofaImageRvAdapter(Context context, ArrayList<SofaBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv_sofa, parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SofaBean.DataBean datas = list.get(position);
        Glide.with(context).load(datas.getCover()).into(holder.iv_img1);
        Glide.with(context).load(datas.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder.iv_img);
        holder.tv_name.setText(datas.getAuthor().getName());

        if (datas.getFeeds_text()==null){
            holder.tv_feeds.setVisibility(View.GONE);
        }else {
            holder.tv_feeds.setText(datas.getFeeds_text()+"");
        }
        if (datas.getActivityText()==null){
            holder.cd.setVisibility(View.GONE);
            holder.iv_img1.setVisibility(View.GONE);
            holder.tv_du.setVisibility(View.GONE);
        }else {
            holder.tv_du.setText(datas.getActivityText()+"");
        }
        holder.tv_zan.setText("赞");
        holder.tv_cai.setText("踩");
        holder.tv_message.setText("评论");
        holder.tv_fa.setText("分享");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_img;
        public TextView tv_du;
        public TextView tv_name;
        public ImageView iv_img1;
        public TextView tv_zan;
        public TextView tv_cai;
        public TextView tv_message;
        public TextView tv_fa;
        public TextView tv_feeds;
        public CardView cd;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.tv_du = (TextView) rootView.findViewById(R.id.tv_du);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.iv_img1 = (ImageView) rootView.findViewById(R.id.iv_img1);
            this.tv_zan = (TextView) rootView.findViewById(R.id.tv_zan);
            this.tv_cai = (TextView) rootView.findViewById(R.id.tv_cai);
            this.tv_message = (TextView) rootView.findViewById(R.id.tv_message);
            this.tv_fa = (TextView) rootView.findViewById(R.id.tv_fa);
            this.tv_feeds = (TextView) rootView.findViewById(R.id.tv_feeds);
            this.cd = (CardView) rootView.findViewById(R.id.cd);
        }
    }
}
