package com.team3.baby.module.fragments_classify.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.module.fragments_classify.bean.LeftClassifyBean;

import java.util.List;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/17  16:53
 */

public class LeftRvAdapter extends RecyclerView.Adapter<LeftRvAdapter.ViewHolder> {
    private List<LeftClassifyBean> mList;
    private Context mContext;
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

    //长按
    private OnItemLongClickListener mOnItemLongClickListener;
    //长按
    public void setmOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }
    //长按监听接口
    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    public LeftRvAdapter(List<LeftClassifyBean> list, Context context) {
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final LeftClassifyBean leftClassifyBean = mList.get(position);
        holder.mTextView.setText(leftClassifyBean.getText());
        //判断是否设置了监听器
        //单击判断
        if (mOnItemClickListener != null) {
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutPosition = holder.getLayoutPosition(); // 1

                    mOnItemClickListener.onItemClick(holder.itemView, layoutPosition); // 2
                    notifyDataSetChanged();
                }
            });
        }
        //更改状态
        if (position == layoutPosition) {
            holder.mTextView.setBackgroundColor(Color.parseColor("#FAFAFA"));
            holder.mTextView.setTextColor(Color.parseColor("#f4a460"));
        } else {
            holder.mTextView.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            holder.mTextView.setTextColor(Color.parseColor("#2f4f4f"));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
