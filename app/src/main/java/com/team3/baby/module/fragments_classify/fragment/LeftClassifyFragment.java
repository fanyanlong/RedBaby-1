package com.team3.baby.module.fragments_classify.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.team3.baby.R;
import com.team3.baby.base.BaseFragment;
import com.team3.baby.module.fragments_classify.adapter.LeftRvAdapter;
import com.team3.baby.module.fragments_classify.bean.LeftClassifyBean;
import com.team3.baby.module.fragments_classify.util.RecyclerViewDivider;

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
    private LeftRvAdapter mAdapter;
    private List<LeftClassifyBean> mList;
    private TranceInfo mTranceInfo;

    @Override
    protected View initView() {
        final View view = View.inflate(mContext, R.layout.fragment_left_classify, null);
        return view;
    }

    @Override
    protected void setListener() {
        mAdapter.setmOnItemClickListener(new LeftRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(mContext, "" + position, Toast.LENGTH_SHORT).show();
                mTranceInfo.onTranceInfo(position + "");
            }
        });
    }

    @Override
    protected void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LeftClassifyBean bean = new LeftClassifyBean();
            bean.setText("第" + i + "个");
            mList.add(bean);
        }
        initRecyclerView(mList);
    }

    private void initRecyclerView(List<LeftClassifyBean> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerLeftClassify.setLayoutManager(layoutManager);
        //分割线
        mRecyclerLeftClassify.addItemDecoration(new RecyclerViewDivider(mContext, layoutManager.HORIZONTAL));
        mAdapter = new LeftRvAdapter(list, mContext);
        mRecyclerLeftClassify.setAdapter(mAdapter);

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

    //传值接口
    public interface TranceInfo {
        void onTranceInfo(String info);
    }

    public void setTraceInfo(TranceInfo tranceInfo) {
        this.mTranceInfo = tranceInfo;
    }
}
