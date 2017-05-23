package com.team3.baby.module.fragments_classify.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.lzy.okgo.callback.StringCallback;
import com.team3.baby.R;
import com.team3.baby.module.fragments_classify.util.UrlClassify;
import com.team3.baby.utils.HttpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/21  21:34
 */

public class ClassifyGoodsListFragment extends AppCompatActivity {
    @BindView(R.id.iv_back_classify_goodslist)
    ImageView mIvBackClassifyGoodslist;
    @BindView(R.id.btn_screen_classify_goodslist)
    Button mBtnScreenClassifyGoodslist;
    @BindView(R.id.btn_compositive_classify_goodslist)
    Button mBtnCompositiveClassifyGoodslist;
    @BindView(R.id.btn_sales_classify_goodslist)
    Button mBtnSalesClassifyGoodslist;
    @BindView(R.id.chk_service_classify_goodslist)
    CheckBox mChkServiceClassifyGoodslist;
    @BindView(R.id.chk_promotion_classify_goodslist)
    CheckBox mChkPromotionClassifyGoodslist;
    @BindView(R.id.btn_01_classify_goodslist)
    Button mBtn01ClassifyGoodslist;
    @BindView(R.id.btn_02_classify_goodslist)
    Button mBtn02ClassifyGoodslist;
    @BindView(R.id.btn_03_classify_goodslist)
    Button mBtn03ClassifyGoodslist;
    @BindView(R.id.btn_04_classify_goodslist)
    Button mBtn04ClassifyGoodslist;
    private String mPcci;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_classify_goods_list);
        ButterKnife.bind(this);
        //
        initData();
        //
        getServerData();
    }

    private void getServerData() {
        HttpUtils.getData(UrlClassify.ADD_CLASSIFY, new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {

            }
        });
    }

    private void initData() {
        Intent intent = getIntent();
        mPcci = intent.getStringExtra("pcci");
    }

    @OnClick({R.id.iv_back_classify_goodslist, R.id.btn_screen_classify_goodslist, R.id.btn_compositive_classify_goodslist, R.id.btn_sales_classify_goodslist, R.id.chk_service_classify_goodslist, R.id.chk_promotion_classify_goodslist, R.id.btn_01_classify_goodslist, R.id.btn_02_classify_goodslist, R.id.btn_03_classify_goodslist, R.id.btn_04_classify_goodslist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_classify_goodslist:
                break;
            case R.id.btn_screen_classify_goodslist:
                break;
            case R.id.btn_compositive_classify_goodslist:
                break;
            case R.id.btn_sales_classify_goodslist:
                break;
            case R.id.chk_service_classify_goodslist:
                break;
            case R.id.chk_promotion_classify_goodslist:
                break;
            case R.id.btn_01_classify_goodslist:
                break;
            case R.id.btn_02_classify_goodslist:
                break;
            case R.id.btn_03_classify_goodslist:
                break;
            case R.id.btn_04_classify_goodslist:
                break;
        }
    }
}
