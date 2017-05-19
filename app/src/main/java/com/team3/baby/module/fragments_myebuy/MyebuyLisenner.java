package com.team3.baby.module.fragments_myebuy;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */

public interface MyebuyLisenner {
    //进入待支付界面
    void gotoPay();

    //进入待收货界面
    void gotoReceive();

    //进入待评价界面
    void gotoJudge();

    //进入后续服务界面
    void gotoService();

    //进入查看订单界面
    void gotoCheckOrder();

    //进入查看云钻界面
    void gotoDiamond();

    //进入足迹界面
    void gotoMyhistory();

    //进入优惠券界面
    void gotocoupon();

    //进入绑定设置界面
    void gotoBindSeting();

    //进入账户安全界面
    void gotoaccountsecurity();

    //进入地址管理界面
    void gotoShowAddress();

    //进入收藏界面
    void gotoCollect();

    //进入设置界面
    void Setting();


    //进入查看详情界面
    void checkdetails(int goodsid);

    //进入查看消息界面
    void gotoXiaoXi();


    //进入查看我的信息界面
    void gotoMyMessage(int goodsid);

    //进入会员界面
    void gotoMember(int goodsid);

}
