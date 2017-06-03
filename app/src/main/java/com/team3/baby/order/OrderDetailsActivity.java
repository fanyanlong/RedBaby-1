package com.team3.baby.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.orhanobut.logger.Logger;
import com.team3.baby.R;
import com.team3.baby.bean.OrderBean;
import com.team3.baby.utils.GsonUtils;

import okhttp3.Call;
import okhttp3.Response;

public class OrderDetailsActivity extends AppCompatActivity {

    private TextView tv_orderdetails;
    private String mOrder_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        initView();
        initData();
        getServerData();
    }

    private void getServerData() {
        String url = "http://service.alinq.cn:2800/UserShop/Order/GetOrder";
        OkGo.get(url)
                .headers("user-token", "584cfabb4918e4186a77ff1e")
                .headers("application-key", "58424776034ff82470d06d3d")
                .params("storeId", "58401d1906c02a2b8877bd13")
                .params("orderId", mOrder_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Logger.d(s);
                        //订单对象
                        OrderBean orderBean = GsonUtils.gsonToBean(s, OrderBean.class);
                    }
                });
    }

    private void initData() {
        Intent intent = getIntent();
        mOrder_id = intent.getStringExtra("order_id");
        tv_orderdetails.setText(mOrder_id);
    }

    private void initView() {
        tv_orderdetails = (TextView) findViewById(R.id.tv_orderdetails);
    }
}
