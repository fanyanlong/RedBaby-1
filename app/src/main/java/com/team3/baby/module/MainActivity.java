package com.team3.baby.module;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.team3.baby.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.relative_layout_main_activity)
    RelativeLayout relativeLayoutMainActivity;
    @BindView(R.id.rdoBtn_home_main_activity)
    RadioButton rdoBtnHomeMainActivity;
    @BindView(R.id.rdoBtn_class_main_activity)
    RadioButton rdoBtnClassMainActivity;
    @BindView(R.id.rdoBtn_shopping_main_activity)
    RadioButton rdoBtnShoppingMainActivity;
    @BindView(R.id.rdoBtn_myebuy_main_activity)
    RadioButton rdoBtnMyebuyMainActivity;
    @BindView(R.id.rdoGroup)
    RadioGroup rdoGroup;
    @BindView(R.id.iv_groupBuy_main_activity)
    ImageView ivGroupBuyMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //郭彦君快更新


    }
}
