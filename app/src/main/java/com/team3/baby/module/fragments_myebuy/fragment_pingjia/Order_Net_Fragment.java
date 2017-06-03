package com.team3.baby.module.fragments_myebuy.fragment_pingjia;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.team3.baby.R;
import com.team3.baby.app.App;
import com.team3.baby.order.OrderDetailsActivity;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import me.redbaby.greendao.Table_order;
import me.redbaby.greendao.Table_orderDao;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/24
 */

public class Order_Net_Fragment extends Fragment implements View.OnClickListener {
    private Button btn_checkorder;
    private String mOrder_id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ping_sp_fragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        btn_checkorder = (Button) view.findViewById(R.id.btn_checkorder);

        btn_checkorder.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        //读取数据库，订单号信息
        Table_orderDao orderDao = App.getApplication().getDaoSession().getTable_orderDao();
        QueryBuilder<Table_order> queryBuilder = orderDao.queryBuilder();
        List<Table_order> orderList = queryBuilder.list();
        if (null != orderList) {
            for (int i = 0; i < orderList.size(); i++) {
                mOrder_id = orderList.get(i).getOrder_id();
            }
        }
        btn_checkorder.setText(mOrder_id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_checkorder:
                Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
                intent.putExtra("order_id", mOrder_id);
                startActivity(intent);
                break;
        }
    }
}
