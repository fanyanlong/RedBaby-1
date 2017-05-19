package com.team3.baby.module.fragments_myebuy;

import android.view.View;

import com.team3.baby.R;
import com.team3.baby.base.BaseActivity;

/**
 * @类的用途:我的个人信息
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class MyMessage extends BaseActivity {


    @Override
    protected void initView() {
        setContentView(R.layout.accountsecurity);
        findViewById(R.id.iv_back_myebuy_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
