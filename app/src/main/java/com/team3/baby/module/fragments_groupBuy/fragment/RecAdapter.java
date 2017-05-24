package com.team3.baby.module.fragments_groupBuy.fragment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
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
 * 时间：2017/5/21 19:01
 */

public class RecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<BoutiqueBean.EnrollsBean.ListBean> enrollsList;
    private String http = "http:";

    public RecAdapter(Context context, List<BoutiqueBean.EnrollsBean.ListBean> enrollsList) {
        this.context = context;
        this.enrollsList = enrollsList;
    }

    //视图1
    public class ViewHolders extends RecyclerView.ViewHolder {
        private ImageView imager_tabfragment;
        private TextView text_title_tabfragment, text_content_tabfragment, text_price_tabfragment;

        public ViewHolders(View root) {
            super(root);
            imager_tabfragment = (ImageView) root.findViewById(R.id.imager_tabfragment);
            text_title_tabfragment = (TextView) root.findViewById(R.id.text_title_tabfragment);
            text_content_tabfragment = (TextView) root.findViewById(R.id.text_content_tabfragment);
            text_price_tabfragment = (TextView) root.findViewById(R.id.text_price_tabfragment);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .tacfragment_itme, parent, false);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolders holders = (ViewHolders) holder;
        Glide.with(context).load(http + enrollsList.get(position).getImgUrl()).placeholder(R.mipmap
                .home_store_card_header_icon).skipMemoryCache(true).into(holders
                .imager_tabfragment);
        holders.text_title_tabfragment.setText(enrollsList.get(position).getItemName());
        holders.text_content_tabfragment.setText(enrollsList.get(position).getItemDesc());
        holders.text_price_tabfragment.setText(enrollsList.get(position).getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return enrollsList.size();
    }
}
