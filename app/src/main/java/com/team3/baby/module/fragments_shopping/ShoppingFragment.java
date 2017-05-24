package com.team3.baby.module.fragments_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.cundong.recyclerview.HeaderSpanSizeLookup;
import com.cundong.recyclerview.RecyclerViewUtils;
import com.google.gson.Gson;
import com.team3.baby.R;
import com.team3.baby.base.BaseFragment;
import com.team3.baby.module.fragments_shopping.indent_activity.IndentAffirmActivity;
import com.team3.baby.module.fragments_shopping.shopping_bean.Shopping_Bean;
import com.team3.baby.module.fragments_shopping.shoppingutils.Shop_Utils;
import com.team3.baby.utils.OkUtils;

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
    @BindView(R.id.tv_goto_settlement)
    TextView tvGotoSettlement;


    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;
    private SampleHeader sam;


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

        OkUtils.getEnqueue(Shop_Utils.BBNF, null, new OkUtils.MyCallback() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Shopping_Bean shopping_bean = gson.fromJson(result, Shopping_Bean.class);
                ArrayList<Shopping_Bean.GoodsBean> goods = (ArrayList<Shopping_Bean.GoodsBean>) shopping_bean.getGoods();
                Fragment_shopping_RecycleAdapter dataAdapter = new Fragment_shopping_RecycleAdapter(mContext, goods, fragmentShoppingRecyclerView);

                mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(dataAdapter);
                fragmentShoppingRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);

                GridLayoutManager manager = new GridLayoutManager(mContext, 2);
                manager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter) fragmentShoppingRecyclerView.getAdapter(), manager.getSpanCount()));
                fragmentShoppingRecyclerView.setLayoutManager(manager);

                sam = new SampleHeader(mContext);
                RecyclerViewUtils.setHeaderView(fragmentShoppingRecyclerView, sam);
                sam.setOnLinsener(mContext);

            }

            @Override
            public void onError(String errorMsg) {

            }
        });

        tvGotoSettlement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "aaa", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), IndentAffirmActivity.class);
                startActivity(intent);
            }
        });


        //填充头布局

//        View headView = View.inflate(mContext, R.layout.fragment_shopping_hearder_layout, null);
//        Button btn_goto_gg = (Button) headView.findViewById(R.id.btn_goto_gg);
//        btn_goto_gg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "去逛逛", Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


}
