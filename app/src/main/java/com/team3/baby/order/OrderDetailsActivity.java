package com.team3.baby.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.orhanobut.logger.Logger;
import com.team3.baby.R;
import com.team3.baby.bean.OrderBean;
import com.team3.baby.utils.GsonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

import static com.team3.baby.R.id.tv_order_shoppingName;

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
    @BindView(tv_order_shoppingName)
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
    @BindView(R.id.tv_status_order_details)
    TextView mTvStatusOrderDetails;
    @BindView(R.id.imageView4)
    ImageView mImageView4;
    @BindView(R.id.ll_order_zhifu)
    LinearLayout mLlOrderZhifu;
    private TextView tv_orderdetails;
    private String mOrder_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    @Override
    protected void onResume() {
        super.onResume();
        getServerData();
    }

    private void getServerData() {
        String url = "http://service.alinq.cn:2800/UserShop/Order/GetOrder?storeId=58401d1906c02a2b8877bd13";
        OkGo.get(url)
                .headers("user-token", "584cfabb4918e4186a77ff1e")
                .headers("application-key", "58424776034ff82470d06d3d")
                .params("orderId", mOrder_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Logger.d(s);
                        //订单对象
                        OrderBean orderBean = GsonUtils.gsonToBean(s, OrderBean.class);
                        if (orderBean.getStatus().equals("Paid")) {
                            mLlOrderZhifu.setVisibility(View.GONE);
                            mTvStatusOrderDetails.setText(orderBean.getStatusText());//订单状态
                            tv_orderdetails.setText(orderBean.getSerial());//订单号
                            mTvOrderName.setText("CustomerId" + orderBean.getCustomerId());//用户名
                            mTvOrderAddress.setText("地址--");//地址
                            mTvOrderNumber.setText("电话号码--");//电话号码
                            Glide.with(OrderDetailsActivity.this).load(orderBean.getOrderDetails().get(0).getImageUrl()).into(mImageOrderShoppingImage);//商品图片
                            mTvOrderShoppingName.setText(orderBean.getOrderDetails().get(0).getProductName());
                            mTvOrderPrice.setText(orderBean.getOrderDetails().get(0).getPrice()+"");
                            mTvOrderCount.setText(orderBean.getOrderDetails().get(0).getQuantity() + "");
                            mTvOrderTime.setText(orderBean.getOrderDate());//下单时间
                            List<OrderBean.OrderDetailsBean> orderDetails = orderBean.getOrderDetails();
                            int price = 0;
                            for (int i = 0; i < orderDetails.size(); i++) {
                                int _p = orderDetails.get(i).getPrice() * orderDetails.get(i).getQuantity();
                                price = price + _p;
                            }
                            mTvOrderAmount.setText(price + "");
                        } else if (orderBean.getStatus().equals("Created")) {

                        }

                    }
                });
    }

    private void initData() {
        Intent intent = getIntent();
        mOrder_id = intent.getStringExtra("order_id");
        tv_orderdetails.setText(mOrder_id);
        Logger.d(mOrder_id);
    }

    private void initView() {
        tv_orderdetails = (TextView) findViewById(R.id.tv_orderdetails);
    }
}
