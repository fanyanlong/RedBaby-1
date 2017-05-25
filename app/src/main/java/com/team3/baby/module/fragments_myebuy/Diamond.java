package com.team3.baby.module.fragments_myebuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.team3.baby.R;
import com.team3.baby.module.main_activity.v.MainActivity;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class Diamond extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_diamond_mybey);
        findViewById(R.id.iv_back_shouhuo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}