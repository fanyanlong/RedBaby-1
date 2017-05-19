package com.team3.baby.module.fragments_classify.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team3.baby.R;
import com.team3.baby.base.BaseFragment;
import com.team3.baby.module.fragments_classify.adapter.RightRvAdapter;
import com.team3.baby.module.fragments_classify.bean.RightClassifyBean;

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

public class RightClassifyFragment extends BaseFragment {
    @BindView(R.id.recycler_right_classify)
    RecyclerView mRecyclerRightClassify;
    Unbinder unbinder;
    private List<RightClassifyBean> mList = new ArrayList<>();

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_right_classify, null);
        return view;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        for (int i = 0; i < 30; i++) {
            RightClassifyBean rightClassifyBean = new RightClassifyBean();
            rightClassifyBean.setText("第" + 0 + "个");
            mList.add(rightClassifyBean);
            initRv(mList);
        }
        initRv(mList);
        LeftClassifyFragment leftClassifyFragment = (LeftClassifyFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fl_01_classify);
        leftClassifyFragment.setTraceInfo(new LeftClassifyFragment.TranceInfo() {
            @Override
            public void onTranceInfo(String info) {
                mList.clear();
                for (int i = 0; i < 30; i++) {
                    RightClassifyBean rightClassifyBean = new RightClassifyBean();
                    rightClassifyBean.setText("第" + info + "个");
                    mList.add(rightClassifyBean);
                    initRv(mList);
                }
            }
        });

    }

    private void initRv(List<RightClassifyBean> list) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
        mRecyclerRightClassify.setLayoutManager(gridLayoutManager);
        RightRvAdapter adapter = new RightRvAdapter(list, mContext);
        mRecyclerRightClassify.setAdapter(adapter);
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
