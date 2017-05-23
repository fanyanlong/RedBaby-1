package com.team3.baby.module.fragments_myebuy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.team3.baby.R;
import com.team3.baby.module.main_activity.v.MainActivity;

import butterknife.ButterKnife;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class Setting extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_setting_myebuy);
        findViewById(R.id.iv_back_huiyuan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ButterKnife.bind(this);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}