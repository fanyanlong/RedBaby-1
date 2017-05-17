package com.team3.baby.module.main_activity.p;

import com.team3.baby.module.main_activity.m.MainModuleImpl;
import com.team3.baby.module.main_activity.v.MainView;

/**
 * Created by tianjieyu on 2017/5/17.
 */

public class MainPresenter {
    private MainModuleImpl mainModule;
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainModule = new MainModuleImpl();
        this.mainView = mainView;
    }


}
