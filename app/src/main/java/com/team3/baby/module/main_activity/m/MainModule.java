package com.team3.baby.module.main_activity.m;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.team3.baby.module.main_activity.v.MainOnListenerClass;
import com.team3.baby.module.main_activity.v.MainOnListenerGroupBuy;
import com.team3.baby.module.main_activity.v.MainOnListenerHome;
import com.team3.baby.module.main_activity.v.MainOnListenerMyeBuy;
import com.team3.baby.module.main_activity.v.MainOnListenerShopping;

/**
 * Created by tianjieyu on 2017/5/17.
 */

public interface MainModule {
    void addFragment(int layout,FragmentTransaction transaction,Fragment fragment1, Fragment fragment2,
                     Fragment fragment3, Fragment fragment4, Fragment fragment5);

    void setShowAndHideView(MainOnListenerHome mainOnListener);
    void setShowAndHideView(MainOnListenerClass mainOnListener);
    void setShowAndHideView(MainOnListenerGroupBuy mainOnListener);
    void setShowAndHideView(MainOnListenerShopping mainOnListener);
    void setShowAndHideView(MainOnListenerMyeBuy mainOnListener);

}
