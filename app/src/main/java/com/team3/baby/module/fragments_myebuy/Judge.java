package com.team3.baby.module.fragments_myebuy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.team3.baby.R;
import com.team3.baby.base.BaseFragmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class Judge extends BaseFragmentActivity {
    @BindView(R.id.iv_back_myebuy_activity)
    ImageView ivBackMyebuyActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: add setContentView(...) invocation
        setContentView(R.layout.accountsecurity);

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

        ivBackMyebuyActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}