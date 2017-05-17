package com.team3.baby.module.fragments_classify.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.module.fragments_classify.bean.RightClassifyBean;

import java.util.List;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/17  16:53
 */

public class RightRvAdapter extends RecyclerView.Adapter<RightRvAdapter.ViewHolder> {
    private List<RightClassifyBean> mList;
    private Context mContext;

    public RightRvAdapter(List<RightClassifyBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item_right_classify);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_item_right_classify);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_right_classify, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RightClassifyBean rightClassifyBean = mList.get(position);
        holder.mImageView.setImageResource(R.mipmap.ic_launcher);
        holder.mTextView.setText(rightClassifyBean.getText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
