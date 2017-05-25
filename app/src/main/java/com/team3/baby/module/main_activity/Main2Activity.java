package com.team3.baby.module.main_activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.team3.baby.R;
import com.team3.baby.module.fragments_classify.fragment.view.ClassifyFragment;
import com.team3.baby.module.fragments_groupBuy.GroupBuyFragment;
import com.team3.baby.module.fragments_home.HomeFragment;
import com.team3.baby.module.fragments_myebuy.MyebuyFragment;
import com.team3.baby.module.fragments_shopping.ShoppingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends FragmentActivity {

    @BindView(R.id.relative_layout_main_activity)
    RelativeLayout relativeLayoutMainActivity;
    @BindView(R.id.rdoBtn_home_main_activity)
    RadioButton rdoBtnHomeMainActivity;
    @BindView(R.id.rdoBtn_class_main_activity)
    RadioButton rdoBtnClassMainActivity;
    @BindView(R.id.rdoBtn_hide_main_activity)
    RadioButton rdoBtnHideMainActivity;
    @BindView(R.id.rdoBtn_shopping_main_activity)
    RadioButton rdoBtnShoppingMainActivity;
    @BindView(R.id.rdoBtn_myebuy_main_activity)
    RadioButton rdoBtnMyebuyMainActivity;
    @BindView(R.id.rdoGroup)
    RadioGroup rdoGroup;
    @BindView(R.id.iv_groupBuy_main_activity)
    ImageView ivGroupBuyMainActivity;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initLinsener();
    }

    private void initLinsener() {
        rdoBtnHomeMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.show(homeFragment);
                transaction.hide(classFragment);
                transaction.hide(groupBuyFragment);
                transaction.hide(shoppingFragment);
                transaction.hide(myebuyFragment);
                transaction.commit();
            }
        });
        rdoBtnClassMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.hide(homeFragment);
                transaction.show(classFragment);
                transaction.hide(groupBuyFragment);
                transaction.hide(shoppingFragment);
                transaction.hide(myebuyFragment);
                transaction.commit();
            }
        });
        ivGroupBuyMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.hide(homeFragment);
                transaction.hide(classFragment);
                transaction.show(groupBuyFragment);
                transaction.hide(shoppingFragment);
                transaction.hide(myebuyFragment);
                transaction.commit();
                rdoBtnHideMainActivity.setChecked(true);
            }
        });
        rdoBtnShoppingMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.hide(homeFragment);
                transaction.hide(classFragment);
                transaction.hide(groupBuyFragment);
                transaction.show(shoppingFragment);
                transaction.hide(myebuyFragment);
                transaction.commit();
            }
        });
        rdoBtnMyebuyMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.hide(homeFragment);
                transaction.hide(classFragment);
                transaction.hide(groupBuyFragment);
                transaction.hide(shoppingFragment);
                transaction.show(myebuyFragment);
                transaction.commit();
            }
        });
    }

    private GroupBuyFragment groupBuyFragment;
    private HomeFragment homeFragment;
    private MyebuyFragment myebuyFragment;
    private ShoppingFragment shoppingFragment;
    private ClassifyFragment classFragment;

    private void initData() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        groupBuyFragment = new GroupBuyFragment();
        homeFragment = new HomeFragment();
        myebuyFragment = new MyebuyFragment();
        shoppingFragment = new ShoppingFragment();
        classFragment = new ClassifyFragment();
        transaction.add(R.id.relative_layout_main_activity, homeFragment, "tag1");
        transaction.add(R.id.relative_layout_main_activity, classFragment, "tag2");
        transaction.add(R.id.relative_layout_main_activity, groupBuyFragment, "tag3");
        transaction.add(R.id.relative_layout_main_activity, shoppingFragment, "tag4");
        transaction.add(R.id.relative_layout_main_activity, myebuyFragment, "tag5");
        transaction.show(homeFragment);
        transaction.hide(classFragment);
        transaction.hide(groupBuyFragment);
        transaction.hide(shoppingFragment);
        transaction.hide(myebuyFragment);
        transaction.commit();

    }
}
