package com.team3.baby.module.main_activity.v;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.team3.baby.module.main_activity.p.MainPresenter;
import com.umeng.socialize.UMShareAPI;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @class 主界面
 * @anthor 田杰谕
 * @time 2017/5/17 下午4:00
 */

public class MainActivity extends FragmentActivity implements MainView {

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
    /*private UMAuthListener umAuthListener = new UMAuthListener() {

        private String name;

        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            //   Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
            switch (action) {
                // 授权成功的状态
                case UMAuthListener.ACTION_AUTHORIZE:
                    // Toast.makeText(SecondActivity.this, "ACTION_AUTHORIZE111", Toast.LENGTH_SHORT).show();
                    UMShareAPI mShareAPI = UMShareAPI.get(MainActivity.this);
                    mShareAPI.getPlatformInfo(MainActivity.this, platform, umAuthListener);
                    break;
                // 登录成功后的 获取用户信息的// 登录成功后的 获取用户信息的---------------


                case UMAuthListener.ACTION_GET_PROFILE:
                    //  Toast.makeText(SecondActivity.this, "zoule", Toast.LENGTH_SHORT).show();
                    String name = data.get("name");
                    String iconurl = data.get("iconurl");
                    String gender = data.get("gender");
                    SharedPreferences sharedPreferences = getSharedPreferences("config", Context.MODE_PRIVATE);

                    SharedPreferences.Editor edit = sharedPreferences.edit();

                    edit.putBoolean("QQ", true);
                    edit.putString("name", name);
                    edit.putString("iconurl", iconurl);
                    edit.putString("gender", gender);
                    edit.putBoolean("yidenglu", true);
                    edit.commit();


                    Toast.makeText(MainActivity.this, name + gender + "：欢迎您来到今日头条", Toast.LENGTH_SHORT).show();
                    break;


            }

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    */

    private GroupBuyFragment groupBuyFragment;
    private HomeFragment homeFragment;
    private MyebuyFragment myebuyFragment;
    private ShoppingFragment shoppingFragment;
    private ClassifyFragment classFragment;
    private MainPresenter p;


    protected void initData() {
        classFragment = new ClassifyFragment();
        groupBuyFragment = new GroupBuyFragment();
        homeFragment = new HomeFragment();
        myebuyFragment = new MyebuyFragment();
        shoppingFragment = new ShoppingFragment();

        p = new MainPresenter(this);
        p.addFragment();

    }


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

        UMShareAPI.get(this);
        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);
        initData();
        setListener();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}

