package com.team3.baby.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.orhanobut.logger.Logger;
import com.team3.baby.R;
import com.team3.baby.bean.OrderBean;
import com.team3.baby.utils.GsonUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class OrderDetailsActivity extends AppCompatActivity {

    @BindView(R.id.iv_order_back)
    ImageView mIvOrderBack;
    @BindView(R.id.tv_orderdetails)
    TextView mTvOrderdetails;
    @BindView(R.id.order_image)
    ImageView mOrderImage;
    @BindView(R.id.order_shouhuoren)
    TextView mOrderShouhuoren;
    @BindView(R.id.tv_order_name)
    TextView mTvOrderName;
    @BindView(R.id.tv_order_number)
    TextView mTvOrderNumber;
    @BindView(R.id.order_dizhi)
    TextView mOrderDizhi;
    @BindView(R.id.tv_order_address)
    TextView mTvOrderAddress;
    @BindView(R.id.image_order_shoppingImage)
    ImageView mImageOrderShoppingImage;
    @BindView(R.id.tv_order_shoppingName)
    TextView mTvOrderShoppingName;
    @BindView(R.id.tv_order_price)
    TextView mTvOrderPrice;
    @BindView(R.id.tv_order_count)
    TextView mTvOrderCount;
    @BindView(R.id.tv_order_invoiceNmae)
    TextView mTvOrderInvoiceNmae;
    @BindView(R.id.tv_order_time)
    TextView mTvOrderTime;
    @BindView(R.id.tv_order_PaymentMethod)
    TextView mTvOrderPaymentMethod;
    @BindView(R.id.tv_order_amount)
    TextView mTvOrderAmount;
    @BindView(R.id.tv_order_commodityAmount)
    TextView mTvOrderCommodityAmount;
    @BindView(R.id.tv_order_Coupon_discount)
    TextView mTvOrderCouponDiscount;
    @BindView(R.id.tv_order_freight)
    TextView mTvOrderFreight;
    @BindView(R.id.tv_order_amountPaid)
    TextView mTvOrderAmountPaid;
    @BindView(R.id.tv_order_gotopay)
    TextView mTvOrderGotopay;
    @BindView(R.id.btn_order_cancelOrder)
    Button mBtnOrderCancelOrder;
    private TextView tv_orderdetails;
    private String mOrder_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);
        initView();
        initData();
        getServerData();
    }

    private void getServerData() {
        String url = "http://service.alinq.cn:2800/UserShop/Order/GetOrder";
        OkGo.get(url)
                .headers("user-token", "584cfabb4918e4186a77ff1e")
                .headers("application-key", "58424776034ff82470d06d3d")
                .params("storeId", "58401d1906c02a2b8877bd13")
                .params("orderId", mOrder_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Logger.d(s);
                        //订单对象4
                        OrderBean orderBean = GsonUtils.gsonToBean(s, OrderBean.class);
                    }
                });
    }

    private void initData() {
        Intent intent = getIntent();
        mOrder_id = intent.getStringExtra("order_id");
        tv_orderdetails.setText(mOrder_id);
    }

    private void initView() {
        tv_orderdetails = (TextView) findViewById(R.id.tv_orderdetails);
    }
}
