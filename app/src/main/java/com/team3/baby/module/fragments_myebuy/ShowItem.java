package com.team3.baby.module.fragments_myebuy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.team3.baby.R;
import com.team3.baby.module.fragments_myebuy.activity_myebuy.MyDiTu;

import java.util.ArrayList;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class ShowItem extends Activity {

    private ArrayList<String> list;
    private String dizhi;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_dizhi_myebuy);
        list = new ArrayList<String>();
        Intent intent = getIntent();
        dizhi = intent.getStringExtra("dizhi");

        findViewById(R.id.iv_back_dizhi_myebuy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        findViewById(R.id.tv_addaddress_mye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowItem.this, MyDiTu.class);

                startActivity(intent);
                finish();
            }
        });
        lv = (ListView) findViewById(R.id.lv_dizhi_mebuy);
        if (dizhi != null) {
            list.add(dizhi);
            lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
        }



        /*if (list.size() > 0) {
            lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));


        }*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (list.size() > 0) {

            lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
        }
    }
}