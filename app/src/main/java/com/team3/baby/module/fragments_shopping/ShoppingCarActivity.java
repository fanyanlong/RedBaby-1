package com.team3.baby.module.fragments_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.orhanobut.logger.Logger;
import com.team3.baby.R;
import com.team3.baby.module.fragments_groupBuy.url.UrlGroupBuy;
import com.team3.baby.module.fragments_shopping.shoppingutils.Shop_Utils;
import com.team3.baby.utils.ImageUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;


public class ShoppingCarActivity extends AppCompatActivity {

    @BindView(R.id.iv_back_shoppingcar_activity)
    ImageView ivBackShoppingcarActivity;
    @BindView(R.id.tv_immediately_buy)
    TextView tvImmediatelyBuy;
    @BindView(R.id.tv_join_shopping_car)
    TextView tvJoinShoppingCar;
    @BindView(R.id.iv_shoppingPicture)
    ImageView ivShoppingPicture;
    @BindView(R.id.tv_shoppingName)
    TextView tvShoppingName;
    @BindView(R.id.tv_shoppingPrice)
    TextView tvShoppingPrice;
    @BindView(R.id.image_shoppingPrice)
    ImageView imageShoppingPrice;
    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_car);
        ButterKnife.bind(this);
        WindowManager wm = this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        initData();
    }

    private void initData() {
        final ArrayList<String> picUrl = Shop_Utils.getPicUrl();

        Intent intent = getIntent();
        final String position = intent.getStringExtra("position");
        final String shopName = intent.getStringExtra("shopName");
        final String shopPrice = intent.getStringExtra("shopPrice");
        final String pid = intent.getStringExtra("pid");


        ImageUtils.loadImageNormal(this, position, ivShoppingPicture);
        tvShoppingName.setText(shopName);
        tvShoppingPrice.setText(shopPrice);

        ivBackShoppingcarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
              /*  Intent intent = new Intent(ShoppingCarActivity.this, MainActivity.class);

                startActivity(intent);*/
            }
        });
        tvImmediatelyBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCarActivity.this, AddIndent_buyActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("shopName", shopName);
                intent.putExtra("shopPrice", shopPrice);
                startActivity(intent);


            }
        });
        tvJoinShoppingCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCarActivity.this, AddIndent_carActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("shopName", shopName);
                intent.putExtra("shopPrice", shopPrice);
                startActivity(intent);

                HashMap<String, String> params = new HashMap<>();
                params.put("storeId", "58401d1906c02a2b8877bd13");
                params.put("key2", "{productId:"+pid+", count: 1}");
                JSONObject jsonObject = new JSONObject(params);


                OkGo.post("http://service.alinq.cn:2800/UserShop/ShoppingCart/AddItem")
                .headers("application-key","58424776034ff82470d06d3d")
                .headers("user-token","584cfabb4918e4186a77ff1e")
                .headers("Content-Type","application/json")
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                         Logger.d(s);
                    }
                });





            }
        });
        imageShoppingPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMWeb umWeb = new UMWeb(position);//要分享的连接
                umWeb.setTitle("红孩子母婴");//分享的描述
                umWeb.setDescription(shopName);//分享的标题
                // UMImage umImage = new UMImage(getActivity(), R.mipmap.ic_launcher);
                new ShareAction(ShoppingCarActivity.this)
                        .withText("hello")
                        .withMedia(umWeb)//注意：把分享类加到里面
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE,
                                SHARE_MEDIA.WEIXIN_FAVORITE, SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
            }
        });

    }

    //分享回调
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);

            Toast.makeText(ShoppingCarActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT)
                    .show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ShoppingCarActivity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT)
                    .show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ShoppingCarActivity.this, platform + " 分享取消了", Toast.LENGTH_SHORT)
                    .show();
        }
    };

    //登录回传的方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(ShoppingCarActivity.this).onActivityResult(requestCode, resultCode, data);
    }

}
