package com.team3.baby.module.fragments_home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.team3.baby.base.BaseFragment;

import java.util.List;

/**
 * 类用途:
 * 作者:崔涵淞
 * 时间: 2017/5/17 19:29.
 */

public class HomeAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String> titleList;

    public HomeAdapter(FragmentManager fm,List<Fragment> list,List<String> titleList) {
        super(fm);
        this.list = list;
        this.titleList = titleList;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
