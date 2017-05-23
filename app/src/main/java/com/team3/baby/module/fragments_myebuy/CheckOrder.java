package com.team3.baby.module.fragments_myebuy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.team3.baby.R;
import com.team3.baby.module.main_activity.v.MainActivity;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class CheckOrder extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_myorder_myebuy);
        final RadioButton rb_net_order = (RadioButton) findViewById(R.id.rb_net_order);
        final RadioButton rb_qita_order = (RadioButton) findViewById(R.id.rb_qita_order);
        rb_qita_order.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    rb_qita_order.setTextColor(Color.RED);
                    rb_net_order.setTextColor(Color.BLACK);

                } else {
                    rb_net_order.setTextColor(Color.RED);
                    rb_qita_order.setTextColor(Color.BLACK);
                }
            }
        });
        findViewById(R.id.iv_back_myorder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckOrder.this, MainActivity.class);
                startActivity(intent);
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