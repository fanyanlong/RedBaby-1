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
import com.team3.baby.module.fragments_home.adapter.MyRecyclerAdapter;
import com.team3.baby.module.fragments_home.bean.TitleBean;
import com.team3.baby.module.fragments_home.url.Url;
import com.team3.baby.module.fragments_home.widget.ParallaxPtrFrameLayout;
import com.team3.baby.utils.OkUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * 类用途:
 * 作者:崔涵淞
 * 时间: 2017/5/18 9:55.
 */

public class ItemHomeFragment extends Fragment {

    @BindView(R.id.rv_fragment_home_recyclerview)
    RecyclerView mRvFragmentHomeRecyclerView;
    @BindView(R.id.ppf_fragment_home_recyclerview)
    ParallaxPtrFrameLayout mPpfFragmentHomeRecyclerView;
    private String url;

private Handler mHandler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        mPpfFragmentHomeRecyclerView.refreshComplete();
    }
};

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        mPpfFragmentHomeRecyclerView.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mHandler.sendEmptyMessageDelayed(0,2000);
            }
        });
        OkUtils.getExcute(Url.TITLE, null, new OkUtils.MyCallback() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                TitleBean titleBean = gson.fromJson(result, TitleBean.class);
                List<TitleBean.DataBean> list = titleBean.getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                mRvFragmentHomeRecyclerView.setLayoutManager(linearLayoutManager);
                MyRecyclerAdapter adapter = new MyRecyclerAdapter(getContext(),list);
                mRvFragmentHomeRecyclerView.setAdapter(adapter);

            }

            @Override
            public void onError(String errorMsg) {

            }
        });
       /* HttpUtils.getData(Url.TITLE, new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {

            }
        });*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_home_recyclerview, null);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        return view;
    }
    public static ItemHomeFragment newInstance(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        ItemHomeFragment itemHomeFragment = new ItemHomeFragment();
        itemHomeFragment.setArguments(bundle);
        return itemHomeFragment;
    }
}
