package com.team3.baby.module.fragments_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.cundong.recyclerview.HeaderSpanSizeLookup;
import com.cundong.recyclerview.RecyclerViewUtils;
import com.google.gson.Gson;
import com.team3.baby.R;
import com.team3.baby.app.App;
import com.team3.baby.base.BaseFragment;
import com.team3.baby.module.fragments_shopping.indent_activity.IndentAffirm_settlementActivity;
import com.team3.baby.module.fragments_shopping.shopping_bean.Shopping_Bean;
import com.team3.baby.module.fragments_shopping.shoppingutils.Shop_Utils;
import com.team3.baby.utils.OkUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.dao.query.QueryBuilder;
import me.redbaby.greendao.Table_shopping;
import me.redbaby.greendao.Table_shoppingDao;

/**
 * @class describe
 * @anthor 郭彦君
 * @time 2017/5/19
 */

public class ShoppingFragment extends BaseFragment {
    @BindView(R.id.fragment_shopping_recyclerView)
    RecyclerView fragmentShoppingRecyclerView;
    @BindView(R.id.tv_goto_settlement)
    TextView tvGotoSettlement;
    @BindView(R.id.tv_compile_fragment_shopping)
    TextView tvCompileFragmentShopping;
    @BindView(R.id.lv_foot_foot)
    LinearLayout lvFootFoot;


    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;
    private SampleHeader sam;


    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_shopping, null);
        sam = new SampleHeader(mContext);
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
                Intent intent = new Intent(getActivity(), IndentAffirm_settlementActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
//gyj
    @Override
    public void onResume() {
        super.onResume();
        sam.AddListView(mContext);
        Table_shoppingDao tableShoppingDao = App.getApplication().getDaoSession().getTable_shoppingDao();
        QueryBuilder<Table_shopping> queryBuilder = tableShoppingDao.queryBuilder();
        List<Table_shopping> list = queryBuilder.list();
        Log.d("sssssssssssssss",list.size()+"");
        if (list.size() != 0) {
            tvCompileFragmentShopping.setText("编辑");
            lvFootFoot.setVisibility(View.VISIBLE);
        }

    }
}
