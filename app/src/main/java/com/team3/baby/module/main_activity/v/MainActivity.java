package com.team3.baby.module.main_activity.v;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.team3.baby.R;
import com.team3.baby.base.BaseActivity;
import com.team3.baby.module.fragments_classify.fragment.ClassifyFragment;
import com.team3.baby.module.fragments_groupBuy.GroupBuyFragment;
import com.team3.baby.module.fragments_home.HomeFragment;
import com.team3.baby.module.fragments_myebuy.MyebuyFragment;
import com.team3.baby.module.fragments_shopping.ShoppingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * @class describe
 * @anthor 田杰谕
 * @time 2017/5/17 下午4:00
 */

public class MainActivity extends BaseActivity {

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
    @BindView(R.id.rdoBtn_hide_main_activity)
    RadioButton rdoBtnHideMainActivity;
    private FragmentManager manager;

    private GroupBuyFragment groupBuyFragment;
    private HomeFragment homeFragment;
    private MyebuyFragment myebuyFragment;
    private ShoppingFragment shoppingFragment;
    private ClassifyFragment classFragment;

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        classFragment = new ClassifyFragment();
        groupBuyFragment = new GroupBuyFragment();
        homeFragment = new HomeFragment();
        myebuyFragment = new MyebuyFragment();
        //ShoppingFragment shoppingFragment = new ShoppingFragment();
        //transaction.add(R.id.relative_layout_main_activity,classFragment,"tag1");
        shoppingFragment = new ShoppingFragment();
        transaction.add(R.id.relative_layout_main_activity, classFragment, "tag1");
        transaction.add(R.id.relative_layout_main_activity, groupBuyFragment, "tag2");
        transaction.add(R.id.relative_layout_main_activity, homeFragment, "tag3");
        transaction.add(R.id.relative_layout_main_activity, myebuyFragment, "tag4");
        transaction.add(R.id.relative_layout_main_activity, shoppingFragment, "tag5");
        transaction.show(classFragment);
        transaction.hide(groupBuyFragment);
        transaction.hide(homeFragment);
        transaction.hide(myebuyFragment);
        transaction.hide(shoppingFragment);
        transaction.commit();
    }

    @Override
    protected void getServerData() {

    }

    @Override
    protected void setListener() {
        rdoBtnHomeMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.show(homeFragment);
                transaction.hide(classFragment);
                transaction.hide(groupBuyFragment);
                transaction.hide(myebuyFragment);
                transaction.hide(shoppingFragment);
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
                transaction.hide(myebuyFragment);
                transaction.hide(shoppingFragment);
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
                transaction.hide(myebuyFragment);
                transaction.hide(shoppingFragment);
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
                transaction.hide(myebuyFragment);
                transaction.show(shoppingFragment);
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
                transaction.show(myebuyFragment);
                transaction.hide(shoppingFragment);
                transaction.commit();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_main);
        initView();


        ButterKnife.bind(this);
    }
}

