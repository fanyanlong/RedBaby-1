package com.team3.baby.module.fragments_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.module.fragments_shopping.shoppingutils.Shop_Utils;
import com.team3.baby.utils.ImageUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShoppingCarActivity extends AppCompatActivity {

    @BindView(R.id.iv_back_shoppingcar_activity)
    ImageView ivBackShoppingcarActivity;
    @BindView(R.id.tv_immediately_buy)
    TextView tvImmediatelyBuy;
    @BindView(R.id.tv_join_shopping_car)
    TextView tvJoinShoppingCar;
    @BindView(R.id.iv_shoppingPicture)
    ImageView ivShoppingPicture;
    @BindView(R.id.tv_shoppingName)
    TextView tvShoppingName;
    @BindView(R.id.tv_shoppingPrice)
    TextView tvShoppingPrice;
    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_car);
        ButterKnife.bind(this);
        WindowManager wm = this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        initData();
    }

    private void initData() {
        final ArrayList<String> picUrl = Shop_Utils.getPicUrl();

        Intent intent = getIntent();
        final String position = intent.getStringExtra("position");
        final String shopName = intent.getStringExtra("shopName");
        final String shopPrice = intent.getStringExtra("shopPrice");
        ImageUtils.loadImageNormal(this, position, ivShoppingPicture);
        tvShoppingName.setText(shopName);
        tvShoppingPrice.setText(shopPrice);

        ivBackShoppingcarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
              /*  Intent intent = new Intent(ShoppingCarActivity.this, MainActivity.class);

                startActivity(intent);*/
            }
        });
        tvImmediatelyBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCarActivity.this, AddIndent_buyActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("shopName", shopName);
                intent.putExtra("shopPrice", shopPrice);
                startActivity(intent);


            }
        });
        tvJoinShoppingCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCarActivity.this, AddIndent_carActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("shopName", shopName);
                intent.putExtra("shopPrice", shopPrice);
                startActivity(intent);
            }
        });

    }


}
