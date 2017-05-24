package com.team3.baby.module.fragments_shopping;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.team3.baby.R;
import com.team3.baby.app.App;
import com.team3.baby.module.fragments_shopping.shop_adapter.HeadBaseAdapter;
import com.team3.baby.module.fragments_shopping.shopping_bean.ShopCarBean;
import com.team3.baby.module.main_activity.v.MainActivity;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import me.redbaby.greendao.Table_shopping;
import me.redbaby.greendao.Table_shoppingDao;

/**
 * Created by cundong on 2015/10/9.
 * <p/>
 * RecyclerView的HeaderView，简单的展示一个TextView
 */
public class SampleHeader extends RelativeLayout {

    private View view;
    private HeadBaseAdapter adapter;
    private LinearLayout lv_head_head;

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

    public void AddListView(Context context) {
        ListView listView = (ListView) view.findViewById(R.id.fragment_shopping_listview);
        lv_head_head = (LinearLayout) view.findViewById(R.id.lv_head_head);



        Table_shoppingDao tableShoppingDao = App.getApplication().getDaoSession().getTable_shoppingDao();
        QueryBuilder<Table_shopping> queryBuilder = tableShoppingDao.queryBuilder();
        List<Table_shopping> list = queryBuilder.list();
        ArrayList<ShopCarBean> arrayList  = new ArrayList<>();

        Logger.d(arrayList.size());
        if (list.size()!=0){
            for (int i = 0 ;i<list.size();i++){
                ShopCarBean shopCarBean = new ShopCarBean();
                shopCarBean.setName(list.get(i).getShopping_name());
                shopCarBean.setNumber(list.get(i).getShopping_count());
                shopCarBean.setPicUrl(list.get(i).getShopping_pic());
                shopCarBean.setPrice(list.get(i).getShopping_price());
                arrayList.add(shopCarBean);
            }
            lv_head_head.setVisibility(GONE);
            listView.setVisibility(VISIBLE);
            adapter = new HeadBaseAdapter(context,arrayList);
            listView.setAdapter(adapter);

        }else{
            lv_head_head.setVisibility(VISIBLE);
        }

       // adapter.notifyDataSetChanged();
    }


}