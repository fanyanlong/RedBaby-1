package com.team3.baby.module.fragments_shopping.shop_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.module.fragments_shopping.shopping_bean.ShopCarBean;
import com.team3.baby.utils.ImageUtils;

import java.util.ArrayList;

/**
 * data:2017/5/24
 * author:郭彦君(Administrator)
 * function:
 */
public class HeadBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ShopCarBean> list;

    public HeadBaseAdapter(Context context, ArrayList<ShopCarBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.head_list_item, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_add_picture_item);
            holder.textView_name = (TextView) convertView.findViewById(R.id.tv_add_shoppingName_item);
            holder.textView_price = (TextView) convertView.findViewById(R.id.tv_add_shoppingPrice_item);
            holder.textView_unmber = (TextView) convertView.findViewById(R.id.tv_add_shoppingNumber_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageUtils.loadImageNormal(context, list.get(position).getPicUrl(), holder.imageView);
        holder.textView_name.setText(list.get(position).getName());
        holder.textView_price.setText(list.get(position).getPrice() + "");
        holder.textView_unmber.setText(list.get(position).getNumber() + "");
        return convertView;


    }

    class ViewHolder {
        ImageView imageView;
        TextView textView_price;
        TextView textView_unmber;
        TextView textView_name;


    }

}
