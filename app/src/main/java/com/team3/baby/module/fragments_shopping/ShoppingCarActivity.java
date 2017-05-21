package com.team3.baby.module.fragments_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.team3.baby.R;
import com.team3.baby.module.main_activity.v.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;



public class ShoppingCarActivity extends AppCompatActivity {

    @BindView(R.id.iv_back_shoppingcar_activity)
    ImageView ivBackShoppingcarActivity;
    @BindView(R.id.tv_immediately_buy)
    TextView tvImmediatelyBuy;
    @BindView(R.id.tv_join_shopping_car)
    TextView tvJoinShoppingCar;
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

        ivBackShoppingcarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        tvImmediatelyBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShoppingCarActivity.this, "sss", Toast.LENGTH_SHORT).show();
                View contentView = View.inflate(ShoppingCarActivity.this, R.layout.immediately_buy_popwindow_layout, null);
                PopupWindow  popupWindow = new PopupWindow(contentView, width, height/3*2);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(contentView, width, height/4);
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
