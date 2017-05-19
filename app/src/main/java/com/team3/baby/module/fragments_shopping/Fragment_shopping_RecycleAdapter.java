package com.team3.baby.module.fragments_shopping;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cundong.recyclerview.RecyclerViewUtils;
import com.team3.baby.R;

import java.util.ArrayList;

/**
 * data:2017/5/19
 * author:郭彦君(Administrator)
 * function:哎
 */
public class Fragment_shopping_RecycleAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mDataList;
    private RecyclerView fragmentShoppingRecyclerView;


    public Fragment_shopping_RecycleAdapter(Context context, ArrayList<String> mDataList, RecyclerView fragmentShoppingRecyclerView) {
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

        String item = mDataList.get(position);

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.textView.setText(item);
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
                    String text = mDataList.get(RecyclerViewUtils.getAdapterPosition(fragmentShoppingRecyclerView, ViewHolder.this));
                    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,ShoppingCarActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

}
