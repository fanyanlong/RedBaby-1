package com.team3.baby.module.fragments_myebuy;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.team3.baby.R;
import com.team3.baby.module.fragments_myebuy.fragment_pingjia.Order_Net_Fragment;
import com.team3.baby.module.fragments_myebuy.fragment_pingjia.Order_ping_Fragment;
import com.team3.baby.module.fragments_myebuy.fragment_pingjia.Order_shou_Fragment;
import com.team3.baby.module.fragments_myebuy.fragment_pingjia.Order_zhi_Fragment;

import java.util.ArrayList;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class MyService extends FragmentActivity {

    private TabLayout tablatout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private String[] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weixiu_mebuy);
        findViewById(R.id.iv_back_tuihuan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        tablatout = (TabLayout) findViewById(R.id.tablelayout_tuihuan_myebuy);
        viewPager = (ViewPager) findViewById(R.id.vp_tuihuan_myebuy);
        Order_Net_Fragment net_fragment = new Order_Net_Fragment();
        Order_ping_Fragment ping_fragment = new Order_ping_Fragment();
        Order_shou_Fragment shou_fragment = new Order_shou_Fragment();
        Order_zhi_Fragment zhi_fragment = new Order_zhi_Fragment();
        fragments = new ArrayList<>();
        fragments.add(net_fragment);
        fragments.add(zhi_fragment);
        fragments.add(shou_fragment);
        fragments.add(ping_fragment);
        titles = new String[]{"售后申请", "维修安装", "退换记录", "安维记录"};

        tablatout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < titles.length; i++) {
            tablatout.addTab(tablatout.newTab().setText(titles[i]));
        }
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tablatout.setupWithViewPager(viewPager);
        tablatout.setTabsFromPagerAdapter(adapter);


    }

    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }



}