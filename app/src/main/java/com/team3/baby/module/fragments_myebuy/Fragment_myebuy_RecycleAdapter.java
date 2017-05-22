package com.team3.baby.module.fragments_myebuy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.module.fragments_myebuy.bean_myebuy.SkusBean;
import com.team3.baby.module.fragments_shopping.ShoppingCarActivity;

import java.util.ArrayList;

/**
 * 贾建海
 * 适配器类，猜你喜欢recyclerView适配器
 */
public class Fragment_myebuy_RecycleAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater mLayoutInflater;
    private ArrayList<SkusBean> mDataList;
    private RecyclerView fragmentShoppingRecyclerView;


    public Fragment_myebuy_RecycleAdapter(Context context, ArrayList<SkusBean> mDataList, RecyclerView fragmentShoppingRecyclerView) {
        this.context = context;
        this.mDataList = mDataList;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.fragmentShoppingRecyclerView = fragmentShoppingRecyclerView;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.sample_item_card, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        mDataList.get(position);

        ViewHolder viewHolder = (ViewHolder) holder;
        //viewHolder.textView.setText(item);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.info_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //String text = mDataList.get(RecyclerViewUtils.getAdapterPosition(fragmentShoppingRecyclerView, Fragment_myebuy_RecycleAdapter.ViewHolder.this));
                    // Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

}
