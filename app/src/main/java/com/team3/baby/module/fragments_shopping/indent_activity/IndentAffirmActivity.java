package com.team3.baby.module.fragments_shopping.indent_activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.team3.baby.R;
import com.team3.baby.module.fragments_shopping.shoppingutils.Shop_Utils;
import com.team3.baby.utils.ImageUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.team3.baby.R.id.tv_shop_num_affirm_indent_activity;

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
    @BindView(tv_shop_num_affirm_indent_activity)
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
    @BindView(R.id.activity_indent_affirm)
    LinearLayout activityIndentAffirm;
    @BindView(R.id.tv_zong_price)
    TextView tvZongPrice;
    /**  tv_money_pay_affirm_indent_activity
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent_affirm);
        ButterKnife.bind(this);
        initData();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initData() {
        ArrayList<String> picUrl = Shop_Utils.getPicUrl();
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        String shopName = intent.getStringExtra("shopName");
        String shopPrice = intent.getStringExtra("shopPrice");
        int num = intent.getIntExtra("number", 0);
        ImageUtils.loadImageNormal(this, picUrl.get(position), ivThumbnailAffirmIndentActivity);
        tvShopTitleAffirmIndentActivity.setText(shopName);
        tvShopPriceAffirmIndentActivity.setText(shopPrice);
        tvShopNumAffirmIndentActivity.setText("x" + num);

        String substring = shopPrice.substring(1);
        float number = Float.parseFloat(substring);
        number = number * num;
        tvZongPrice.setText("￥" + number);
        tvMoneyPayAffirmIndentActivity.setText("￥" + number);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("IndentAffirm Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
