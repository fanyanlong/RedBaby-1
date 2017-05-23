package com.team3.baby.app;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import me.redbaby.greendao.DaoMaster;
import me.redbaby.greendao.DaoSession;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/17  15:10
 */

public class App extends Application{
    public DaoSession daoSession;
    public SQLiteDatabase db;
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster daoMaster;
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

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
    }
    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        helper = new DaoMaster.DevOpenHelper(this,"Cart", null);
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
}
