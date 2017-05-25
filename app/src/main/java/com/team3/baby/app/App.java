package com.team3.baby.app;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.PersistentCookieStore;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;

import java.util.logging.Level;

import me.redbaby.greendao.DaoMaster;
import me.redbaby.greendao.DaoSession;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/17  15:10
 */

public class App extends Application {
    public DaoSession daoSession;
    public SQLiteDatabase db;
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster daoMaster;
    /**
     * 单例模式
     * 获取Application
     *
     * @return
     */
    private static App mAppApplication = null;

    public static App getApplication() {
        return mAppApplication;
    }

    /**
     * 获得全局的shareperence
     *
     * @return
     */
    public static SharedPreferences getSharedPrefernces(Context context) {
        context = context.getApplicationContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences("config", MODE_PRIVATE);
        return sharedPreferences;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        config.isOpenShareEditActivity(true);
        config.setSinaAuthType(UMShareConfig.AUTH_TYPE_SSO);
        config.setFacebookAuthType(UMShareConfig.AUTH_TYPE_SSO);
        config.setShareToLinkedInFriendScope(UMShareConfig.LINKED_IN_FRIEND_SCOPE_ANYONE);
        mAppApplication = this;
        //green dao
        setupDatabase();
        //ok go 金虎 5.23
        OkGo.init(this);
        //以下设置的所有参数是全局参数,同样的参数可以在请求的时候再设置一遍,那么对于该请求来讲,请求中的参数会覆盖全局参数
        //好处是全局参数统一,特定请求可以特别定制参数
        try {
            //以下都不是必须的，根据需要自行选择,一般来说只需要 debug,缓存相关,cookie相关的 就可以了
            OkGo.getInstance()

                    // 打开该调试开关,打印级别INFO,并不是异常,是为了显眼,不需要就不要加入该行
                    // 最后的true表示是否打印okgo的内部异常，一般打开方便调试错误
                    .debug("OkGo", Level.INFO, true)

                    //如果使用默认的 60秒,以下三行也不需要传
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)  //全局的连接超时时间
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)     //全局的读取超时时间
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)    //全局的写入超时时间

                    //可以全局统一设置缓存模式,默认是不使用缓存,可以不传,具体其他模式看 github 介绍 https://github.com/jeasonlzy/
                    .setCacheMode(CacheMode.DEFAULT)

                    //可以全局统一设置缓存时间,默认永不过期,具体使用方法看 github 介绍
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)

                    //可以全局统一设置超时重连次数,默认为三次,那么最差的情况会请求4次(一次原始请求,三次重连请求),不需要可以设置为0
                    .setRetryCount(3)

                    //如果不想让框架管理cookie（或者叫session的保持）,以下不需要
//              .setCookieStore(new MemoryCookieStore())            //cookie使用内存缓存（app退出后，cookie消失）
                    .setCookieStore(new PersistentCookieStore())        //cookie持久化存储，如果cookie不过期，则一直有效

                    //可以设置https的证书,以下几种方案根据需要自己设置
                    .setCertificates();                                  //方法一：信任所有证书,不安全有风险
//              .setCertificates(new SafeTrustManager())            //方法二：自定义信任规则，校验服务端证书
//              .setCertificates(getAssets().open("srca.cer"))      //方法三：使用预埋证书，校验服务端证书（自签名证书）
//              //方法四：使用bks证书和密码管理客户端证书（双向认证），使用预埋证书，校验服务端证书（自签名证书）
//               .setCertificates(getAssets().open("xxx.bks"), "123456", getAssets().open("yyy.cer"))//

            //配置https的域名匹配规则，详细看demo的初始化介绍，不需要就不要加入，使用不当会导致https握手失败
//               .setHostnameVerifier(new SafeHostnameVerifier())

            //可以添加全局拦截器，不需要就不要加入，错误写法直接导致任何回调不执行
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        return chain.proceed(chain.request());
//                    }
//                })

            //这两行同上，不需要就不要加入
//                    .addCommonHeaders(headers)  //设置全局公共头
//                    .addCommonParams(params);   //设置全局公共参数

        } catch (Exception e) {
            e.printStackTrace();
        }
        //支部包
