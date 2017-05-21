package com.team3.baby.module.fragments_classify.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.team3.baby.R;
import com.team3.baby.base.BaseFragment;
import com.team3.baby.module.fragments_classify.adapter.LeftRvAdapter;
import com.team3.baby.module.fragments_classify.adapter.RightRvAdapter;
import com.team3.baby.module.fragments_classify.bean.LeftClassifyBean;
import com.team3.baby.module.fragments_classify.bean.RightClassifyBean;
import com.team3.baby.module.fragments_classify.util.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类的用途：
 *
 * @author jinhu
 * @date 2017/5/17 16:08
 */


public class ClassifyFragment extends BaseFragment {

    @BindView(R.id.recycler_left_classify)
    RecyclerView mRecyclerLeftClassify;
    @BindView(R.id.recycler_right_classify)
    RecyclerView mRecyclerRightClassify;
    Unbinder unbinder;
    private LeftRvAdapter mAdapter;
    private List<LeftClassifyBean> mLeftList;
    private List<RightClassifyBean> mRightList = new ArrayList<>();
    private TranceInfo mTranceInfo;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_classify, null);
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
            return view;
        }
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
        mLeftList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LeftClassifyBean bean = new LeftClassifyBean();
            bean.setText("第" + i + "个");
            mLeftList.add(bean);
        }
        initLeftRecyclerView(mLeftList);
        //
        for (int i = 0; i < 30; i++) {
            RightClassifyBean rightClassifyBean = new RightClassifyBean();
            rightClassifyBean.setText("第" + 0 + "个");
            mRightList.add(rightClassifyBean);
            initRightRv(mRightList);
        }
        initRightRv(mRightList);
        setTraceInfo(new TranceInfo() {
            @Override
            public void onTranceInfo(String info) {
                mRightList.clear();
                for (int i = 0; i < 30; i++) {
                    RightClassifyBean rightClassifyBean = new RightClassifyBean();
                    rightClassifyBean.setText("第" + info + "个");
                    mRightList.add(rightClassifyBean);
                    initRightRv(mRightList);
                }
            }
        });
    }

    private void initRightRv(List<RightClassifyBean> list) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
        //显示标题栏的grid
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0 || position == 10 || position == 17) {
                    return 3;
                } else {
                    return 1;
                }
            }
        });
        mRecyclerRightClassify.setLayoutManager(gridLayoutManager);
        RightRvAdapter adapter = new RightRvAdapter(list, mContext);
        mRecyclerRightClassify.setAdapter(adapter);
    }

    private void initLeftRecyclerView(List<LeftClassifyBean> list) {
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
