package com.team3.baby.module.fragments_groupBuy.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team3.baby.R;
import com.team3.baby.module.fragments_groupBuy.bean.TabBean;

import java.util.List;

/**
 * 类用途：
 * 作者：ShiZhuangZhuang
 * 时间：2017/5/21 19:01
 */

public class TabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String http = "http:";
    private Context context;
    private List<TabBean.EnrollsBean.ListBean> listBeen;

    public TabAdapter(Context context, List<TabBean.EnrollsBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    //视图
    public class ViewHolders extends RecyclerView.ViewHolder {
        private ImageView imager_tabfragments;
        private TextView text_title_tabfragments, text_content_tabfragments,
                text_price_tabfragments,texts_price_tabfragments;

        public ViewHolders(View root) {
            super(root);
            imager_tabfragments = (ImageView) root.findViewById(R.id.imager_tabfragments);
            text_title_tabfragments = (TextView) root.findViewById(R.id.text_title_tabfragments);
            text_content_tabfragments = (TextView) root.findViewById(R.id
                    .text_content_tabfragments);
            text_price_tabfragments = (TextView) root.findViewById(R.id.text_price_tabfragments);
            texts_price_tabfragments = (TextView) root.findViewById(R.id.texts_price_tabfragment);
            texts_price_tabfragments.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .tabfragments_itme, parent, false);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolders holders = (ViewHolders) holder;
        Glide.with(context).load(http + listBeen.get(position).getImgUrl()).placeholder(R.mipmap
                .home_store_card_header_icon).skipMemoryCache(true).into(holders
                .imager_tabfragments);
        holders.text_title_tabfragments.setText(listBeen.get(position).getItemName());
        holders.text_content_tabfragments.setText(listBeen.get(position).getItemDesc());
        holders.text_price_tabfragments.setText("￥" + listBeen.get(position).getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }
}
