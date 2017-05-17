package com.team3.baby.module.fragments_classify.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team3.baby.R;
import com.team3.baby.base.BaseFragment;
import com.team3.baby.module.fragments_classify.adapter.LeftRvAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/17  16:23
 */

public class LeftClassifyFragment extends BaseFragment {
    @BindView(R.id.recycler_left_classify)
    RecyclerView mRecyclerLeftClassify;
    Unbinder unbinder;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_left_classify, null);
        return view;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("第" + i + "个");
        }
        initRecyclerView(list);
    }

    private void initRecyclerView(List<String> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerLeftClassify.setLayoutManager(layoutManager);
        LeftRvAdapter adapter = new LeftRvAdapter(list, mContext);
        mRecyclerLeftClassify.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
