package com.team3.baby.module.main_activity.v;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by tianjieyu on 2017/5/17.
 */

public interface MainView {
    Fragment getFragment1();

    Fragment getFragment2();

    Fragment getFragment3();

    Fragment getFragment4();

    Fragment getFragment5();

    int getLayout();

    FragmentTransaction getFragmentTransaction();
}
