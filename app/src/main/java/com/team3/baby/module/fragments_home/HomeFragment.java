package com.team3.baby.module.fragments_home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.team3.baby.R;
import com.team3.baby.module.fragments_home.adapter.HomeAdapter;
import com.team3.baby.module.fragments_home.bean.TitleBean;
import com.team3.baby.module.fragments_home.fragments.ItemHomeFragment;
import com.team3.baby.module.fragments_home.fragments.ItemHomeFragmentTitle;
import com.team3.baby.module.fragments_home.url.Url;
import com.team3.baby.utils.OkUtils;
import com.team3.baby.zxing.activity.CaptureActivity;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tianjieyu on 2017/5/17.
 */

public class HomeFragment extends Fragment {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        OkUtils.getEnqueue(Url.TITLE, null, new OkUtils.MyCallback() {
            @Override
            public void onSuccess(String result) {
                List<String> mTitleList = new ArrayList<>();//页卡标题集合

                List<Fragment> listFram = new ArrayList<Fragment>();
                List<String> listStr = new ArrayList<String>();
                Gson gson = new Gson();
                TitleBean titleBean = gson.fromJson(result, TitleBean.class);
                List<TitleBean.DataBean> data = titleBean.getData();
                ItemHomeFragment itemHomeFragment1 = new ItemHomeFragment().newInstance(Url.TITLE);
                listFram.add(itemHomeFragment1);
                listStr.add("上新");
                mInflater = LayoutInflater.from(getContext());
                for (int i = 0; i < data.get(0).getTag().size(); i++) {
                    ItemHomeFragmentTitle itemHomeFragmentTitle = new ItemHomeFragmentTitle().newInstance(data.get(0).getTag().get(i).getElementDesc().trim());
                    listFram.add(itemHomeFragmentTitle);
                    //listStr.add("上新");
                    listStr.add(data.get(0).getTag().get(i).getElementName());
                }

                mTabTopHomeFragment.setTabMode(TabLayout.MODE_SCROLLABLE);

                HomeAdapter adapter = new HomeAdapter(getFragmentManager(), listFram, listStr);
                mVpHomeFragment.setAdapter(adapter);//给ViewPager设置适配器
                mTabTopHomeFragment.setupWithViewPager(mVpHomeFragment);//将TabLayout和ViewPager关联起来。
                mTabTopHomeFragment.setTabsFromPagerAdapter(adapter);//给Tabs设置适配器

                mImageScanInclude.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getContext(), CaptureActivity.class));
                    }
                });
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
