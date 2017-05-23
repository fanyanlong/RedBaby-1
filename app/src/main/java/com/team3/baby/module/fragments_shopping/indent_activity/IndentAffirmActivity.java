package com.team3.baby.module.fragments_shopping.indent_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.module.main_activity.v.MainActivity;

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
    @BindView(R.id.tv_shop_content_affirm_indent_activity)
    TextView tvShopContentAffirmIndentActivity;
    @BindView(R.id.tv_shop_price_affirm_indent_activity)
    TextView tvShopPriceAffirmIndentActivity;
    @BindView(R.id.tv_shop_num_affirm_indent_activity)
    TextView tvShopNumAffirmIndentActivity;
    @BindView(R.id.iv_shop_list_affirm_indent_activity)
    ImageView ivShopListAffirmIndentActivity;
    @BindView(R.id.layout_more_shop_affirm_indent_activity)
    LinearLayout layoutMoreShopAffirmIndentActivity;
    @BindView(R.id.tv_pay_affirm_indent_activity)
    TextView tvPayAffirmIndentActivity;
    @BindView(R.id.tv_money_pay_affirm_indent_activity)
    TextView tvMoneyPayAffirmIndentActivity;
    @BindView(R.id.tv_freight_pay_affirm_indent_activity)
    TextView tvFreightPayAffirmIndentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent_affirm);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        noAddressLayoutIndentAffirmActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndentAffirmActivity.this,EditAddressActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
