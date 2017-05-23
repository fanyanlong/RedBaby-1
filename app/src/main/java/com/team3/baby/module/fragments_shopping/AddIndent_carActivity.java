package com.team3.baby.module.fragments_shopping;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.team3.baby.R;
import com.team3.baby.module.fragments_shopping.shoppingutils.Shop_Utils;
import com.team3.baby.utils.ImageUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddIndent_carActivity extends AppCompatActivity {

    @BindView(R.id.iv_add_picture)
    ImageView ivAddPicture;
    @BindView(R.id.tv_add_shoppingName)
    TextView tvAddShoppingName;
    @BindView(R.id.tv_add_shoppingPrice)
    TextView tvAddShoppingPrice;
    @BindView(R.id.btn_confirm_buy)
    Button btnConfirmBuy;
    @BindView(R.id.tv_minus)
    TextView tvMinus;
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.tv_and)
    TextView tvAnd;

    private int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_indent);
        ButterKnife.bind(this);
        initData();

    }

    private void initData() {
        ArrayList<String> picUrl = Shop_Utils.getPicUrl();
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        String shopName = intent.getStringExtra("shopName");
        String shopPrice = intent.getStringExtra("shopPrice");
        ImageUtils.loadImageNormal(this, picUrl.get(position), ivAddPicture);
        tvAddShoppingName.setText(shopName);
        tvAddShoppingPrice.setText(shopPrice);
        final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(AddIndent_carActivity.this, R.anim.shoppingcarpic_set);
        btnConfirmBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivAddPicture.startAnimation(animationSet);

            }
        });
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                Toast.makeText(AddIndent_carActivity.this, "加入购物车成功", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        tvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (num == 1) {
                    tvMinus.setTextColor(Color.GRAY);
                    etNumber.setText("1");
                }else{
                    tvMinus.setTextColor(Color.BLACK);
                    num = num - 1;
                    etNumber.setText(num + "");
                }
            }
        });
        tvAnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMinus.setTextColor(Color.BLACK);
                num = num + 1;
                etNumber.setText(num + "");
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        WindowManager wm = this.getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight() * 9 / 32;
        int x = (int) event.getX();
        int y = (int) event.getY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                if (x < width && y < height) {
                    finish();
                }

                break;

        }

        return super.onTouchEvent(event);
    }
}
