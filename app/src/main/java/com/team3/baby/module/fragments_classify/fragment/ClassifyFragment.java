package com.team3.baby.module.fragments_classify.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.team3.baby.R;
import com.team3.baby.base.BaseFragment;

/**
 * 类的用途：
 *
 * @author jinhu
 * @date 2017/5/17 16:08
 */


public class ClassifyFragment extends BaseFragment {
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_classify, null);
        return view;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        LeftClassifyFragment leftClassifyFragment = new LeftClassifyFragment();
        RightClassifyFragment rightClassifyFragment = new RightClassifyFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fl_01_classify, leftClassifyFragment);
        transaction.add(R.id.fl_02_classify, rightClassifyFragment);
        transaction.commit();
    }
}
