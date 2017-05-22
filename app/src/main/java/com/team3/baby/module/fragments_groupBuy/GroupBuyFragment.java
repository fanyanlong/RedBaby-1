package com.team3.baby.module.fragments_groupBuy;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.team3.baby.R;
import com.team3.baby.base.BaseFragment;
import com.team3.baby.module.fragments_groupBuy.adapter.GroupBuyAdapter;
import com.team3.baby.module.fragments_groupBuy.bean.BoutiqueBean;
import com.team3.baby.module.fragments_groupBuy.fragment.TabFragment;
import com.team3.baby.module.fragments_groupBuy.url.UrlGroupBuy;
import com.team3.baby.utils.ImageUtils;
import com.team3.baby.utils.OkUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shizhuangzhaung on 2017/5/17.
 */

public class GroupBuyFragment extends BaseFragment {
    @BindView(R.id.imager_right_fragment_groupbuy)
    ImageView imagerRightFragmentGroupbuy;
    @BindView(R.id.tab_fragment_groupbuy)
    TabLayout tabFragmentGroupbuy;
    @BindView(R.id.viewpager_fragment_groupbuy)
    ViewPager viewpagerFragmentGroupbuy;
    @BindView(R.id.image_top_groupbuy)
    ImageView imageTopGroupbuy;
    private String http = "http:";
    private ArrayList<String> catesName, catesimager;

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
        OkUtils.getEnqueue(UrlGroupBuy.url, null, new OkUtils.MyCallback() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                BoutiqueBean boutiqueBean = gson.fromJson(result, BoutiqueBean.class);
                //头布局
                String imgUrl = boutiqueBean.getTopLogo().getImgUrl();
                ImageUtils.loadImageNormal(getActivity(), http + imgUrl, imageTopGroupbuy);
                //Tab接口
                List<BoutiqueBean.CatesBean> catesBeen = boutiqueBean.getCates();
                catesName = new ArrayList<String>();
                //catesimager = new ArrayList<String>();
                ArrayList<Fragment> fragmentlist = new ArrayList<Fragment>();

                //fragment接口
                String[] urlstr = new String[]{UrlGroupBuy.url, UrlGroupBuy.ONE, UrlGroupBuy.TWO,
                        UrlGroupBuy.THREE, UrlGroupBuy.FORM, UrlGroupBuy.FIVE, UrlGroupBuy.SIX,
                        UrlGroupBuy.SEVEN, UrlGroupBuy.EIGHT, UrlGroupBuy.NINE, UrlGroupBuy.TEN};
                ArrayList<String> urlList = new ArrayList<>();
                for (int i = 0; i < urlstr.length; i++) {
                    urlList.add(urlList.get(i));
                }

                for (int i = 0; i < catesBeen.size(); i++) {
                    catesName.add(catesBeen.get(i).getCateName());
                    //catesimager.add(catesBeen.get(i).getCateIconUrl());
                    //fragment数据
                    TabFragment tabFragment = new TabFragment(urlList.get(i));
                    fragmentlist.add(tabFragment);
                }

                GroupBuyAdapter adapter = new GroupBuyAdapter(getFragmentManager(), fragmentlist,
                        catesName);
                viewpagerFragmentGroupbuy.setAdapter(adapter);
                tabFragmentGroupbuy.setupWithViewPager(viewpagerFragmentGroupbuy);
                tabFragmentGroupbuy.setTabsFromPagerAdapter(adapter);
            }


            @Override
            public void onError(String errorMsg) {

            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.imager_right_fragment_groupbuy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imager_right_fragment_groupbuy:
                break;
        }
    }
}
