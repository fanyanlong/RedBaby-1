package com.team3.baby.module.main_activity.m;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by tianjieyu on 2017/5/17.
 */

public interface MainModule {
    void hideAndShow(int layout,FragmentTransaction transaction,Fragment fragment1, Fragment fragment2,
                     Fragment fragment3, Fragment fragment4, Fragment fragment5);
}
