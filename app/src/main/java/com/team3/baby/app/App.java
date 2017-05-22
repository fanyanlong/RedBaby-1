package com.team3.baby.app;


import android.content.Context;
import android.content.SharedPreferences;


import static android.content.Context.MODE_PRIVATE;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/17  15:10
 */

public class App {
    private static App mAppApplication;

    /**
     * 单例模式
     * 获取Application
     *
     * @return
     */
    public static App getApp() {
        if (mAppApplication == null) {
            synchronized (App.class) {
                if (mAppApplication == null) {
                    mAppApplication = new App();
                }
            }
        }
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
}
