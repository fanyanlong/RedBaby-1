package com.team3.baby.module.fragments_shopping;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

import com.orhanobut.logger.Logger;
import com.team3.baby.R;
import com.team3.baby.app.App;
import com.team3.baby.utils.ImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.dao.query.QueryBuilder;
import me.redbaby.greendao.Table_shopping;
import me.redbaby.greendao.Table_shoppingDao;

import static android.view.View.GONE;
import static com.team3.baby.module.fragments_shopping.ShoppingFragment.lvFootFoot;

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
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_indent);
        ButterKnife.bind(this);
        initData();

    }

    private void initData() {
        Intent intent = getIntent();
        final String position = intent.getStringExtra("position");
        final String shopName = intent.getStringExtra("shopName");
        final String shopPrice = intent.getStringExtra("shopPrice");
        ImageUtils.loadImageNormal(this, position, ivAddPicture);
        tvAddShoppingName.setText(shopName);
        tvAddShoppingPrice.setText(shopPrice);
        String substring = shopPrice.substring(1);
        final float price = Float.parseFloat(substring);

        flag = true;
        final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(AddIndent_carActivity.this, R.anim.shoppingcarpic_set);
        btnConfirmBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Table_shoppingDao table_shoppingDao = App.getApplication().getDaoSession().getTable_shoppingDao();

                QueryBuilder<Table_shopping> queryBuilder = table_shoppingDao.queryBuilder();
                List<Table_shopping> list = queryBuilder.list();


                if (list.size() > 0) {

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getShopping_name().equals(shopName)) {
                            Table_shopping shopping = list.get(i);
                            shopping.setShopping_count(shopping.getShopping_count() + 1);
                            table_shoppingDao.update(shopping);
                            flag = false;
                        }
                    }
                    if (flag) {
                        Table_shopping bb = new Table_shopping();
                        bb.setShopping_name(shopName);
                        bb.setShopping_pic(position);
                        bb.setShopping_price(price);
                        bb.setShopping_count(num);
                        table_shoppingDao.insert(bb);
                        com.orhanobut.logger.Logger.d(bb);
                    }

                } else {
                    Table_shopping bb = new Table_shopping();
                    bb.setShopping_name(shopName);
                    bb.setShopping_pic(position);
                    bb.setShopping_price(price);
                    bb.setShopping_count(num);
                    table_shoppingDao.insert(bb);
                    Logger.d("---------------------------->list");
                }


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

                if (AddIndent_carActivity.this.num == 1) {
                    tvMinus.setTextColor(Color.GRAY);
                    etNumber.setText("1");
                } else {
                    tvMinus.setTextColor(Color.BLACK);
                    AddIndent_carActivity.this.num = AddIndent_carActivity.this.num - 1;
                    etNumber.setText(AddIndent_carActivity.this.num + "");
                }
            }
        });
        tvAnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMinus.setTextColor(Color.BLACK);
                AddIndent_carActivity.this.num = AddIndent_carActivity.this.num + 1;
                etNumber.setText(AddIndent_carActivity.this.num + "");
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Table_shoppingDao tableShoppingDao = App.getApplication().getDaoSession().getTable_shoppingDao();
        QueryBuilder<Table_shopping> queryBuilder = tableShoppingDao.queryBuilder();
        List<Table_shopping> list = queryBuilder.list();
        Log.d("sssssssssssssss", list.size() + "");
        if (list.size() != 0) {
            lvFootFoot.setVisibility(View.VISIBLE);
        } else {
            lvFootFoot.setVisibility(GONE);
        }
    }
}
