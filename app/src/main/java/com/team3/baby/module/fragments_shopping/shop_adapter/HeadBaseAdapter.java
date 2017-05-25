package com.team3.baby.module.fragments_shopping.shop_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.app.App;
import com.team3.baby.utils.ImageUtils;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import me.redbaby.greendao.Table_shopping;
import me.redbaby.greendao.Table_shoppingDao;

/**
 * data:2017/5/24
 * author:郭彦君(Administrator)
 * function:
 */
public class HeadBaseAdapter extends BaseAdapter {

    private Context context;
    private List<Table_shopping> list;
   // private int number;

    public HeadBaseAdapter(Context context, List<Table_shopping> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.head_list_item, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_add_picture_item);
            holder.textView_name = (TextView) convertView.findViewById(R.id.tv_add_shoppingName_item);
            holder.textView_price = (TextView) convertView.findViewById(R.id.tv_add_shoppingPrice_item);
            holder.textView_unmber = (TextView) convertView.findViewById(R.id.tv_add_shoppingNumber_item);
            holder.textView_subtract = (TextView) convertView.findViewById(R.id.tv_add_subtract_item);
            holder.textView_and = (TextView) convertView.findViewById(R.id.tv_add_and_item);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageUtils.loadImageNormal(context,list.get(position).getShopping_pic(), holder.imageView);
        holder.textView_name.setText(list.get(position).getShopping_name());
        holder.textView_price.setText(list.get(position).getShopping_price() + "");
        holder.textView_unmber.setText(list.get(position).getShopping_count() + "");



        final Table_shoppingDao tableShoppingDao = App.getApplication().getDaoSession().getTable_shoppingDao();
       // final ShopCarBean shopCarBean = list.get(position);
        QueryBuilder<Table_shopping> queryBuilder = tableShoppingDao.queryBuilder();
        final List<Table_shopping> alist = queryBuilder.list();


        holder.textView_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //shopCarBean.setNumber(number+1);
                //Table_shopping tableShopping = new Table_shopping();
                int count = list.get(position).getShopping_count();
                if (count>1) {
                    Table_shopping tableShopping = alist.get(position);



                    count = count - 1;
                    tableShopping.setShopping_count(count);
                    tableShoppingDao.update(tableShopping);
                    holder.textView_unmber.setText(count + "");
                }
            }
        });
        holder.textView_and.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Table_shopping tableShopping = alist.get(position);


                int count = list.get(position).getShopping_count();
                count = count+1;
                tableShopping.setShopping_count(count);
                tableShoppingDao.update(tableShopping);
                holder.textView_unmber.setText(count + "");

            }
        });

        return convertView;


    }

    class ViewHolder {
        ImageView imageView;
        TextView textView_price;
        TextView textView_unmber;
        TextView textView_name;

        TextView textView_subtract;
        TextView textView_and;


    }

}
