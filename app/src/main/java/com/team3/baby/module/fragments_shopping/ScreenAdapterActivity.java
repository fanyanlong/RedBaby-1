package com.team3.baby.module.fragments_shopping;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.module.fragments_shopping.shop_adapter.ScreenAdapter;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;



public class ScreenAdapterActivity extends AutoLayoutActivity {

    @BindView(R.id.tv_screen_adapter_activity)
    TextView tvScreenAdapterActivity;
    @BindView(R.id.recycler_screen_adapter_activity)
    RecyclerView recyclerScreenAdapterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_adapter);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add("商品"+i);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        ScreenAdapter adapter = new ScreenAdapter(list);
        recyclerScreenAdapterActivity.setLayoutManager(manager);
        recyclerScreenAdapterActivity.setAdapter(adapter);
    }
}
