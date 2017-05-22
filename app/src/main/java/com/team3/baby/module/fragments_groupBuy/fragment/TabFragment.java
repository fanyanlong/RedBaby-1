package com.team3.baby.module.fragments_groupBuy.fragment;

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

import com.team3.baby.R;

/**
 * 类用途：
 * 作者：ShiZhuangZhuang
 * 时间：2017/5/17 21:58
 */

public class TabFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_recyclerview);
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
        RecAdapter recAdapter = new RecAdapter();
        recyclerView.setAdapter(recAdapter);
        //设置分隔线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager
                .VERTICAL, Color.RED, 5));
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
