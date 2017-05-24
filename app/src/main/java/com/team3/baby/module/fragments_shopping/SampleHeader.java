package com.team3.baby.module.fragments_shopping;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.team3.baby.R;
import com.team3.baby.module.main_activity.v.MainActivity;

/**
 * Created by cundong on 2015/10/9.
 * <p/>
 * RecyclerView的HeaderView，简单的展示一个TextView
 */
public class SampleHeader extends RelativeLayout {

    private View view;

    public SampleHeader(Context context) {
        super(context);
        init(context);
    }

    public SampleHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SampleHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {

        view = View.inflate(context, R.layout.fragment_shopping_hearder_layout, this);

    }

    public void setOnLinsener(final Context context) {
        view.findViewById(R.id.btn_goto_gg).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "去逛逛", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
                context.fileList();
            }
        });

    }

    public void AddListView(Application application,Context context) {
     /*   ListView listView = (ListView) view.findViewById(R.id.fragment_shopping_listview);
        table_shoppingDao tableShoppingDao = ((App) application.getApplicationContext()).getDaoSession().getTable_shoppingDao();
        QueryBuilder<table_shopping> queryBuilder = tableShoppingDao.queryBuilder();
        List<table_shopping> list = queryBuilder.list();
        ArrayList<ShopCarBean> arrayList  = new ArrayList<>();
        for (int i = 0 ;i<list.size();i++){
            ShopCarBean shopCarBean = new ShopCarBean();
            shopCarBean.setName(list.get(i).getShopping_name());
            shopCarBean.setNumber(list.get(i).getShopping_count());
            shopCarBean.setPicUrl(list.get(i).getShopping_pic());
            shopCarBean.setPrice(list.get(i).getShopping_price());
            arrayList.add(shopCarBean);
        }
        HeadBaseAdapter adapter = new HeadBaseAdapter(context,arrayList);
        listView.setAdapter(adapter);*/

    }


}