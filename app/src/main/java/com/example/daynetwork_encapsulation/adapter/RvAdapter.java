package com.example.daynetwork_encapsulation.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.daynetwork_encapsulation.R;
import com.example.daynetwork_encapsulation.bean.HomeBen;

import java.util.ArrayList;

import cn.jzvd.JzvdStd;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeBen.DataBean> list;


    public RvAdapter(Context context, ArrayList<HomeBen.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeBen.DataBean datas = list.get(position);
        Glide.with(context).load(datas.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder.iv_img);
        holder.tv_name.setText(datas.getAuthor().getName());
        holder.tv_foods.setText(datas.getFeeds_text());
        holder.tv_text.setText(datas.getActivityText());
//        holder.video.setVideoURI(Uri.parse(datas.getUrl()));
//        holder.video.start();
//        holder.video.setMediaController(new MediaController(context));


        holder.tv_fa.setText(datas.getUgc().getShareCount() + "");
        holder.tv8840.setText(datas.getUgc().getCommentCount() + "");
        holder.tv_message.setText(datas.getUgc().getLikeCount() + "");
//        holder.video.setUp(list.get(position).getUrl(),"");
////        holder.video.startVideo();

        holder.video.setUp(list.get(position).getUrl(),"");
        Glide.with(context).load(list.get(position).getCover())
                //切满
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
        public TextView tv_text;
        public TextView tv_foods;
       // public VideoView video;
        public TextView tv_fa;
        public TextView tv_message;
        public TextView tv_cai;
        public TextView tv8840;
        public JzvdStd video;


        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.tv_foods = (TextView) rootView.findViewById(R.id.tv_foods);
           // this.video = (VideoView) rootView.findViewById(R.id.video);
            this.tv_fa = (TextView) rootView.findViewById(R.id.tv_fa);
            this.tv8840 = (TextView) rootView.findViewById(R.id.tv8840);
            this.tv_cai = (TextView) rootView.findViewById(R.id.tv_cai);
            this.tv_message = (TextView) rootView.findViewById(R.id.tv_message);
            this.video = (JzvdStd) rootView.findViewById(R.id.video);
        }
    }


}
