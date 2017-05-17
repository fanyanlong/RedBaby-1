package com.team3.baby.module.fragments_classify.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team3.baby.R;

import java.util.List;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/17  16:53
 */

public class LeftRvAdapter extends RecyclerView.Adapter<LeftRvAdapter.ViewHolder> {
    private List<String> mList;
    private Context mContext;

    public LeftRvAdapter(List<String> list, Context context) {
        mList = list;
        mContext = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item_left_classify);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_left_classify, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = mList.get(position);
        holder.mTextView.setText(s);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