//        com.alipay.api.DefaultAlipayClient.DefaultAlipayClient(
// String serverUrl,
// String appId,
// String privateKey,
// String format,
// String charset,
// String alipayPulicKey,
// String signType);
        AlipayClient alipayClient = new
                DefaultAlipayClient(
                "https://openapi.alipaydev.com/gateway.do",
                "2016080400168438",
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCJP5Qv/IHIuC/3wohG2/SpBRt6S3HLxjir6e7sfuRoCJSS5VC4kpjQTfSZyy3N0FixAE1VNtNLi8Gj/0FJjtzHv5jM14N1LdX6USGnn5EQ4JdxAKCbi9woq0oNuu3/FzioDokAWoHH3Gx+E/X0uhuh2jGnoj8JNdSzJLl1X2uHSCdzGQxOpdJ9mX+HpGMRomf5sb8xbj8Osfn5JjEmL8BFPbCQeqJKInwBUgmymUCTHok2ufglDW1tbwlfEPpqUOJNzg+78JJ+oYwVSWU3So+22oOG+RiH8w5P1ZD0zxDAKfvzCDWDxGgYSxvelVbshhZr042sqRKxOv2E57F/Rax5AgMBAAECggEAVy4Qli6hzfrZVVq3L7N2BIre+l7D6Pl/dAwDnSu5MDALGAgbrzJHaUGrVqmN7ccjH0Oe27sYmksq9F4mfXAG48bba3qV4S/9VKSGaTBdeEgBSmFoo4VCkn7DaldL6BY7Ad1Bvvy+pVJpg+hv+kThWnz7v4y618He2vA/8cNrzSDcIe1s4XC6pEI5sMwa2MDM2GFvYhTsj8miaJ6fZfV4GX7/C3h9h30ekRUTQqMHmbW/SDefwlvrgyC1DKilIKvgmnJhstMlqEAlwyqhxfdMAROUZKaK9tBeh1ZdkIqUTnXkO1kbuKP4UwDDxXY50FJDhs37jII46+AK/FWjZ0tYUQKBgQD14OMMS4LExd8U7wqfPTCq9Dw3g0nIYRE6/CfyTysPLtkX3Do1bEGiZjlbFpXNNjtalaT5N7rPAk0lP1W1jN6mBuJheW7qTEV9WkIa9RnkEX6dOX8XYHOjiIZ7FSI6bdLHIHwjs2zTDjHUl+KXzdEz1r2WmUS293ElUloZ6nIptQKBgQCO5e13mO+6loifrDzJKyYrPR+JOHmRzLApasfx2y0eW/TIKd1mHusQaNNyvsgDgQOSaYV1hw0neTHwvASvCpcR0xsnhx/Lzm4y23ibviC+SgKE367ISxO3v4yAbxHWp0oY7TQRp85eBpF/Xv0vbqAy63cs2cJ/z41NjzqxB1UiNQKBgEaXypg9Fc5pASOBfgs6Bj8O4DsP9p8RP2EwBEgNcs9pI+s1z4CHFFEMCGuekGPari/TxwnGdlv4zS1kgbceOs5wK47Qzod2Xn0e7NvQgx5352I8n8CWcJ0DFZlA+BLOdTW2ne2iFhyCdswSz3vGG8pGXShf2NqvME0G19eY+C4BAoGAVMms2zfNlqLXMhbagmqt3R4JZjwyNgaDyC9pr+HipY7ecR4WFg/mXfg07nKw7xNP8UHXRGL7tR4+OZ72EH5yIMtn405T2XQFAvwiVha8CuyTDhBC/uk9K9vmHBbLONhOKPgl2wv8cOHo1vCfvdMgDtaUAfK7a2bVat2/b2bwZrkCgYEAtsHK+/p/ZhWT4uldfyTg+RjtVqGPDvrp3ErGNaDt+d3uyBGizFG6e0JKafFdC8l2qdRRekYa9KuJrRf7xvvHQ3mP5u39v8kfxOkbnzKfXvXgP/hSQvo6tRBnbGlk9l1hGPPTlPzyet7zjvD3joZro8EcGWq6+zmh4mbbHQGPOfI=",
                "json",
                "utf-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0rVPmLaeRkJ3g4fDpQw0Y9S3ECIbzOcgx+MLs+oAr6MeKiQdSDjbBOgagNPMk7l3Q2n/r0m0r5pyNZlOCSYWz5PW18UIdjvd7ErcoAdSaMTgvdKjBzZGaDqrA6gLtp4eiYkaFB41zQwxtLapZFrH8PgfqtdGJWo/Wbarw0q05LkUWqZLSsVaht+Q/crqGObG1sLLlgYa6npNIc2e7TS6SCSuMHIXiI/uF+Kxp/1y7qRpWpHa4XD9jKTodZnde0wBW00+CFIxCCqchmsXwcwwjlYCjuar4Qh8nUE6gtBphc1Vz/1GjreVtDxrorT6mFFL9pqazLnYwOVR4ouVclaOhwIDAQAB",
                "RSA2");
    }


    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        helper = new DaoMaster.DevOpenHelper(this, "Cart", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    {
        PlatformConfig.setQQZone("1106029755", "AaFrTt1byVgUpWIq");
    }
}
