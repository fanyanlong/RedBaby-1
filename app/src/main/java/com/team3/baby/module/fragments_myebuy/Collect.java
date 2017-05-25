package com.team3.baby.module.fragments_myebuy;

import android.content.Intent;
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
import com.team3.baby.module.main_activity.v.MainActivity;

import java.util.ArrayList;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class Collect extends FragmentActivity {

    private ArrayList<Fragment> fragments;
    private String[] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shoucang_mybey);
        findViewById(R.id.iv_back_shoucang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        TabLayout tablatout = (TabLayout) findViewById(R.id.tab_shoucang_myeuy);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_shoucang_myebuy);
        Order_Net_Fragment net_fragment = new Order_Net_Fragment();
        Order_ping_Fragment ping_fragment = new Order_ping_Fragment();
        Order_shou_Fragment shou_fragment = new Order_shou_Fragment();

        fragments = new ArrayList<>();
        fragments.add(net_fragment);

        fragments.add(shou_fragment);
        fragments.add(ping_fragment);

        titles = new String[]{"全部", "降价", "筛选"};

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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}