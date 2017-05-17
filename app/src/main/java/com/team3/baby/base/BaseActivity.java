package com.team3.baby.base;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.team3.baby.app.App;

import butterknife.ButterKnife;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/17  14:44
 */

public abstract class BaseActivity extends FragmentActivity {
    protected Activity mActivity;
    protected SharedPreferences mSharedPreferences;
    protected SharedPreferences.Editor mEditor;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //常用属性
        mActivity = this;
        mSharedPreferences = App.getSharedPrefernces(mActivity);
        mEditor = mSharedPreferences.edit();
        ButterKnife.bind(this);
        //初始化视图控件
        initView();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //初始化数据
        initData();
        //获取网络数据
        getServerData();
        //判断登录状态,登录后的操作
        //initLoged(loged());
        //设置监听
        setListener();
        //其他
        //ortherToDo();
    }
    protected abstract void initView();

    protected abstract void initData();

    protected abstract void getServerData();

    //protected abstract void initLoged(boolean isloged);

    protected abstract void setListener();

    //protected abstract void ortherToDo();
}
