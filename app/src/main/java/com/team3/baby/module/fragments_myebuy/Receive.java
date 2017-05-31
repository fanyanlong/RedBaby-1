package com.team3.baby.module.fragments_myebuy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.team3.baby.R;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class Receive extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_daishouhuo_mybey);
        findViewById(R.id.iv_back_shouhuo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }



}