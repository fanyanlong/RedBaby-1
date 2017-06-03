package com.team3.baby.module.fragments_shopping.indent_activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.orhanobut.logger.Logger;
import com.team3.baby.R;
import com.team3.baby.alipay.PayDemoActivity;
import com.team3.baby.app.App;
import com.team3.baby.bean.OrderBean;
import com.team3.baby.utils.GsonUtils;
import com.team3.baby.utils.ImageUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.dao.query.QueryBuilder;
import me.redbaby.greendao.Table_order;
import me.redbaby.greendao.Table_orderDao;
import me.redbaby.greendao.Table_shopping;
import me.redbaby.greendao.Table_shoppingDao;
import okhttp3.Call;
import okhttp3.Response;

/**
 * @class describe
 * @anthor 田杰谕
 * @time 2017/5/25 下午5:10
 */
public class IndentAffirmActivity extends AppCompatActivity {


    @BindView(R.id.iv_back_head_include)
    ImageView ivBackHeadInclude;
    @BindView(R.id.tv_head_include)
    TextView tvHeadInclude;
    @BindView(R.id.iv_add_address_indent_affirm_activity)
    ImageView ivAddAddressIndentAffirmActivity;
    @BindView(R.id.no_address_layout_indent_affirm_activity)
    LinearLayout noAddressLayoutIndentAffirmActivity;
    @BindView(R.id.iv_thumbnail_affirm_indent_activity)
    ImageView ivThumbnailAffirmIndentActivity;
    @BindView(R.id.tv_shop_title_affirm_indent_activity)
    TextView tvShopTitleAffirmIndentActivity;
    @BindView(R.id.tv_shop_price_affirm_indent_activity)
    TextView tvShopPriceAffirmIndentActivity;
    @BindView(R.id.tv_shop_num_affirm_indent_activity)
    TextView tvShopNumAffirmIndentActivity;
    @BindView(R.id.iv_shop_list_affirm_indent_activity)
    ImageView ivShopListAffirmIndentActivity;
    @BindView(R.id.layout_single_shop_affirm_indent_activity)
    LinearLayout layoutSingleShopAffirmIndentActivity;
    @BindView(R.id.iv_more1_affirm_indent_activity)
    ImageView ivMore1AffirmIndentActivity;
    @BindView(R.id.iv_more2_affirm_indent_activity)
    ImageView ivMore2AffirmIndentActivity;
    @BindView(R.id.iv_more3_affirm_indent_activity)
    ImageView ivMore3AffirmIndentActivity;
    @BindView(R.id.tv_count_affirm_indent_activity)
    TextView tvCountAffirmIndentActivity;
    @BindView(R.id.layout_more_shop_affirm_indent_activity)
    LinearLayout layoutMoreShopAffirmIndentActivity;
    @BindView(R.id.tv_pay_affirm_indent_activity)
    TextView tvPayAffirmIndentActivity;
    @BindView(R.id.tv_money_pay_affirm_indent_activity)
    TextView tvMoneyPayAffirmIndentActivity;
    @BindView(R.id.tv_freight_pay_affirm_indent_activity)
    TextView tvFreightPayAffirmIndentActivity;
    @BindView(R.id.tv_zong_price)
    TextView tvZongPrice;
    int count = 0;
    @BindView(R.id.tv_submit_affirm_indent_activity)
    TextView tvSubmitAffirmIndentActivity;
    @BindView(R.id.have_address_layout_indent_affirm_activity)
    LinearLayout haveAddressLayoutIndentAffirmActivity;
    @BindView(R.id.nameAndPhone_indent_affirm_activity)
    TextView nameAndPhoneIndentAffirmActivity;
    @BindView(R.id.myAddress_indent_affirm_activity)
    TextView myAddressIndentAffirmActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent_affirm);
        ButterKnife.bind(this);


        initData();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initAddress();
    }

    private void initListener() {
        ivBackHeadInclude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvSubmitAffirmIndentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //生成订单，跳转到支付界面
                postOrder();
                Intent intent = new Intent(IndentAffirmActivity.this, PayDemoActivity.class);
                startActivity(intent);
            }
        });
        noAddressLayoutIndentAffirmActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndentAffirmActivity.this, EditAddressActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initAddress() {

        SharedPreferences sharedPreferences = getSharedPreferences("addAddress", MODE_PRIVATE);
       /* edit.putString("address",etAddress);
        edit.putString("consignee",etConsignee);
        edit.putString("phoneNum",etPhoneNum);
        edit.putString("area",tvArea);*/
        String address = sharedPreferences.getString("address", "");
        String consignee = sharedPreferences.getString("consignee", "");
        String phoneNum = sharedPreferences.getString("phoneNum", "");
        String area = sharedPreferences.getString("area", "");
        if (address.equals("") && consignee.equals("") && phoneNum.equals("") && area.equals("")) {
            noAddressLayoutIndentAffirmActivity.setVisibility(View.VISIBLE);
            haveAddressLayoutIndentAffirmActivity.setVisibility(View.GONE);
        } else {
            noAddressLayoutIndentAffirmActivity.setVisibility(View.GONE);
            haveAddressLayoutIndentAffirmActivity.setVisibility(View.VISIBLE);
            nameAndPhoneIndentAffirmActivity.setText(consignee + "    " + phoneNum);
            myAddressIndentAffirmActivity.setText(area + address);
        }

    }

    private void initData() {

        Intent intent = getIntent();
        String totalPrice = intent.getStringExtra("totalPrice");

        tvMoneyPayAffirmIndentActivity.setText("¥" + totalPrice);
        tvZongPrice.setText("¥" + totalPrice);
        int code = intent.getIntExtra("code", 0);
        if (code == 1) {
            layoutSingleShopAffirmIndentActivity.setVisibility(View.VISIBLE);
            layoutMoreShopAffirmIndentActivity.setVisibility(View.GONE);
            String pic_url = intent.getStringExtra("position");
            String shopName = intent.getStringExtra("shopName");
            String shopPrice = intent.getStringExtra("shopPrice");

            int num = intent.getIntExtra("number", 0);
            ImageUtils.loadImageNormal(this, pic_url, ivThumbnailAffirmIndentActivity);
            tvShopTitleAffirmIndentActivity.setText(shopName);
            tvShopPriceAffirmIndentActivity.setText(shopPrice);
            tvShopNumAffirmIndentActivity.setText("x" + num);

            String substring = shopPrice.substring(1);
            float number = Float.parseFloat(substring);
            number = number * num;
            tvZongPrice.setText("￥" + number);
            tvMoneyPayAffirmIndentActivity.setText("￥" + number);
        } else {
            Table_shoppingDao tableShoppingDao = App.getApplication().getDaoSession().getTable_shoppingDao();
            QueryBuilder<Table_shopping> queryBuilder = tableShoppingDao.queryBuilder();
            List<Table_shopping> list = queryBuilder.list();
            if (list.size() > 1) {
                layoutMoreShopAffirmIndentActivity.setVisibility(View.VISIBLE);
                layoutSingleShopAffirmIndentActivity.setVisibility(View.GONE);

                if (list.size() == 2) {
                    ImageUtils.loadImageNormal(this, list.get(0).getShopping_pic(), ivMore1AffirmIndentActivity);
                    ImageUtils.loadImageNormal(this, list.get(1).getShopping_pic(), ivMore2AffirmIndentActivity);
                    for (int i = 0; i < list.size(); i++) {
                        count += list.get(i).getShopping_count();
                    }
                    tvCountAffirmIndentActivity.setText("共" + count + "件");
                }
                if (list.size() > 3 || list.size() == 3) {
                    ImageUtils.loadImageNormal(this, list.get(0).getShopping_pic(), ivMore1AffirmIndentActivity);
                    ImageUtils.loadImageNormal(this, list.get(1).getShopping_pic(), ivMore2AffirmIndentActivity);
                    ImageUtils.loadImageNormal(this, list.get(2).getShopping_pic(), ivMore3AffirmIndentActivity);

                    for (int i = 0; i < list.size(); i++) {
                        count += list.get(i).getShopping_count();
                    }
                    tvCountAffirmIndentActivity.setText("共" + count + "件");

                }

            } else {
                layoutSingleShopAffirmIndentActivity.setVisibility(View.VISIBLE);
                layoutMoreShopAffirmIndentActivity.setVisibility(View.GONE);
                ImageUtils.loadImageNormal(this, list.get(0).getShopping_pic(), ivThumbnailAffirmIndentActivity);
                tvShopTitleAffirmIndentActivity.setText(list.get(0).getShopping_name());
                tvShopPriceAffirmIndentActivity.setText("¥ " + list.get(0).getShopping_price());
                tvShopNumAffirmIndentActivity.setText("x" + list.get(0).getShopping_count());

            }

        }
        //遍历数据库，取需值，形成订单
        getOrderParam();

    }

    private void getOrderParam() {
        Table_shoppingDao tableShoppingDao = App.getApplication().getDaoSession().getTable_shoppingDao();
        QueryBuilder<Table_shopping> queryBuilder = tableShoppingDao.queryBuilder();
        List<Table_shopping> list = queryBuilder.list();
        int number = 0;
        String id = "";
        mIdList = new ArrayList<>();
        mNumList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int count = list.get(i).getShopping_count();
            mNumList.add(count);
            number = number + count;
            id = list.get(i).getShopping_id();
            mIdList.add(id);
        }
    }

    //生成订单
    private void postOrder() {
        JSONArray idArray = new JSONArray();
        for (int i = 0; i < mIdList.size(); i++) {
            String idString = mIdList.get(i);
            idArray.put(idString);
        }

        JSONArray numArray = new JSONArray();
        int numInt = 0;
        for (int i = 0; i < mNumList.size(); i++) {
            numInt = mNumList.get(i);
            numArray.put(numInt);
        }

        HashMap params = new HashMap<String, JSONArray>();
        params.put("productIds", idArray);
        params.put("quantities", numArray);
        JSONObject jsonObject = new JSONObject(params);
        Logger.d("JSON==" + jsonObject.toString());
        String mUrl = "http://service.alinq.cn:2800/UserShop/Order/CreateOrder?storeId=58401d1906c02a2b8877bd13";

        OkGo.post(mUrl)
                .headers("application-key", "58424776034ff82470d06d3d")
                .headers("user-token", "584cfabb4918e4186a77ff1e")
                .headers("Content-Type", "application/json")
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Logger.d(s);
                        OrderBean orderBean = GsonUtils.gsonToBean(s, OrderBean.class);
                        String id = orderBean.getId();
                        Table_orderDao table_orderDao = App.getApplication().getDaoSession().getTable_orderDao();
                        Table_order order = new Table_order();
                        order.setOrder_id(id);
                        table_orderDao.insert(order);
                    }
                });
    }

    private List<String> mIdList;
    private List<Integer> mNumList;

}
