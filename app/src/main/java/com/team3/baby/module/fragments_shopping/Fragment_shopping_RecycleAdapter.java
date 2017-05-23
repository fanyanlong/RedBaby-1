package com.team3.baby.module.fragments_shopping;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team3.baby.R;
import com.team3.baby.module.fragments_shopping.shopping_bean.Shopping_Bean;

import java.util.ArrayList;

/**
 * data:2017/5/19
 * author:郭彦君(Administrator)
 * function:哎
 */
public class Fragment_shopping_RecycleAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Shopping_Bean.GoodsBean> mDataList;
    private RecyclerView fragmentShoppingRecyclerView;


    public Fragment_shopping_RecycleAdapter(Context context, ArrayList<Shopping_Bean.GoodsBean> mDataList, RecyclerView fragmentShoppingRecyclerView) {
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

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.textView.setText(mDataList.get(position).getAuxdescription());
        viewHolder.price_text.setText(mDataList.get(position).getPrice());
        viewHolder.tv_manypeoplebuy.setText(mDataList.get(position).getExtenalFileds().getCommentShow());
        Glide
                .with(context)
                .load("http://image2.suning.cn/uimg/cms/img/149087236896225414.png")
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private final ImageView imageView;
        private final TextView price_text;
        private final TextView tv_manypeoplebuy;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.info_text);
            imageView = (ImageView) itemView.findViewById(R.id.img_shopping);
            price_text = (TextView) itemView.findViewById(R.id.price_text);
            tv_manypeoplebuy = (TextView) itemView.findViewById(R.id.tv_manypeoplebuy);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ShoppingCarActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

}
