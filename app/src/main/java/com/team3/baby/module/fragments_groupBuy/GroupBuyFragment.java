package com.team3.baby.module.fragments_groupBuy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lzy.okgo.callback.StringCallback;
import com.team3.baby.R;
import com.team3.baby.module.fragments_groupBuy.adapter.GroupBuyAdapter;
import com.team3.baby.module.fragments_groupBuy.bean.BoutiqueBean;
import com.team3.baby.module.fragments_groupBuy.fragment.TabFragment;
import com.team3.baby.module.fragments_groupBuy.fragment.TabFragments;
import com.team3.baby.module.fragments_groupBuy.url.UrlGroupBuy;
import com.team3.baby.utils.GsonUtils;
import com.team3.baby.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Shizhuangzhaung on 2017/5/17.
 */

public class GroupBuyFragment extends Fragment {
    @BindView(R.id.imager_right_fragment_groupbuy)
    ImageView imagerRightFragmentGroupbuy;
    @BindView(R.id.tab_fragment_groupbuy)
    TabLayout tabFragmentGroupbuy;
    @BindView(R.id.viewpager_fragment_groupbuy)
    ViewPager viewpagerFragmentGroupbuy;
    @BindView(R.id.image_top_groupbuy)
    ImageView imageTopGroupbuy;
    @BindView(R.id.texttop_groupbuy)
    TextView texttopGroupbuy;
    private String http = "http:";
    private ArrayList<String> catesName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = inflater.inflate(R.layout.fragment_groupbuy, null);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        HttpUtils.getData(UrlGroupBuy.url, new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                if (s != null) {
                    imageTopGroupbuy.setVisibility(View.VISIBLE);
                    texttopGroupbuy.setVisibility(View.GONE);
                    BoutiqueBean boutiqueBean = GsonUtils.gsonToBean(s, BoutiqueBean.class);
                    //头布局
                    String imgUrl = boutiqueBean.getTopLogo().getImgUrl();
                    Glide.with(getActivity()).load(http + imgUrl).skipMemoryCache(true).into
                            (imageTopGroupbuy);
                    //Tab接口
                    List<BoutiqueBean.CatesBean> catesBeen = boutiqueBean.getCates();
                    catesName = new ArrayList<String>();
                    //fragment接口
                    String[] urlstr = new String[]{UrlGroupBuy.url, UrlGroupBuy.ONE, UrlGroupBuy
                            .TWO, UrlGroupBuy.THREE, UrlGroupBuy.FORM, UrlGroupBuy.FIVE,
                            UrlGroupBuy.SIX, UrlGroupBuy.SEVEN, UrlGroupBuy.EIGHT, UrlGroupBuy
                            .NINE};
                    ArrayList<String> urlList = new ArrayList<>();
                    for (int i = 0; i < urlstr.length; i++) {
                        urlList.add(urlstr[i]);
                    }
                    for (int i = 0; i < catesBeen.size(); i++) {
                        catesName.add(catesBeen.get(i).getCateName());
                    }

                    ArrayList<Fragment> fragmentlist = new ArrayList<Fragment>();
                    //fragment数据
                    TabFragment tabFragment = new TabFragment(UrlGroupBuy.url);
                    fragmentlist.add(0, tabFragment);

                    for (int i = 1; i < catesName.size(); i++) {
                        TabFragments tabFragments = new TabFragments(urlList.get(i));
                        fragmentlist.add(tabFragments);
                    }
                    GroupBuyAdapter adapter = new GroupBuyAdapter(getFragmentManager(),
                            fragmentlist,
                            catesName);

                    tabFragmentGroupbuy.setupWithViewPager(viewpagerFragmentGroupbuy);
                    tabFragmentGroupbuy.setTabsFromPagerAdapter(adapter);
                    viewpagerFragmentGroupbuy.setAdapter(adapter);
                } else {
                    texttopGroupbuy.setVisibility(View.VISIBLE);
                    imageTopGroupbuy.setVisibility(View.GONE);
                    Toast.makeText(getActivity(), "网络被外星人带走了~", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @OnClick({R.id.imager_right_fragment_groupbuy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imager_right_fragment_groupbuy:

                break;
        }
    }
}
