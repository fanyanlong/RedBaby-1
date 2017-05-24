package com.team3.baby.module.fragments_myebuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.team3.baby.R;
import com.team3.baby.module.main_activity.v.MainActivity;

import butterknife.ButterKnife;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class Accountsecurity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_security_mybey);
        findViewById(R.id.iv_back_security).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
