package com.team3.baby.module.fragments_myebuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.team3.baby.R;
import com.team3.baby.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by tianjieyu on 2017/5/17.
 */

public class MyebuyFragment extends BaseFragment implements MyebuyLisenner {


    Unbinder unbinder;
    @BindView(R.id.iv_back_myebuy_include)
    ImageView ivBackMyebuyInclude;
    @BindView(R.id.et_zhanghao_include)
    EditText etZhanghaoInclude;
    @BindView(R.id.iv_zhanghao_include)
    ImageView ivZhanghaoInclude;
    @BindView(R.id.et_mima_include)
    EditText etMimaInclude;
    @BindView(R.id.rb_abc_myebuy)
    RadioButton rbAbcMyebuy;
    @BindView(R.id.rb_dian_myebuy)
    RadioButton rbDianMyebuy;
    @BindView(R.id.iv_touxiang_wode_fragment)
    ImageView ivTouxiangWodeFragment;
    @BindView(R.id.tv_phone_myebuy_fragment)
    TextView tvPhoneMyebuyFragment;
    @BindView(R.id.tv_shezhi_wode_fragment)
    TextView tvShezhiWodeFragment;
    @BindView(R.id.iv_liuyan_myebuy_fragment)
    ImageView ivLiuyanMyebuyFragment;
    @BindView(R.id.tv_dizhi_myebuy_fragment)
    TextView tvDizhiMyebuyFragment;
    @BindView(R.id.ll_quanbuOrder_myebuy_fragment)
    LinearLayout llQuanbuOrderMyebuyFragment;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.ll_daizhifu_myebuy_fragment)
    LinearLayout llDaizhifuMyebuyFragment;
    @BindView(R.id.ll_daishouhuo_myebuy_fragment)
    LinearLayout llDaishouhuoMyebuyFragment;
    @BindView(R.id.ll_daipingjia_myebuy_fragment)
    LinearLayout llDaipingjiaMyebuyFragment;
    @BindView(R.id.ll_tuihuan_myebuy_fragment)
    LinearLayout llTuihuanMyebuyFragment;
    @BindView(R.id.ll_shoucang_myebuy_fragment)
    LinearLayout llShoucangMyebuyFragment;
    @BindView(R.id.ll_yunzuan_myebuy_fragment)
    LinearLayout llYunzuanMyebuyFragment;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.ll_zuji_myebuy_fragment)
    LinearLayout llZujiMyebuyFragment;
    @BindView(R.id.ll_youhui_myebuy_fragment)
    LinearLayout llYouhuiMyebuyFragment;
    @BindView(R.id.ll_bangding_myebuy_fragment)
    LinearLayout llBangdingMyebuyFragment;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.ll_anquan_myebuy_fragment)
    LinearLayout llAnquanMyebuyFragment;
    @BindView(R.id.recycler_cailove_myebuy)
    RecyclerView recyclerCailoveMyebuy;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_myebuy, null);

        return view;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void gotoPay() {
        //进入待支付界面
        startActivity(new Intent(mContext, PayAcitvity.class));
    }

    @Override
    public void gotoReceive() {
        //进入待收货界面
        startActivity(new Intent(mContext, Receive.class));
    }

    @Override
    public void gotoJudge() {
        //进入待评价界面
        startActivity(new Intent(mContext, Judge.class));
    }

    @Override
    public void gotoService() {
        //进入后续服务界面
        startActivity(new Intent(mContext, MyService.class));
    }

    @Override
    public void gotoCheckOrder() {
        //进入查看订单界面
        startActivity(new Intent(mContext, CheckOrder.class));
    }

    @Override
    public void gotoDiamond() {
        //进入查看云钻界面
        startActivity(new Intent(mContext, Diamond.class));
    }

    @Override
    public void gotoMyhistory() {
        //进入足迹界面
        startActivity(new Intent(mContext, Myhistory.class));

    }

    @Override
    public void gotocoupon() {
        //进入优惠券界面
        startActivity(new Intent(mContext, Coupon.class));
    }

    @Override
    public void gotoBindSeting() {
        //进入绑定设置界面
        startActivity(new Intent(mContext, BindSeting.class));
    }

    @Override
    public void gotoaccountsecurity() {
        //进入账户安全界面
        startActivity(new Intent(mContext, Accountsecurity.class));
    }

    //进入地址管理界面
    @Override
    public void gotoShowAddress() {

        startActivity(new Intent(mContext, ShowItem.class));
    }

    @Override
    //进入收藏界面
    public void gotoCollect() {
        startActivity(new Intent(mContext, Collect.class));
    }

    @Override
    //进入设置界面
    public void Setting() {
        startActivity(new Intent(mContext, Setting.class));
    }


    @Override
    //进入查看详情界面
    public void checkdetails(int goodsid) {
        startActivity(new Intent(mContext, Checkdetails.class));
    }

    //进入消息界面
    @Override
    public void gotoXiaoXi() {
        startActivity(new Intent(mContext, XiaoXi.class));

    }

    //进入我的信息界面
    @Override
    public void gotoMyMessage(int Mid) {
        startActivity(new Intent(mContext, MyMessage.class));
    }

    //进入会员界面
    @Override
    public void gotoMember(int Myid) {
        startActivity(new Intent(mContext, MyMember.class));
    }

    @OnClick({R.id.iv_back_myebuy_include, R.id.et_zhanghao_include, R.id.iv_zhanghao_include, R.id.et_mima_include, R.id.rb_abc_myebuy, R.id.rb_dian_myebuy, R.id.iv_touxiang_wode_fragment, R.id.tv_phone_myebuy_fragment, R.id.tv_shezhi_wode_fragment, R.id.iv_liuyan_myebuy_fragment, R.id.tv_dizhi_myebuy_fragment, R.id.ll_quanbuOrder_myebuy_fragment, R.id.imageView, R.id.ll_daizhifu_myebuy_fragment, R.id.ll_daishouhuo_myebuy_fragment, R.id.ll_daipingjia_myebuy_fragment, R.id.ll_tuihuan_myebuy_fragment, R.id.ll_shoucang_myebuy_fragment, R.id.ll_yunzuan_myebuy_fragment, R.id.imageView3, R.id.ll_zuji_myebuy_fragment, R.id.ll_youhui_myebuy_fragment, R.id.ll_bangding_myebuy_fragment, R.id.imageView2, R.id.ll_anquan_myebuy_fragment, R.id.recycler_cailove_myebuy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_myebuy_include:
                getActivity().finish();
                break;
            case R.id.et_zhanghao_include:
                break;
            case R.id.iv_zhanghao_include:
                break;
            case R.id.et_mima_include:
                break;
            case R.id.rb_abc_myebuy:
                break;
            case R.id.rb_dian_myebuy:
                break;
            case R.id.iv_touxiang_wode_fragment:
                //进入我的信息界面
                startActivity(new Intent(mContext, MyMessage.class));
                break;
            case R.id.tv_phone_myebuy_fragment:
                //进入会员界面
                startActivity(new Intent(mContext, MyMember.class));
                break;
            case R.id.tv_shezhi_wode_fragment:
                //进入设置界面
                startActivity(new Intent(mContext, Setting.class));
                break;
            case R.id.iv_liuyan_myebuy_fragment:
                //进入消息界面
                startActivity(new Intent(mContext, XiaoXi.class));
                break;
            case R.id.tv_dizhi_myebuy_fragment:
                //进入地址管理界面
                startActivity(new Intent(mContext, ShowItem.class));
                break;
            case R.id.ll_quanbuOrder_myebuy_fragment:
                //进入查看订单界面
                startActivity(new Intent(mContext, CheckOrder.class));
                break;
            case R.id.imageView:
                break;
            case R.id.ll_daizhifu_myebuy_fragment:
                startActivity(new Intent(mContext, PayAcitvity.class));
                break;
            case R.id.ll_daishouhuo_myebuy_fragment:
                startActivity(new Intent(mContext, Receive.class));
                break;
            case R.id.ll_daipingjia_myebuy_fragment:
                //进入待评价界面
                startActivity(new Intent(mContext, Judge.class));
                break;
            case R.id.ll_tuihuan_myebuy_fragment:
                //进入后续服务界面
                startActivity(new Intent(mContext, MyService.class));
                break;
            case R.id.ll_shoucang_myebuy_fragment:
                //进入收藏界面
                startActivity(new Intent(mContext, Collect.class));
                break;
            case R.id.ll_yunzuan_myebuy_fragment:
                //进入查看云钻界面
                startActivity(new Intent(mContext, Diamond.class));
                break;
            case R.id.imageView3:
                break;
            case R.id.ll_zuji_myebuy_fragment:
                //进入足迹界面
                startActivity(new Intent(getActivity(), Myhistory.class));
                break;
            case R.id.ll_youhui_myebuy_fragment:
                //进入优惠券界面
                startActivity(new Intent(mContext, Coupon.class));
                break;
            case R.id.ll_bangding_myebuy_fragment:
                //进入绑定设置界面
                startActivity(new Intent(mContext, BindSeting.class));
                break;
            case R.id.imageView2:
                break;
            case R.id.ll_anquan_myebuy_fragment:
                //进入账户安全界面
                startActivity(new Intent(mContext, Accountsecurity.class));
                break;
            case R.id.recycler_cailove_myebuy:
                break;
        }
    }
}
