package com.team3.baby.module.fragments_shopping.indent_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.module.fragments_shopping.shoppingutils.Shop_Utils;
import com.team3.baby.utils.ImageUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent_affirm);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {


        ArrayList<String> picUrl = Shop_Utils.getPicUrl();
        Intent intent = getIntent();
        int code = intent.getIntExtra("code", 0);
        if (code == 1) {
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

        }


    }


}
