package com.team3.baby.module.main_activity.p;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;

import com.team3.baby.module.main_activity.m.MainModuleImpl;
import com.team3.baby.module.main_activity.v.MainOnListenerClass;
import com.team3.baby.module.main_activity.v.MainOnListenerGroupBuy;
import com.team3.baby.module.main_activity.v.MainOnListenerHome;
import com.team3.baby.module.main_activity.v.MainOnListenerMyeBuy;
import com.team3.baby.module.main_activity.v.MainOnListenerShopping;
import com.team3.baby.module.main_activity.v.MainView;

/**
 * Created by tianjieyu on 2017/5/17.
 */

public class MainPresenter {
    private MainModuleImpl mainModule;
    private MainView mainView;
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    private Fragment fragment4;
    private Fragment fragment5;

    public MainPresenter(MainView mainView) {
        this.mainModule = new MainModuleImpl();
        this.mainView = mainView;
    }

    public void addFragment() {
        fragment1 = mainView.getFragment1();
        fragment2 = mainView.getFragment2();
        fragment3 = mainView.getFragment3();
        fragment4 = mainView.getFragment4();
        fragment5 = mainView.getFragment5();
        mainModule.addFragment(mainView.getLayout(), mainView.getFragmentTransaction(),
                fragment1, fragment2, fragment3,fragment4,
                fragment5);
    }

    public void setMainOnListenerHome() {
        mainModule.setShowAndHideView(new MainOnListenerHome() {
            @Override
            public void onClickRaoBtnHome() {
                FragmentTransaction transaction = mainView.getFragmentTransaction();
                transaction.show(fragment1);
                transaction.hide(fragment2);
                transaction.hide(fragment3);
                transaction.hide(fragment4);
                transaction.hide(fragment5);
                transaction.commit();
            }
        });
    }

    public void setMainOnListenerClass() {
        mainModule.setShowAndHideView(new MainOnListenerClass() {
            @Override
            public void onClickRaoBtnClass() {
                FragmentTransaction transaction = mainView.getFragmentTransaction();
                transaction.hide(fragment1);
                transaction.show(fragment2);
                transaction.hide(fragment3);
                transaction.hide(fragment4);
                transaction.hide(fragment5);
                transaction.commit();
            }
        });
    }

    public void setMainOnListenerGroupBuy(final RadioButton button) {
        mainModule.setShowAndHideView(new MainOnListenerGroupBuy() {
            @Override
            public void onClickRaoBtnGroupBuy() {
                FragmentTransaction transaction = mainView.getFragmentTransaction();
                transaction.hide(fragment1);
                transaction.hide(fragment2);
                transaction.show(fragment3);
                transaction.hide(fragment4);
                transaction.hide(fragment5);
                transaction.commit();
                button.setChecked(true);
            }
        });
    }

    public void setMainOnListenerShopping() {
        mainModule.setShowAndHideView(new MainOnListenerShopping() {
            @Override
            public void onClickRaoBtnShopping() {
                FragmentTransaction transaction = mainView.getFragmentTransaction();
                transaction.hide(fragment1);
                transaction.hide(fragment2);
                transaction.hide(fragment3);
                transaction.show(fragment4);
                transaction.hide(fragment5);
                transaction.commit();
            }
        });
    }

    public void setMainOnListenerMyeBuy() {
        mainModule.setShowAndHideView(new MainOnListenerMyeBuy() {
            @Override
            public void onClickRaoBtnMyeBuy() {
                FragmentTransaction transaction = mainView.getFragmentTransaction();
                transaction.hide(fragment1);
                transaction.hide(fragment2);
                transaction.hide(fragment3);
                transaction.hide(fragment4);
                transaction.show(fragment5);
                transaction.commit();
            }
        });
    }
}
