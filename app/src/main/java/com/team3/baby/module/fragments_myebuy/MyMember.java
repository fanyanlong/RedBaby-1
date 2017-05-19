package com.team3.baby.module.fragments_myebuy;

import android.os.Bundle;
import android.view.View;

import com.team3.baby.R;
import com.team3.baby.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * @类的用途:我的会员信息
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class MyMember  extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: add setContentView(...) invocation
        setContentView(R.layout.accountsecurity);
        findViewById(R.id.iv_back_myebuy_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ButterKnife.bind(this);
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void getServerData() {

    }

    @Override
    protected void setListener() {

    }
}