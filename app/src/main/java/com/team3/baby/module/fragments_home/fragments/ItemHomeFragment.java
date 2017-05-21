package com.team3.baby.module.fragments_home.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.team3.baby.R;
import com.team3.baby.base.BaseFragment;
import com.team3.baby.module.fragments_home.HomeFragment;
import com.team3.baby.module.fragments_home.adapter.MyRecyclerAdapter;
import com.team3.baby.module.fragments_home.widget.ParallaxPtrFrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类用途:
 * 作者:崔涵淞
 * 时间: 2017/5/18 9:55.
 */

public class ItemHomeFragment extends BaseFragment {

    @BindView(R.id.rv_fragment_home_recyclerview)
    RecyclerView mRvFragmentHomeRecyclerView;
    @BindView(R.id.ppf_fragment_home_recyclerview)
    ParallaxPtrFrameLayout mPpfFragmentHomeRecyclerView;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home_recyclerview, null);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("这是条目"+i);

        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);

        MyRecyclerAdapter adapter = new MyRecyclerAdapter(mContext,list);
       // mRvFragmentHomeRecyclerView.setAdapter(adapter);
       // mRvFragmentHomeRecyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
    public static ItemHomeFragment newInstance(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        ItemHomeFragment itemHomeFragment = new ItemHomeFragment();
        itemHomeFragment.setArguments(bundle);
        return itemHomeFragment;
    }
}
