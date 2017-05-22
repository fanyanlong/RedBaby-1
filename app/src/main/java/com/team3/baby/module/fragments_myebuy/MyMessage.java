package com.team3.baby.module.fragments_myebuy;

import android.content.Intent;
import android.view.View;

import com.team3.baby.R;
import com.team3.baby.base.BaseFragmentActivity;
import com.team3.baby.module.main_activity.v.MainActivity;

/**
 * @类的用途:我的个人信息
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class MyMessage extends BaseFragmentActivity {


    @Override
    protected void initView() {
        setContentView(R.layout.accountsecurity);
        findViewById(R.id.iv_back_myebuy_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyMessage.this, MainActivity.class);
                startActivity(intent);
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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
