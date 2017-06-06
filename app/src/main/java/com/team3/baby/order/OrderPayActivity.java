package com.team3.baby.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.orhanobut.logger.Logger;
import com.team3.baby.R;
import com.team3.baby.app.App;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.dao.query.QueryBuilder;
import me.redbaby.greendao.Table_order;
import me.redbaby.greendao.Table_orderDao;
import okhttp3.Call;
import okhttp3.Response;

public class OrderPayActivity extends AppCompatActivity {

    @BindView(R.id.tv_order_pay)
    TextView mTvOrderPay;
    @BindView(R.id.btn_affirm_order_pay)
    Button mBtnAffirmOrderPay;
    private String mOrder_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pay);
        ButterKnife.bind(this);
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
        //
        mTvOrderPay.setText(mOrder_id);
    }

    @OnClick({R.id.tv_order_pay, R.id.btn_affirm_order_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_order_pay:

                break;
            case R.id.btn_affirm_order_pay:
                //确认订单
                affirmOrder(mOrder_id);
                startActivity(new Intent(OrderPayActivity.this, OrderDetailsActivity.class));
                finish();
                break;
        }
    }

    private void affirmOrder(String order_id) {
        String url = "http://service.alinq.cn:2800/UserShop/Order/ConfirmOrder?storeId=58401d1906c02a2b8877bd13";

        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", order_id);
        params.put("invoice", null);
        params.put("remark", null);
        JSONObject jsonObject = new JSONObject(params);

        OkGo.post("http://service.alinq.cn:2800/UserShop/ShoppingCart/AddItem")
                .headers("application-key", "58424776034ff82470d06d3d")
                .headers("user-token", "584cfabb4918e4186a77ff1e")
                .headers("Content-Type", "application/json")
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Logger.d(s);
                    }
                });
    }
}
