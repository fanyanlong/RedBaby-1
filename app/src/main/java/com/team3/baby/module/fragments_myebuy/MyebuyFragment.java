package com.team3.baby.module.fragments_myebuy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.cundong.recyclerview.HeaderSpanSizeLookup;
import com.cundong.recyclerview.RecyclerViewUtils;
import com.google.gson.Gson;
import com.lzy.okgo.callback.StringCallback;
import com.team3.baby.R;
import com.team3.baby.module.fragments_myebuy.bean_myebuy.LoveGoodsBean;
import com.team3.baby.module.fragments_myebuy.bean_myebuy.SkusBean;
import com.team3.baby.utils.HttpUtils;
import com.team3.baby.utils.OkUtils;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

//import com.team3.baby.module.fragments_myebuy.utils_myebuy.RecyclerAddHeader;

/**
 * Created by tianjieyu on 2017/5/17.
 */

public class MyebuyFragment extends Fragment implements View.OnClickListener {


    ArrayList<String> images = new ArrayList<>();
    HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;
    @BindView(R.id.iv_back_myebuy_include)
    ImageView ivBackMyebuyInclude;
    @BindView(R.id.et_zhanghao_include)
    EditText etZhanghaoInclude;
    @BindView(R.id.iv_zhanghao_include)
    ImageView ivZhanghaoInclude;
    @BindView(R.id.et_mima_include)
    EditText etMimaInclude;


    private Unbinder unbinder;
    private RecyclerView recyclerCailoveMyebuy;
    private ArrayList<SkusBean> skus;
    private RecyclerAddHeader recyclerAddHeader;
    private SharedPreferences.Editor edit;
    private LinearLayout denglujiemian;
    private ScrollView sv_yidenglu_myebuy;
    private Button bt_denglu_myebuy;
    private EditText et_zhanghao_include;
    private EditText et_mima_include;
    private CheckBox rb_abc_myebuy;
    private Object image;
    private TextView zhuce;
    private UMAuthListener umAuthListener = new UMAuthListener() {

        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            //   Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
            switch (action) {
                // 授权成功的状态
                case UMAuthListener.ACTION_AUTHORIZE:
                    //   Toast.makeText(getActivity(), "ACTION_AUTHORIZE111", Toast.LENGTH_SHORT).show();
                    UMShareAPI mShareAPI = UMShareAPI.get(getActivity());
                    mShareAPI.getPlatformInfo(getActivity(), platform, umAuthListener);
                    break;
                // 登录成功后的 获取用户信息的-----------------------------------------------


                case UMAuthListener.ACTION_GET_PROFILE:
                    //  Toast.makeText(getActivity(), "zoule", Toast.LENGTH_SHORT).show();
                    name = data.get("name");
                    iconurl = data.get("iconurl");

                    gender = data.get("gender");

                    edit = sharedPreferences.edit();

                    edit.putBoolean("QQ", true);
                    edit.putString("name", name);
                    edit.putString("iconurl", iconurl);
                    edit.putString("gender", gender);
                    edit.putBoolean("yidenglu", true);
                    edit.commit();
                    dengluwancheng();

                    break;


            }

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    private SharedPreferences sharedPreferences;
    private ImageView touxiang;
    private TextView phone;
    private String name;
    private String iconurl;
    private String gender;

    protected void initData() {


        OkHttpClient client = OkUtils.getClient();
        String url = "http://tuijian.suning.com/recommend-portal/dyBase.jsonp?u=&c=864394010080028&cityId=579&sceneIds=18-41&count=50";
        OkUtils.getEnqueue(url, null, new OkUtils.MyCallback() {
            @Override
            public void onSuccess(String result) {
                // Toast.makeText(getActivity(), "得到数据：" + result, Toast.LENGTH_SHORT).show();
                Gson gson = new Gson();
                LoveGoodsBean loveGoodsBean = gson.fromJson(result, LoveGoodsBean.class);
                skus = (ArrayList<SkusBean>) loveGoodsBean.getSugGoods().get(0).getSkus();

                Fragment_myebuy_RecycleAdapter dataAdapter = new Fragment_myebuy_RecycleAdapter(getActivity(), skus, images, recyclerCailoveMyebuy);

                mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(dataAdapter);
                recyclerCailoveMyebuy.setAdapter(mHeaderAndFooterRecyclerViewAdapter);
                GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);

                manager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter) recyclerCailoveMyebuy.getAdapter(), manager.getSpanCount()));
                recyclerCailoveMyebuy.setLayoutManager(manager);

                RecyclerViewUtils.setHeaderView(recyclerCailoveMyebuy, recyclerAddHeader);

            }

