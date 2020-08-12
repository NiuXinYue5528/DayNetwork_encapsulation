package com.example.daynetwork_encapsulation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.daynetwork_encapsulation.R;
import com.example.daynetwork_encapsulation.sofabean.TextBean;

import java.util.ArrayList;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TextBean.DataBean> list;

    public TextAdapter(Context context, ArrayList<TextBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv_text, parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextBean.DataBean datas = list.get(position);
        Glide.with(context).load(datas.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder.iv_img);
        holder.tv_name.setText(datas.getAuthor().getName());
        if (datas.getActivityText()==null){
            holder.cd.setVisibility(View.GONE);
            holder.tv_jing_text.setVisibility(View.GONE);
        }else {
            holder.tv_jing_text.setText(datas.getActivityText()+"");
        }
        if (datas.getFeeds_text()==null){
            holder.tv_text.setVisibility(View.GONE);
        }else {
            holder.tv_text.setText(datas.getFeeds_text()+"");
        }

        holder.tv_zan.setText("赞");//datas.getUgc().getCommentCount()+""
        holder.tv_cai.setText("踩");
        holder.tv_fa.setText("分享");
        holder.tv_message.setText("评论");//datas.getUgc().getLikeCount()+""
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
        public ImageView iv_jing;
        public TextView tv_jing_text;
        public CardView cd;
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
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.iv_jing = (ImageView) rootView.findViewById(R.id.iv_jing);
            this.tv_jing_text = (TextView) rootView.findViewById(R.id.tv_jing_text);
            this.cd = (CardView) rootView.findViewById(R.id.cd);
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
