package com.team3.baby.module.fragments_groupBuy.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.lzy.okgo.callback.StringCallback;
import com.team3.baby.R;
import com.team3.baby.module.fragments_groupBuy.adapter.HorizontalAdapter;
import com.team3.baby.module.fragments_groupBuy.adapter.RecAdapter;
import com.team3.baby.module.fragments_groupBuy.utils.RecyclerItemClickListener;
import com.team3.baby.module.fragments_groupBuy.bean.BoutiqueBean;
import com.team3.baby.module.fragments_groupBuy.utils.DividerItemDecoration;
import com.team3.baby.module.fragments_groupBuy.utils.GlideImageLoader;
import com.team3.baby.module.fragments_groupBuy.utils.WebViewUtils;
import com.team3.baby.module.fragments_shopping.ShoppingCarActivity;
import com.team3.baby.utils.GsonUtils;
import com.team3.baby.utils.HttpUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 类用途：
 * 作者：ShiZhuangZhuang
 * 时间：2017/5/17 21:58
 */
@SuppressLint("ValidFragment")
public class TabFragment extends Fragment {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.imager_tabfragment)
    ImageView imagerTabfragment;
    @BindView(R.id.recycler_tabfragment)
    RecyclerView recyclerTabfragment;
    @BindView(R.id.recycler_fragment_recyclerview)
    RecyclerView recyclerview;
    private String url;
    private String http = "http:";
    private List<BoutiqueBean.Enrolls1Bean.ListBeanX> listBeanXes;
    private List<BoutiqueBean.EnrollsBean.ListBean> enrollsList;
    public TabFragment(String url) {
        this.url = url;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //横向滑动
        getGorizontalrec();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //设置布局管理器
        recyclerview.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置固定大小
        recyclerview.setHasFixedSize(true);
        //设置分隔线
        recyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager
                .VERTICAL, 10, ContextCompat.getColor(getActivity(), R.color.danhui)));

        //设置增加或删除条目的动画
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        //设置Adapter
        HttpUtils.getData(url, new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                if (s != null) {
                    BoutiqueBean toBean = GsonUtils.gsonToBean(s, BoutiqueBean.class);
                    //轮播
                    final List<BoutiqueBean.AdsBean> adsList = toBean.getAds();
                    ArrayList<String> imagerlist = new ArrayList<String>();
                    for (int i = 0; i < adsList.size(); i++) {
                        imagerlist.add(http + adsList.get(i).getImgUrl());
                    }
                    //设置banner样式
                    banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
                    //设置图片加载器
                    banner.setImageLoader(new GlideImageLoader());
                    //设置图片集合
                    banner.setImages(imagerlist);
                    //设置banner动画效果
                    banner.setBannerAnimation(Transformer.RotateDown);
                    //设置自动轮播，默认为true
                    banner.isAutoPlay(true);
                    //设置轮播时间
                    banner.setDelayTime(1500);
                    //设置指示器位置（当banner模式中有指示器时）
                    banner.setIndicatorGravity(BannerConfig.CENTER);
                    //banner设置方法全部调用完毕时最后调用
                    banner.start();
                    banner.setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int position) {
                            Intent intent = new Intent(getActivity(), WebViewUtils.class);
                            intent.putExtra("url", http+adsList.get(position).getTargetUrl());
                            startActivity(intent);
                        }
                    });
                    //RecView
                    enrollsList = toBean.getEnrolls()
                            .getList();
                    RecAdapter recAdapter = new RecAdapter(getActivity(), enrollsList);
                    recyclerview.setAdapter(recAdapter);
                } else {
                    Toast.makeText(getActivity(), "网络被外星人带走了~", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerview.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                recyclerview, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // ...
                Intent intent = new Intent(getActivity(), ShoppingCarActivity.class);
                intent.putExtra("position", http + enrollsList.get(position).getImgUrl());
                intent.putExtra("shopName", enrollsList.get(position).getItemName());
                intent.putExtra("shopPrice", "￥" + enrollsList.get(position).getPrice());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...
            }
        }));

    }

    private void getGorizontalrec() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //设置布局管理器
        recyclerTabfragment.setLayoutManager(layoutManager);
        //设置为横向布局
        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        //设置固定大小
        recyclerTabfragment.setHasFixedSize(true);
        //设置分隔线
        recyclerTabfragment.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager
                .HORIZONTAL, 10, ContextCompat.getColor(getActivity(), R.color.danhui)));
        //设置增加或删除条目的动画
        recyclerTabfragment.setItemAnimator(new DefaultItemAnimator());
        HttpUtils.getData(url, new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                BoutiqueBean gsonToBean = GsonUtils.gsonToBean(s, BoutiqueBean.class);
                listBeanXes = gsonToBean
                        .getEnrolls_1().getList();
                if (listBeanXes != null) {
                    HorizontalAdapter adapter = new HorizontalAdapter(getActivity(),
                            listBeanXes);
                    recyclerTabfragment.setAdapter(adapter);
                }
            }
        });
        recyclerTabfragment.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                recyclerview, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // ...
                Intent intent = new Intent(getActivity(), ShoppingCarActivity.class);
                intent.putExtra("position", http + listBeanXes.get(position).getImgUrl());
                intent.putExtra("shopName", listBeanXes.get(position).getItemName());
                intent.putExtra("shopPrice", "￥" + listBeanXes.get(position).getPrice());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...
            }
        }));

    }
}
