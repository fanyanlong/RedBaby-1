package com.team3.baby.module.main_activity.v;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.team3.baby.module.main_activity.p.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @class describe
 * @anthor 田杰谕
 * @time 2017/5/17 下午4:00
 */

public class MainActivity extends BaseActivity implements MainView {

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
    private MainPresenter p;

    @Override
    protected void initView() {
    }


    @Override
    protected void initData() {
        classFragment = new ClassifyFragment();
        groupBuyFragment = new GroupBuyFragment();
        homeFragment = new HomeFragment();
        myebuyFragment = new MyebuyFragment();
        shoppingFragment = new ShoppingFragment();

        p = new MainPresenter(this);
        p.addFragment();

    }

    @Override
    protected void getServerData() {

    }

    @Override
    protected void setListener() {

        rdoBtnHomeMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setMainOnListenerHome();
            }
        });
        rdoBtnClassMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setMainOnListenerClass();
            }
        });
        ivGroupBuyMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setMainOnListenerGroupBuy(rdoBtnHideMainActivity);
            }
        });
        rdoBtnShoppingMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setMainOnListenerShopping();
            }
        });
        rdoBtnMyebuyMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setMainOnListenerMyeBuy();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public Fragment getFragment1() {
        return homeFragment;
    }

    @Override
    public Fragment getFragment2() {
        return classFragment;
    }

    @Override
    public Fragment getFragment3() {
        return groupBuyFragment;
    }

    @Override
    public Fragment getFragment4() {
        return shoppingFragment;
    }

    @Override
    public Fragment getFragment5() {
        return myebuyFragment;
    }

    @Override
    public int getLayout() {
        return R.id.relative_layout_main_activity;
    }

    @Override
    public FragmentTransaction getFragmentTransaction() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        return transaction;
    }


}

