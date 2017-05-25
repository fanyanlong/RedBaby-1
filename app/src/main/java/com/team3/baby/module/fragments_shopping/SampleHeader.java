package com.team3.baby.module.fragments_shopping;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.team3.baby.R;
import com.team3.baby.app.App;
import com.team3.baby.module.fragments_shopping.shop_adapter.HeadBaseAdapter;
import com.team3.baby.module.main_activity.v.MainActivity;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import me.redbaby.greendao.Table_shopping;
import me.redbaby.greendao.Table_shoppingDao;

import static com.team3.baby.module.fragments_shopping.ShoppingFragment.lvFootFoot;

/**
 * Created by cundong on 2015/10/9.
 * <p/>
 * RecyclerView的HeaderView，简单的展示一个TextView
 */
public class SampleHeader extends RelativeLayout {

    private View view;
    private HeadBaseAdapter adapter;
    private LinearLayout lv_head_head;
    public static ListView listView;

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

    public void AddListView(final Context context) {
        listView = (ListView) view.findViewById(R.id.fragment_shopping_listview);
        lv_head_head = (LinearLayout) view.findViewById(R.id.lv_head_head);


        final Table_shoppingDao tableShoppingDao = App.getApplication().getDaoSession().getTable_shoppingDao();
        QueryBuilder<Table_shopping> queryBuilder = tableShoppingDao.queryBuilder();
        final List<Table_shopping> list = queryBuilder.list();

        if (list.size() != 0) {
            /*for (int i = 0; i < list.size(); i++) {
                ShopCarBean shopCarBean = new ShopCarBean();
                shopCarBean.setName(list.get(i).getShopping_name());
                shopCarBean.setNumber(list.get(i).getShopping_count());
                shopCarBean.setPicUrl(list.get(i).getShopping_pic());
                shopCarBean.setPrice(list.get(i).getShopping_price());
                arrayList.add(shopCarBean);
            }*/
            lv_head_head.setVisibility(GONE);
            listView.setVisibility(VISIBLE);
            adapter = new HeadBaseAdapter(context, list);
            listView.setAdapter(adapter);

        } else {
            lv_head_head.setVisibility(VISIBLE);
        }

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                tableShoppingDao.delete(list.get(position));
                list.remove(position);
                adapter.notifyDataSetChanged();
                if (list.size() == 0) {
                    lv_head_head.setVisibility(VISIBLE);
                    lvFootFoot.setVisibility(GONE);
                }
                return true;
            }
        });
    }


}