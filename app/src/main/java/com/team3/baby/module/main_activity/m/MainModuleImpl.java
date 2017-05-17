package com.team3.baby.module.main_activity.m;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by tianjieyu on 2017/5/17.
 */

public class MainModuleImpl implements MainModule{

    @Override
    public void hideAndShow(int layout, FragmentTransaction transaction, Fragment fragment1,
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
}
