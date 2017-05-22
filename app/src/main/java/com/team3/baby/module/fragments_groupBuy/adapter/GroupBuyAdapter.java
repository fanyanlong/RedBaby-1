package com.team3.baby.module.fragments_groupBuy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 类用途：
 * 作者：ShiZhuangZhuang
 * 时间：2017/5/17 21:15
 */

public class GroupBuyAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> strings;
    private ArrayList<String> catesName;

    public GroupBuyAdapter(FragmentManager fm, ArrayList<Fragment> strings, ArrayList<String>
            catesName) {
        super(fm);
        this.strings = strings;
        this.catesName = catesName;
    }

    @Override
    public Fragment getItem(int position) {
        return strings.get(position);
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return catesName.get(position);
    }
}
