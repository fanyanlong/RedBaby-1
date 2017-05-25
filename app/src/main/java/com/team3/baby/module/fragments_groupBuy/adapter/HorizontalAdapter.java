package com.team3.baby.module.fragments_groupBuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.team3.baby.R;
import com.team3.baby.module.fragments_groupBuy.bean.BoutiqueBean;

import java.util.List;

/**
 * 类用途：
 * 作者：ShiZhuangZhuang
 * 时间：2017/5/23 20:20
 */

public class HorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<BoutiqueBean.Enrolls1Bean.ListBeanX> beanXes;
    private String http = "http:";

    public HorizontalAdapter(Context context, List<BoutiqueBean.Enrolls1Bean.ListBeanX> beanXes) {
        this.context = context;
        this.beanXes = beanXes;
    }

    //视图
    public class ViewHolderss extends RecyclerView.ViewHolder {
        private ImageView roundeimager_horizontala;
        private TextView text_title_horizontala, text_content_horizontala, text_price_horizontala;

        public ViewHolderss(View root) {
            super(root);
            roundeimager_horizontala = (ImageView) root.findViewById(R.id
                    .roundeimager_horizontala);
            text_title_horizontala = (TextView) root.findViewById(R.id.text_title_horizontala);
            text_content_horizontala = (TextView) root.findViewById(R.id.text_content_horizontala);
            text_price_horizontala = (TextView) root.findViewById(R.id.text_price_horizontala);

        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .horizontaladapter_itme, parent, false);
        return new ViewHolderss(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolderss holderss = (ViewHolderss) holder;
        Glide.with(context).load(http + beanXes.get(position).getImgUrl()).placeholder(R.mipmap
                .home_store_card_header_icon).skipMemoryCache(true).into(holderss
                .roundeimager_horizontala);
        holderss.text_title_horizontala.setText(beanXes.get(position).getItemName());
        holderss.text_content_horizontala.setText(beanXes.get(position).getItemDesc());
        holderss.text_price_horizontala.setText("￥" + beanXes.get(position).getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return beanXes.size();
    }
    
}
