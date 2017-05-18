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

public class MainModuleImpl implements MainModule{

    @Override
    public void addFragment(int layout, FragmentTransaction transaction, Fragment fragment1,
                            Fragment fragment2, Fragment fragment3,
                            Fragment fragment4, Fragment fragment5) {
        transaction.add(layout,fragment1,"tag1");
        transaction.add(layout,fragment2,"tag2");
        transaction.add(layout,fragment3,"tag3");
        transaction.add(layout,fragment4,"tag4");
        transaction.add(layout,fragment5,"tag5");
        transaction.show(fragment1);
        transaction.hide(fragment2);
        transaction.hide(fragment3);
        transaction.hide(fragment4);
        transaction.hide(fragment5);
        transaction.commit();
    }

    @Override
    public void setShowAndHideView(MainOnListenerHome mainOnListener) {
        mainOnListener.onClickRaoBtnHome();
    }

    @Override
    public void setShowAndHideView(MainOnListenerClass mainOnListener) {
        mainOnListener.onClickRaoBtnClass();
    }

    @Override
    public void setShowAndHideView(MainOnListenerGroupBuy mainOnListener) {
        mainOnListener.onClickRaoBtnGroupBuy();
    }

    @Override
    public void setShowAndHideView(MainOnListenerShopping mainOnListener) {
        mainOnListener.onClickRaoBtnShopping();
    }

    @Override
    public void setShowAndHideView(MainOnListenerMyeBuy mainOnListener) {
        mainOnListener.onClickRaoBtnMyeBuy();
    }
}
