package com.team3.baby.module.fragments_home.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.team3.baby.R;
import com.team3.baby.module.fragments_home.adapter.MyRecyclerTitleAdapter;
import com.team3.baby.module.fragments_home.bean.HomeBean;
import com.team3.baby.module.fragments_home.url.Url;
import com.team3.baby.module.fragments_home.widget.ParallaxPtrFrameLayout;
import com.team3.baby.utils.OkUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * 类用途
 * 作者:崔涵淞
 * 时间: 2017/5/23 21:27.
 */

public class ItemHomeFragmentTitle extends Fragment {
    @BindView(R.id.rv_fragment_home_rectcler)
    RecyclerView mRvFragmentHomeRectcler;
    @BindView(R.id.ppf_fragment_home_top)
    ParallaxPtrFrameLayout mPpfFragmentHomeTop;
    String url;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mPpfFragmentHomeTop.refreshComplete();
        }
    };




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_home_title, null);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        mPpfFragmentHomeTop.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mHandler.sendEmptyMessageDelayed(0, 2000);
            }
        });
     /*   HttpUtils.getData(Url.TITLE, new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Gson gson = new Gson();
                TitleBean titleBean = gson.fromJson(s, TitleBean.class);
                List<TitleBean.DataBean> list = titleBean.getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                mRvFragmentHomeRectcler.setLayoutManager(linearLayoutManager);
                MyRecyclerTitleAdapter adapter = new MyRecyclerTitleAdapter(getContext(),list);
                mRvFragmentHomeRectcler.setAdapter(adapter);
            }
        });*/
        OkUtils.getExcute(Url.HTTP+url, null, new OkUtils.MyCallback() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                HomeBean titleBean = gson.fromJson(result, HomeBean.class);
                List<HomeBean.DataBean> list = titleBean.getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

                mRvFragmentHomeRectcler.setLayoutManager(linearLayoutManager);
                MyRecyclerTitleAdapter adapter = new MyRecyclerTitleAdapter(getActivity(),list);
                mRvFragmentHomeRectcler.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
    public static ItemHomeFragmentTitle newInstance(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        ItemHomeFragmentTitle itemHomeFragmentTitle = new ItemHomeFragmentTitle();
        itemHomeFragmentTitle.setArguments(bundle);
        return itemHomeFragmentTitle;
    }
}
