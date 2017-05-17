package com.team3.baby.module.fragments_home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.team3.baby.R;
import com.team3.baby.module.fragments_home.adapter.HomeAdapter;
import com.team3.baby.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tianjieyu on 2017/5/17.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.tab_top_home_fragment)
    TabLayout mTabTopHomeFragment;
    @BindView(R.id.vp_home_fragment)
    ViewPager mVpHomeFragment;
    @BindView(R.id.image_scan_include)
    ImageView mImageScanInclude;
    @BindView(R.id.linear_inquire_include)
    LinearLayout mLinearInquireInclude;
    @BindView(R.id.image_mes_include)
    ImageView mImageMesInclude;


    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        return view;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText("Tab 1"));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText("Tab 2"));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText("Tab 3"));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText("Tab 4"));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText("Tab 5"));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText("Tab 6"));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText("Tab 7"));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText("Tab 8"));
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
