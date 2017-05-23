package com.team3.baby.module.fragments_classify.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team3.baby.R;
import com.team3.baby.module.fragments_classify.bean.RightClassifyBean;

import java.util.List;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/17  16:53
 */

public class RightRvAdapter extends RecyclerView.Adapter {
    private List<RightClassifyBean> mList;
    private Context mContext;

    public RightRvAdapter(List<RightClassifyBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    static class ViewHolder_Item extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        public ViewHolder_Item(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item_right_classify);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_item_right_classify);
        }
    }

    static class ViewHolder_Title extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ViewHolder_Title(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item_left_classify);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view_00 = View.inflate(mContext, R.layout.item_left_classify, null);
                ViewHolder_Title holder_00 = new ViewHolder_Title(view_00);
                return holder_00;
            case 1:
                View view_01 = View.inflate(mContext, R.layout.item_right_classify, null);
                ViewHolder_Item holder_01 = new ViewHolder_Item(view_01);
                return holder_01;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RightClassifyBean bean = mList.get(position);
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                ViewHolder_Title holder_title = (ViewHolder_Title) holder;
                holder_title.mTextView.setText(bean.getText());
                break;
            case 1:
                ViewHolder_Item holder_item = (ViewHolder_Item) holder;
                Glide.with(mContext).load(bean.getImage()).into(holder_item.mImageView);
                holder_item.mTextView.setText(bean.getText());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (null == mList.get(position).getImage()) {
            return 0;
        } else {
            return 1;
        }
    }
}
