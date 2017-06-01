package com.team3.baby.module.fragments_myebuy;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.team3.baby.R;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class Setting extends Activity {

    private TextView tuichu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_setting_myebuy);
        findViewById(R.id.iv_back_huiyuan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        tuichu = (TextView) findViewById(R.id.tv_tuivhu_shezhi);
        tuichu.setOnClickListener(new View.OnClickListener() {

            private SharedPreferences.Editor edit;

            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("config", Context.MODE_PRIVATE);


                edit = sharedPreferences.edit();
                edit.putBoolean("yidenglu", false);
                edit.commit();
                SharedPreferences sp = getSharedPreferences("addAddress", MODE_PRIVATE);
                SharedPreferences.Editor edit1 = sp.edit();
                edit1.clear();
                edit1.commit();

                finish();


            }
        });
       
    }



}