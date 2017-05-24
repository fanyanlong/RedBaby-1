package com.team3.baby.module.fragments_myebuy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
    private ArrayList<String> images;
    private RecyclerView recyclerCailoveMyebuy;
    private String url2;


    public Fragment_myebuy_RecycleAdapter(Context context, ArrayList<SkusBean> mDataList, ArrayList<String> images, RecyclerView recyclerCailoveMyebuy) {
        this.context = context;
        this.mDataList = mDataList;
        this.images = images;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.recyclerCailoveMyebuy = recyclerCailoveMyebuy;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_fragment_myebuy, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        mDataList.get(position);

        final ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.price.setText(mDataList.get(position).getPrice());
        viewHolder.name.setText(mDataList.get(position).getSugGoodsName());
        String SugGoodsCode = mDataList.get(position).getSugGoodsCode();
        String VendorId = mDataList.get(position).getVendorId();
        url2 = "http://image3.suning.cn/uimg/b2c/newcatentries/0000000000-" + mDataList.get(position).getSugGoodsCode() + "_1_400x400.jpg?ver=2015&from=mobile";
        Log.d("dds", "" + url2);
        Glide.with(context).load(url2).into(viewHolder.goodsimage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getTag();
                //String text = mDataList.get(RecyclerViewUtils.getAdapterPosition(fragmentShoppingRecyclerView, Fragment_myebuy_RecycleAdapter.ViewHolder.this));
                // Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ShoppingCarActivity.class);

                Toast.makeText(context, " v.getTag();" + position, Toast.LENGTH_SHORT).show();

                intent.putExtra("position", url2);
                intent.putExtra("shopName", mDataList.get(position).getSugGoodsName());
                intent.putExtra("shopPrice", mDataList.get(position).getPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView price;
        private ImageView goodsimage;
        private String goodid;
        private String goodscode;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_item_goodsname_myebuy);
            price = (TextView) itemView.findViewById(R.id.tv_goodsprice_ebuy);
            goodsimage = (ImageView) itemView.findViewById(R.id.iv_item_goodsimage_myebuy);


        }
    }

}
