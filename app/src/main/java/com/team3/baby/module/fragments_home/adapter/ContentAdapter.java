package com.team3.baby.module.fragments_home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team3.baby.R;

import java.util.List;

/**
 * 类用途:
 * 作者:崔涵淞
 * 时间: 2017/5/19 16:45.
 */

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<String> mDataList;

    public ContentAdapter(Context context, List<String> dataList) {
        this.mDataList = dataList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void notifyDataSetChanged(List<String> dataList) {
        this.mDataList = dataList;
        super.notifyDataSetChanged();
    }

    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.item_main_content, parent, false));
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        holder.setData(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTvTitle;

        public ContentViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }

        public void setData(String data) {
            mTvTitle.setText(data);
        }

        @Override
        public void onClick(View v) {
        }
    }

}
