package com.team3.baby.module.fragments_shopping;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.cundong.recyclerview.HeaderSpanSizeLookup;
import com.cundong.recyclerview.RecyclerViewUtils;
import com.team3.baby.R;
import com.team3.baby.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
* @class describe
* @anthor 郭彦君
* @time 2017/5/19 
*/

public class ShoppingFragment extends BaseFragment {
    @BindView(R.id.fragment_shopping_recyclerView)
    RecyclerView fragmentShoppingRecyclerView;
    @BindView(R.id.tv_compile_fragment_shopping)
    TextView tvCompileFragmentShopping;




    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;


    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_shopping, null);
        return view;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        //init data
        ArrayList<String> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add("item" + i);
        }

      Fragment_shopping_RecycleAdapter dataAdapter = new Fragment_shopping_RecycleAdapter(getActivity(),dataList,fragmentShoppingRecyclerView);

        mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(dataAdapter);
        fragmentShoppingRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        manager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter) fragmentShoppingRecyclerView.getAdapter(), manager.getSpanCount()));
        fragmentShoppingRecyclerView.setLayoutManager(manager);

        RecyclerViewUtils.setHeaderView(fragmentShoppingRecyclerView, new SampleHeader(getActivity()));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


}
