package com.team3.baby.module.fragments_classify.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.module.fragments_classify.bean.GoodsListBean;
import com.team3.baby.module.fragments_shopping.shoppingutils.Shop_Utils;
import com.team3.baby.utils.ImageUtils;

import java.util.List;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/23  21:56
 */

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.ViewHolder> {
    private List<GoodsListBean.GoodsBean> mList;
    private Context mContext;

    public GoodsListAdapter(List<GoodsListBean.GoodsBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_goodslist_classify, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GoodsListBean.GoodsBean goodsBean = mList.get(position);
        ImageUtils.loadImageNormal(mContext, Shop_Utils.getPicUrl().get(position), holder.iv_item_goodslist);
        holder.tv_salesName_item_goodslist.setText(goodsBean.getSalesName());
        holder.tv_countOfarticle_item_goodslist.setText(goodsBean.getCountOfarticle());
        holder.tv_describe_item_goodslist.setText(goodsBean.getCatentdesc());
        holder.tv_praiseRate_item_goodslist.setText(goodsBean.getPraiseRate());
        holder.tv_price_item_goodslist.setText(goodsBean.getPrice());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_item_goodslist;
        private TextView tv_describe_item_goodslist;
        private TextView tv_price_item_goodslist;
        private TextView tv_countOfarticle_item_goodslist;
        private TextView tv_praiseRate_item_goodslist;
        private TextView tv_salesName_item_goodslist;
        private ImageView iv_car_item_goodslist;

        public ViewHolder(View itemView) {
            super(itemView);
            this.iv_item_goodslist = (ImageView) itemView.findViewById(R.id.iv_item_goodslist);
            this.tv_describe_item_goodslist = (TextView) itemView.findViewById(R.id.tv_describe_item_goodslist);
            this.tv_price_item_goodslist = (TextView) itemView.findViewById(R.id.tv_price_item_goodslist);
            this.tv_countOfarticle_item_goodslist = (TextView) itemView.findViewById(R.id.tv_countOfarticle_item_goodslist);
            this.tv_praiseRate_item_goodslist = (TextView) itemView.findViewById(R.id.tv_praiseRate_item_goodslist);
            this.tv_salesName_item_goodslist = (TextView) itemView.findViewById(R.id.tv_salesName_item_goodslist);
            this.iv_car_item_goodslist = (ImageView) itemView.findViewById(R.id.iv_car_item_goodslist);
        }
    }

}
