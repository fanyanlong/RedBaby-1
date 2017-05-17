package com.team3.baby.module.fragments_groupBuy;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.team3.baby.R;
import com.team3.baby.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shizhuangzhaung on 2017/5/17.
 */

public class GroupBuyFragment extends BaseFragment {

    @BindView(R.id.imager_left_fragment_groupbuy)
    ImageView imagerLeftFragmentGroupbuy;
    @BindView(R.id.imager_right_fragment_groupbuy)
    ImageView imagerRightFragmentGroupbuy;
    @BindView(R.id.tab_fragment_groupbuy)
    TabLayout tabFragmentGroupbuy;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_groupbuy, null);
        return view;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        tabFragmentGroupbuy.addTab(tabFragmentGroupbuy.newTab().setText("Tab 1").setIcon(R.mipmap
                .ic_launcher));
        tabFragmentGroupbuy.addTab(tabFragmentGroupbuy.newTab().setText("Tab 2").setIcon(R.mipmap
                .ic_launcher));
        tabFragmentGroupbuy.addTab(tabFragmentGroupbuy.newTab().setText("Tab 3").setIcon(R.mipmap
                .ic_launcher));
        tabFragmentGroupbuy.addTab(tabFragmentGroupbuy.newTab().setText("Tab 4").setIcon(R.mipmap
                .ic_launcher));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.imager_left_fragment_groupbuy, R.id.imager_right_fragment_groupbuy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imager_left_fragment_groupbuy:

                break;
            case R.id.imager_right_fragment_groupbuy:
                break;
        }
    }
}
