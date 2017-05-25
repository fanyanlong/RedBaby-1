package com.team3.baby.module.fragments_shopping;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.module.fragments_shopping.indent_activity.IndentAffirmActivity;
import com.team3.baby.module.fragments_shopping.shoppingutils.Shop_Utils;
import com.team3.baby.utils.ImageUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddIndent_buyActivity extends AppCompatActivity {

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
        final Intent intent = getIntent();
        final String pic_url = intent.getStringExtra("position");
        final String shopName = intent.getStringExtra("shopName");
        final String shopPrice = intent.getStringExtra("shopPrice");
        ImageUtils.loadImageNormal(this, pic_url, ivAddPicture);
        tvAddShoppingName.setText(shopName);
        tvAddShoppingPrice.setText(shopPrice);





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

        btnConfirmBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(AddIndent_buyActivity.this, IndentAffirmActivity.class);
                intent1.putExtra("position", pic_url);
                intent1.putExtra("shopName", shopName);
                intent1.putExtra("shopPrice", shopPrice);
                intent1.putExtra("number",num);
                intent1.putExtra("code",1);
                startActivity(intent1);
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
