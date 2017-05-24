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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lzy.okgo.callback.StringCallback;
import com.team3.baby.R;
import com.team3.baby.module.fragments_groupBuy.adapter.TabAdapter;
import com.team3.baby.module.fragments_groupBuy.bean.TabBean;
import com.team3.baby.module.fragments_groupBuy.utils.DividerItemDecoration;
import com.team3.baby.utils.GsonUtils;
import com.team3.baby.utils.HttpUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 类用途：
 * 作者：ShiZhuangZhuang
 * 时间：2017/5/24 16:44
 */

@SuppressLint("ValidFragment")
public class TabFragments extends Fragment {
    @BindView(R.id.recycler_tabfragments_recyclerview)
    RecyclerView recyclerview;
    private String url;

    public TabFragments(String url) {
        this.url = url;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragments_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //设置布局管理器
        recyclerview.setLayoutManager(layoutManager);
        //设置为横向布局
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置固定大小
        recyclerview.setHasFixedSize(true);
        //设置分隔线
        recyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager
                .VERTICAL));
        //设置增加或删除条目的动画
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        HttpUtils.getData(url, new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                if (s != null) {
                    TabBean tabBean = GsonUtils.gsonToBean(s, TabBean.class);
                    List<TabBean.EnrollsBean.ListBean> listBeen = tabBean.getEnrolls().getList();
                    TabAdapter adapter = new TabAdapter(getActivity(), listBeen);
                    recyclerview.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "网络被外星人带走了~", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
