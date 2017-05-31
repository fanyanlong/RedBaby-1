package com.team3.baby.module.fragments_myebuy;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.team3.baby.R;
import com.team3.baby.module.fragments_myebuy.fragment_pingjia.PingFW_Fragment;
import com.team3.baby.module.fragments_myebuy.fragment_pingjia.PingSP_Fragment;
import com.team3.baby.module.fragments_myebuy.fragment_pingjia.PingYP_Fragment;
import com.team3.baby.module.fragments_myebuy.fragment_pingjia.PingZP_Fragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class Judge extends FragmentActivity {
    @BindView(R.id.iv_back_myebuy_activity)
    ImageView ivBackMyebuyActivity;
    private TabLayout tablatout;
    private FrameLayout framelayout_daipingjia_myebuy;
    private PingFW_Fragment pingFW_fragment;
    private PingSP_Fragment pingSP_fragment;
    private PingYP_Fragment pingYP_fragment;
    private PingZP_Fragment pingZP_fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private String[] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_daipingjia_mybey);
        findViewById(R.id.iv_back_pingjia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        pingFW_fragment = new PingFW_Fragment();
        pingSP_fragment = new PingSP_Fragment();
        pingYP_fragment = new PingYP_Fragment();
        pingZP_fragment = new PingZP_Fragment();
        fragments = new ArrayList<>();
        fragments.add(pingFW_fragment);
        fragments.add(pingSP_fragment);
        fragments.add(pingYP_fragment);
        fragments.add(pingZP_fragment);
        viewPager = (ViewPager) findViewById(R.id.vp_pingjia_myebuy);


        titles = new String[]{"待评商品", "待评服务", "待追评", "已评价"};
        tablatout = (TabLayout) findViewById(R.id.tab_daipingjia_myeuy);
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
