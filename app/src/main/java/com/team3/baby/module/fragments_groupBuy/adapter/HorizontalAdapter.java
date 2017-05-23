package com.team3.baby.module.fragments_groupBuy.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

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

    public HorizontalAdapter(Context context, List<BoutiqueBean.Enrolls1Bean.ListBeanX> beanXes) {
        this.context = context;
        this.beanXes = beanXes;
    }
    //视图1
    public class ViewHolderss extends RecyclerView.ViewHolder {

        public ViewHolderss(View root) {
            super(root);
         /*   one_te = (TextView) root.findViewById(R.id.one_te);
            one_imager = (ImageView) root.findViewById(R.id.one_imager);*/
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return beanXes.size();
    }
}
