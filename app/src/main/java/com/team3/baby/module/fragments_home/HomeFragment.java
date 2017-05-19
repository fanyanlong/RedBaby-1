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


    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4, view5,view6,view7,view8;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
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
        mInflater = LayoutInflater.from(mContext);
        view1 = mInflater.inflate(R.layout.fragment_home_recyclerview, null);
        view2 = mInflater.inflate(R.layout.fragment_home_recyclerview, null);
        view3 = mInflater.inflate(R.layout.fragment_home_recyclerview, null);
        view4 = mInflater.inflate(R.layout.fragment_home_recyclerview, null);
        view5 = mInflater.inflate(R.layout.fragment_home_recyclerview, null);
        view6 = mInflater.inflate(R.layout.fragment_home_recyclerview, null);
        view7 = mInflater.inflate(R.layout.fragment_home_recyclerview, null);
        view8 = mInflater.inflate(R.layout.fragment_home_recyclerview, null);

        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);
        mViewList.add(view5);
        mViewList.add(view6);
        mViewList.add(view7);
        mViewList.add(view8);

//添加页卡标题
        mTitleList.add("No:1");
        mTitleList.add("No:2");
        mTitleList.add("No:3");
        mTitleList.add("No:4");
        mTitleList.add("No:5");
        mTitleList.add("No:6");
        mTitleList.add("No:7");
        mTitleList.add("No:8");

        mTabTopHomeFragment.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText(mTitleList.get(0)));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText(mTitleList.get(1)));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText(mTitleList.get(2)));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText(mTitleList.get(3)));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText(mTitleList.get(4)));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText(mTitleList.get(5)));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText(mTitleList.get(6)));
        mTabTopHomeFragment.addTab(mTabTopHomeFragment.newTab().setText(mTitleList.get(7)));

        HomeAdapter mAdapter = new HomeAdapter(mViewList,mTitleList);
        mVpHomeFragment.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabTopHomeFragment.setupWithViewPager(mVpHomeFragment);//将TabLayout和ViewPager关联起来。
        mTabTopHomeFragment.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
