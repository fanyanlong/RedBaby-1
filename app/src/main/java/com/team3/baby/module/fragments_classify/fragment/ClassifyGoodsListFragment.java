package com.team3.baby.module.fragments_classify.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lzy.okgo.callback.StringCallback;
import com.team3.baby.R;
import com.team3.baby.module.fragments_classify.adapter.GoodsListAdapter;
import com.team3.baby.module.fragments_classify.bean.GoodsListBean;
import com.team3.baby.module.fragments_classify.util.RecyclerViewDivider;
import com.team3.baby.module.fragments_classify.util.UrlClassify;
import com.team3.baby.module.fragments_shopping.ShoppingCarActivity;
import com.team3.baby.module.fragments_shopping.shoppingutils.Shop_Utils;
import com.team3.baby.module.main_activity.v.MainActivity;
import com.team3.baby.utils.GsonUtils;
import com.team3.baby.utils.HttpUtils;

import java.util.List;

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
    @BindView(R.id.tv_screen_classify_goodslist)
    TextView mTvScreenClassifyGoodslist;
    @BindView(R.id.tv_compositive_classify_goodslist)
    TextView mTvCompositiveClassifyGoodslist;
    @BindView(R.id.tv_sales_classify_goodslist)
    TextView mTvSalesClassifyGoodslist;
    @BindView(R.id.chk_service_classify_goodslist)
    CheckBox mChkServiceClassifyGoodslist;
    @BindView(R.id.chk_promotion_classify_goodslist)
    CheckBox mChkPromotionClassifyGoodslist;
    @BindView(R.id.tv_01_classify_goodslist)
    TextView mTv01ClassifyGoodslist;
    @BindView(R.id.tv_02_classify_goodslist)
    TextView mTv02ClassifyGoodslist;
    @BindView(R.id.tv_03_classify_goodslist)
    TextView mTv03ClassifyGoodslist;
    @BindView(R.id.tv_04_classify_goodslist)
    TextView mTv04ClassifyGoodslist;
    @BindView(R.id.rv_classify_goodslist)
    RecyclerView mRvClassifyGoodslist;
    private SlidingMenu mMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_classify_goods_list);
        ButterKnife.bind(this);
        //侧滑
        toSlideingMenu();
        //
        initData();
        //
        getServerData();
    }

    private void getServerData() {

        HttpUtils.getData(UrlClassify.BBNF, new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                GoodsListBean goodsListBean = GsonUtils.gsonToBean(s, GoodsListBean.class);
                List<GoodsListBean.GoodsBean> goods = goodsListBean.getGoods();
                initRv(goods);

            }
        });
    }

    private void initRv(List<GoodsListBean.GoodsBean> goods) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvClassifyGoodslist.setLayoutManager(layoutManager);
        GoodsListAdapter adapter = new GoodsListAdapter(goods, this);
        mRvClassifyGoodslist.setAdapter(adapter);
        //分割线
        mRvClassifyGoodslist.addItemDecoration(new RecyclerViewDivider(this, layoutManager.HORIZONTAL));
        //条目点击
        setListener(adapter, goods);
    }

    private void setListener(GoodsListAdapter adapter, final List<GoodsListBean.GoodsBean> goods) {
        adapter.setmOnItemClickListener(new GoodsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String image = Shop_Utils.getPicUrl().get(position);
                String auxdescription = goods.get(position).getAuxdescription();
                String price = goods.get(position).getPrice();
                //添加数据库
//                addNote(image, auxdescription, price);
                //
                Intent intent = new Intent(ClassifyGoodsListFragment.this, ShoppingCarActivity.class);
                intent.putExtra("position", image);
                intent.putExtra("shopName", auxdescription);
                intent.putExtra("shopPrice", price);
                startActivity(intent);

            }
        });
    }

    //添加数据库
    private void addNote(String image, String auxdescription, String price) {
        float parseFloat = Float.parseFloat(price);
        // 插入操作，简单到只要你创建一个 Java 对象
//        Table_shopping table_shopping = new Table_shopping(1L, 1, auxdescription, parseFloat, "11", image, 1, 1);
//        App.getApplication().getDaoSession().getTable_shoppingDao().insert(table_shopping);
//        getNoteDao().insert(note);
//        cursor.requery();
    }

    private void initData() {
       /* Intent intent = getIntent();
        String pcci = intent.getStringExtra("pcci");
        mUrl = UrlClassify.ADD_BASE_RIGHT_01 + pcci + UrlClassify.ADD_BASE_RIGHT_02;*/
    }

    @OnClick({R.id.iv_back_classify_goodslist, R.id.tv_screen_classify_goodslist, R.id.tv_compositive_classify_goodslist, R.id.tv_sales_classify_goodslist, R.id.chk_service_classify_goodslist, R.id.chk_promotion_classify_goodslist, R.id.tv_01_classify_goodslist, R.id.tv_02_classify_goodslist, R.id.tv_03_classify_goodslist, R.id.tv_04_classify_goodslist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_classify_goodslist:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_screen_classify_goodslist:
                //侧滑
                mMenu.toggle();
                break;
            case R.id.tv_compositive_classify_goodslist:
                break;
            case R.id.tv_sales_classify_goodslist:
                break;
            case R.id.chk_service_classify_goodslist:
                break;
            case R.id.chk_promotion_classify_goodslist:
                break;
            case R.id.tv_01_classify_goodslist:
                break;
            case R.id.tv_02_classify_goodslist:
                break;
            case R.id.tv_03_classify_goodslist:
                break;
            case R.id.tv_04_classify_goodslist:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //侧滑
    public void toSlideingMenu() {
        mMenu = new SlidingMenu(this);
        //NewMainActivity 此UI类，
        mMenu.attachToActivity(ClassifyGoodsListFragment.this, SlidingMenu.SLIDING_CONTENT);
        mMenu.setMenu(R.layout.slidingmenu_classify);//侧滑页实际布局
//        initViewSlidingMenu(mMenu);//查找布局内控件的方法
        // 设置可以左右滑动的菜单
        mMenu.setMode(SlidingMenu.RIGHT);
        // 设置滑动菜单视图的宽度
        int widthPixels = this.getResources().getDisplayMetrics().widthPixels;
        mMenu.setBehindWidth(widthPixels / 7 * 6);
        // 设置渐入渐出效果的值
        mMenu.setFadeDegree(0.35f);
        // 设置触摸屏幕的模式,这里设置为全屏
        mMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置下方视图的在滚动时的缩放比例
        mMenu.setBehindScrollScale(0.0f);
        //判断侧滑页是否是打开的
        if (!mMenu.isSecondaryMenuShowing()) {
            mMenu.showContent();
        } else {
            mMenu.showSecondaryMenu();
        }
    }
}
