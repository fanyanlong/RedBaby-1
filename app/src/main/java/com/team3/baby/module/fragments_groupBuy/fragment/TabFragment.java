package com.team3.baby.module.fragments_groupBuy.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team3.baby.R;
import com.team3.baby.module.fragments_groupBuy.bean.BoutiqueBean;
import com.team3.baby.utils.GsonUtils;
import com.team3.baby.utils.OkUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类用途：
 * 作者：ShiZhuangZhuang
 * 时间：2017/5/17 21:58
 */

@SuppressLint("ValidFragment")
public class TabFragment extends Fragment {
    @BindView(R.id.banner)
    Banner banner;
    private RecyclerView recyclerView;
    private String url;
    private String http = "http:";

    public TabFragment(String url) {
        this.url = url;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_recyclerview);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置固定大小
        recyclerView.setHasFixedSize(true);
        //设置Adapter
        OkUtils.getEnqueue(url, null, new OkUtils.MyCallback() {
            @Override
            public void onSuccess(String result) {
                BoutiqueBean toBean = GsonUtils.gsonToBean(result, BoutiqueBean.class);
         /*       //横向滑动
                List<BoutiqueBean.Enrolls1Bean.ListBeanX> beanXes = toBean.getEnrolls_1()
                        .getList();
                //RecView
                List<BoutiqueBean.CatesBean> catesList = toBean.getCates();*/

                //轮播
                List<BoutiqueBean.AdsBean> adsList = toBean.getAds();
                ArrayList<String> imagerlist = new ArrayList<String>();
                //Log.e("---------", adsList.size()+"");
                for (int i = 0; i < adsList.size(); i++) {
                    imagerlist.add(http + adsList.get(i).getImgUrl());
                }
                Log.e("---------", imagerlist.toString());
                banner.setImages(imagerlist).setImageLoader(new GlideImageLoader()).start();
                RecAdapter recAdapter = new RecAdapter();
                recyclerView.setAdapter(recAdapter);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

        //设置分隔线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager
                .VERTICAL, Color.RED, 5));
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
