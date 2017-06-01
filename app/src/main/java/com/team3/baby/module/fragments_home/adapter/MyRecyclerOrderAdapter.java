package com.team3.baby.module.fragments_home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team3.baby.R;
import com.team3.baby.module.fragments_home.bean.OrderBean;
import com.team3.baby.module.fragments_home.url.Url;

import java.util.ArrayList;

/**
 * 类用途:
 * 作者:崔涵淞
 * 时间: 2017/5/31 19:28.
 */

public class MyRecyclerOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //点击位置
    private int layoutPosition;
    //点击
    private OnItemClickListener mOnItemClickListener;
    //点击
    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
    //点击监听接口
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private ArrayList<OrderBean> list;
    private Context mContext;
    public MyRecyclerOrderAdapter(Context mContext, ArrayList<OrderBean> listOrder) {
        this.list = listOrder;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_order, parent, false);
      RecyclerView.ViewHolder holder = new ViewHolder1(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 holderOrder = (ViewHolder1) holder;
        Glide.with(mContext).load(Url.IMAGE_01+list.get(position).getImagePath()+Url.IMAGE_02)
                .placeholder(R.mipmap.ahahah)
                .into(holderOrder.item_home_order_image);
        holderOrder.item_home_order_name.setText(list.get(position).getName());
        holderOrder.item_home_order_price.setText("¥"+list.get(position).getPrice());
        if (mOnItemClickListener != null) {
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutPosition = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView, layoutPosition); // 2

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView item_home_order_image;
        TextView item_home_order_name;
        TextView item_home_order_price;

        public ViewHolder1(View itemView) {
            super(itemView);
            item_home_order_image = (ImageView) itemView.findViewById(R.id.item_home_order_image);
            item_home_order_name = (TextView) itemView.findViewById(R.id.item_home_order_name);
            item_home_order_price = (TextView) itemView.findViewById(R.id.item_home_order_price);
        }
    }
}
