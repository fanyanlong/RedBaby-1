package com.team3.baby.module.welcome_activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.team3.baby.R;
import com.team3.baby.base.BaseActivity;
import com.team3.baby.module.main_activity.Main2Activity;

import butterknife.ButterKnife;

/**
 * @class 欢迎页
 * @anthor 田杰谕
 * @time 2017/5/21 下午8:03
 */
public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ButterKnife.bind(this);
        initData();
    }

    @Override
    protected void initView() {

    }

    private Handler hanlder = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent(WelcomeActivity.this, Main2Activity.class);
            startActivity(intent);
            finish();
        }
    };
    @Override
    protected void initData() {
        hanlder.sendEmptyMessageDelayed(0,2000);
    }

    @Override
    protected void getServerData() {

    }

    @Override
    protected void setListener() {

    }

}
