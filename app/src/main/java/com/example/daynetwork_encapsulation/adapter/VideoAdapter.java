package com.example.daynetwork_encapsulation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.daynetwork_encapsulation.R;
import com.example.daynetwork_encapsulation.sofabean.VideoBean;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;

import cn.jzvd.JzvdStd;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private Context context;
    private ArrayList<VideoBean.DataBean> list;

    public VideoAdapter(Context context, ArrayList<VideoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv_video, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoBean.DataBean datas = list.get(position);
        Glide.with(context).load(datas.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder.iv_img);
        holder.tv_name.setText(datas.getAuthor().getName());
        holder.tv_ce.setText(datas.getFeeds_text());
        holder.video.setUp(list.get(position).getUrl(), "");
        Glide.with(context).load(datas.getCover())
                .apply(new RequestOptions().centerCrop())
                .into(holder.video.thumbImageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_img;
        public TextView tv_name;
        public TextView tv_ce;
        public JzvdStd video;
        public ImageView iv_zan;
        public TextView tv_zan;
        public ImageView iv_cai;
        public TextView tv_cai;
        public ImageView iv_message;
        public TextView tv_message;
        public ImageView iv_fa;
        public TextView tv_fa;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_ce = (TextView) rootView.findViewById(R.id.tv_ce);
            this.video = (JzvdStd) rootView.findViewById(R.id.video);
            this.iv_zan = (ImageView) rootView.findViewById(R.id.iv_zan);
            this.tv_zan = (TextView) rootView.findViewById(R.id.tv_zan);
            this.iv_cai = (ImageView) rootView.findViewById(R.id.iv_cai);
            this.tv_cai = (TextView) rootView.findViewById(R.id.tv_cai);
            this.iv_message = (ImageView) rootView.findViewById(R.id.iv_message);
            this.tv_message = (TextView) rootView.findViewById(R.id.tv_message);
            this.iv_fa = (ImageView) rootView.findViewById(R.id.iv_fa);
            this.tv_fa = (TextView) rootView.findViewById(R.id.tv_fa);
        }
    }
}