            @Override
            public void onError(String errorMsg) {

                Log.d("ddd", "请求数据失败了");
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_myebuy, null);
        recyclerCailoveMyebuy = (RecyclerView) view.findViewById(R.id.recycler_cailove_myebuy);
        recyclerAddHeader = new RecyclerAddHeader(getContext());
        UMShareAPI.get(getActivity());
        sharedPreferences = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
//头布局
        View inflate = recyclerAddHeader.inflate;
        denglujiemian = (LinearLayout) view.findViewById(R.id.include_weidenglu);
        ImageView qqdenglu = (ImageView) view.findViewById(R.id.iv_qq_denglu);
        //qq登录
        qqdenglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UMShareAPI mShareAPI = UMShareAPI.get(getActivity());
                mShareAPI.doOauthVerify(getActivity(), SHARE_MEDIA.QQ, umAuthListener);
            }
        });
        sv_yidenglu_myebuy = (ScrollView) view.findViewById(R.id.sv_yidenglu_myebuy);
        bt_denglu_myebuy = (Button) view.findViewById(R.id.bt_denglu_myebuy);
        et_zhanghao_include = (EditText) view.findViewById(R.id.et_zhanghao_include);
        et_mima_include = (EditText) view.findViewById(R.id.et_mima_include);
        rb_abc_myebuy = (CheckBox) view.findViewById(R.id.rb_abc_myebuy);
        zhuce = (TextView) view.findViewById(R.id.tv_zhuce_mebuy);
        touxiang = (ImageView) inflate.findViewById(R.id.iv_touxiang_wode_fragment);
        touxiang.setOnClickListener(this);
        phone = (TextView) inflate.findViewById(R.id.tv_phone_myebuy_fragment);
        phone.setOnClickListener(this);
        inflate.findViewById(R.id.tv_shezhi_wode_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.iv_liuyan_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.tv_dizhi_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.ll_quanbuOrder_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.ll_daizhifu_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.ll_daishouhuo_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.ll_daipingjia_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.ll_tuihuan_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.ll_yunzuan_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.ll_zuji_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.ll_youhui_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.ll_bangding_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.ll_anquan_myebuy_fragment).setOnClickListener(this);
        inflate.findViewById(R.id.ll_shoucang_myebuy_fragment).setOnClickListener(this);


        bt_denglu_myebuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(et_mima_include.getText()) && !TextUtils.isEmpty(et_zhanghao_include.getText())) {
                    edit.putBoolean("yidenglu", true);
                    denglujiemian.setVisibility(View.INVISIBLE);
                    sv_yidenglu_myebuy.setVisibility(View.VISIBLE);
                    edit.commit();
                } else {
                    Toast.makeText(getContext(), "用户名密码不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });
        rb_abc_myebuy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {

                    et_mima_include.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    et_mima_include.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
            }
        });

        initData();
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onResume() {
        super.onResume();
        dengluwancheng();


    }

    public void dengluwancheng() {
        edit = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("yidenglu", false)) {

            denglujiemian.setVisibility(View.INVISIBLE);

            sv_yidenglu_myebuy.setVisibility(View.VISIBLE);
            Glide.with(getActivity()).load(sharedPreferences.getString("iconurl", "")).into(touxiang);
            phone.setText(sharedPreferences.getString("name", ""));
            Toast.makeText(getActivity(), sharedPreferences.getString("name", "") + "：欢迎您回来RedBaby", Toast.LENGTH_SHORT).show();
        } else {
            denglujiemian.setVisibility(View.VISIBLE);
            sv_yidenglu_myebuy.setVisibility(View.INVISIBLE);

            //  Toast.makeText(getActivity(), name + gender + "：欢迎您来到RedBaby", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tv_zhuce_mebuy:

                startActivity(new Intent(getActivity(), Zhuce.class));
                break;
            case R.id.iv_touxiang_wode_fragment:
                //进入我的信息界面
                startActivity(new Intent(getActivity(), MyMessage.class));
                break;
            case R.id.tv_phone_myebuy_fragment:
                //进入会员界面
                startActivity(new Intent(getActivity(), MyMember.class));
                break;
            case R.id.tv_shezhi_wode_fragment:
                //进入设置界面
                startActivity(new Intent(getActivity(), Setting.class));
                break;
            case R.id.iv_liuyan_myebuy_fragment:
                //进入消息界面
                startActivity(new Intent(getActivity(), XiaoXi.class));
                break;
            case R.id.tv_dizhi_myebuy_fragment:
                //进入地址管理界面
                startActivity(new Intent(getActivity(), ShowItem.class));
                break;
            case R.id.ll_quanbuOrder_myebuy_fragment:
                //进入查看订单界面
                startActivity(new Intent(getActivity(), CheckOrder.class));
                break;
            case R.id.ll_daizhifu_myebuy_fragment:
                //进入待支付界面
                startActivity(new Intent(getActivity(), PayAcitvity.class));
                break;
            case R.id.ll_daishouhuo_myebuy_fragment:
                //进入待收货界面
                startActivity(new Intent(getActivity(), Receive.class));
                break;
            case R.id.ll_daipingjia_myebuy_fragment:
                //进入待评价界面
                startActivity(new Intent(getActivity(), Judge.class));
                break;
            case R.id.ll_tuihuan_myebuy_fragment:
                //进入后续服务界面
                startActivity(new Intent(getActivity(), MyService.class));
                break;
            case R.id.ll_yunzuan_myebuy_fragment:
                //进入查看云钻界面
                startActivity(new Intent(getActivity(), Diamond.class));
                break;
            case R.id.ll_zuji_myebuy_fragment:
                //进入足迹界面
                startActivity(new Intent(getActivity(), Myhistory.class));
                break;
            case R.id.ll_youhui_myebuy_fragment:
                //进入优惠券界面
                startActivity(new Intent(getActivity(), Coupon.class));
                break;
            case R.id.ll_bangding_myebuy_fragment:
                //进入绑定设置界面
                startActivity(new Intent(getActivity(), BindSeting.class));
                break;
            case R.id.ll_anquan_myebuy_fragment:
                //进入账户安全界面
                startActivity(new Intent(getActivity(), Accountsecurity.class));
                break;
            case R.id.ll_shoucang_myebuy_fragment:
                //进入收藏界面
                startActivity(new Intent(getActivity(), Collect.class));
                break;

        }
    }

    public void getImage(String url2) {
        HttpUtils.getData(url2, new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                try {
                    Log.d("ddd", "size:" + images.size());
                    images.add(s);
                    Log.d("ddd", "size:" + images.size());
                    // Toast.makeText(getContext(), "size" + images.size(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
