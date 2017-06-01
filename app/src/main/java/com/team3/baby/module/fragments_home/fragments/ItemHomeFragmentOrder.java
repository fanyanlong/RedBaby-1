package com.team3.baby.module.fragments_home.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.team3.baby.R;
import com.team3.baby.module.fragments_home.adapter.MyRecyclerOrderAdapter;
import com.team3.baby.module.fragments_home.bean.OrderBean;
import com.team3.baby.module.fragments_home.url.Url;
import com.team3.baby.module.fragments_home.widget.ParallaxPtrFrameLayout;
import com.team3.baby.module.fragments_shopping.ShoppingCarActivity;
import com.team3.baby.utils.OkUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;


public class ItemHomeFragmentOrder extends Fragment {


    @BindView(R.id.rv_fragment_home_order)
    RecyclerView mRvFragmentHomeOrder;
    @BindView(R.id.ppf_fragment_home_order)
    ParallaxPtrFrameLayout mPpfFragmentHomeOrder;
    private String url;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mPpfFragmentHomeOrder.refreshComplete();
        }
    };
    private MyRecyclerOrderAdapter mAdapter;
    private ArrayList<OrderBean> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_item_order, container, false);
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        ButterKnife.bind(this, view);

        return view;
    }

    private void setListener() {
        mAdapter.setmOnItemClickListener(new MyRecyclerOrderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),ShoppingCarActivity.class);
                intent.putExtra("pid",mList.get(position).getProductId());
                intent.putExtra("position", Url.IMAGE_01+mList.get(position).getImagePath()+Url.IMAGE_02 );
                intent.putExtra("shopName", mList.get(position).getName());
                intent.putExtra("shopPrice", "¥"+mList.get(position).getPrice());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        mPpfFragmentHomeOrder.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mHandler.sendEmptyMessageDelayed(0, 2000);
            }
        });
        OkUtils.getExcute(Url.ORDER, null, new OkUtils.MyCallback() {
            @Override
            public void onSuccess(String result) {

                Gson gson=new Gson();
                Type type=new TypeToken<ArrayList<OrderBean>>(){}.getType();
                mList = gson.fromJson(result,type);

                //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
                mRvFragmentHomeOrder.setLayoutManager(gridLayoutManager);
                mAdapter = new MyRecyclerOrderAdapter(getActivity(), mList);
                mRvFragmentHomeOrder.setAdapter(mAdapter);
                setListener();
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
    public static ItemHomeFragmentOrder newInstance(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        ItemHomeFragmentOrder itemHomeFragmentOrder = new ItemHomeFragmentOrder();
        itemHomeFragmentOrder.setArguments(bundle);
        return itemHomeFragmentOrder;
    }
}
