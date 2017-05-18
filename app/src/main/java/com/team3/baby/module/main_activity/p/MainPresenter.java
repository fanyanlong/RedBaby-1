package com.team3.baby.module.main_activity.p;

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

    public MainPresenter(MainView mainView) {
        this.mainModule = new MainModuleImpl();
        this.mainView = mainView;
    }

    public void addFragment() {
        mainModule.addFragment(mainView.getLayout(), mainView.getFragmentTransaction(),
                mainView.getFragment1(), mainView.getFragment2(), mainView.getFragment3(),
                mainView.getFragment4(), mainView.getFragment5());
    }

    public void setMainOnListenerHome() {
        mainModule.setShowAndHideView(new MainOnListenerHome() {
            @Override
            public void onClickRaoBtnHome() {
                FragmentTransaction transaction = mainView.getFragmentTransaction();
                transaction.show(mainView.getFragment1());
                transaction.hide(mainView.getFragment2());
                transaction.hide(mainView.getFragment3());
                transaction.hide(mainView.getFragment4());
                transaction.hide(mainView.getFragment5());
                transaction.commit();
            }
        });
    }

    public void setMainOnListenerClass() {
        mainModule.setShowAndHideView(new MainOnListenerClass() {
            @Override
            public void onClickRaoBtnClass() {
                FragmentTransaction transaction = mainView.getFragmentTransaction();
                transaction.hide(mainView.getFragment1());
                transaction.show(mainView.getFragment2());
                transaction.hide(mainView.getFragment3());
                transaction.hide(mainView.getFragment4());
                transaction.hide(mainView.getFragment5());
                transaction.commit();
            }
        });
    }

    public void setMainOnListenerGroupBuy(final RadioButton button) {
        mainModule.setShowAndHideView(new MainOnListenerGroupBuy() {
            @Override
            public void onClickRaoBtnGroupBuy() {
                FragmentTransaction transaction = mainView.getFragmentTransaction();
                transaction.hide(mainView.getFragment1());
                transaction.hide(mainView.getFragment2());
                transaction.show(mainView.getFragment3());
                transaction.hide(mainView.getFragment4());
                transaction.hide(mainView.getFragment5());
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
                transaction.hide(mainView.getFragment1());
                transaction.hide(mainView.getFragment2());
                transaction.hide(mainView.getFragment3());
                transaction.show(mainView.getFragment4());
                transaction.hide(mainView.getFragment5());
                transaction.commit();
            }
        });
    }

    public void setMainOnListenerMyeBuy() {
        mainModule.setShowAndHideView(new MainOnListenerMyeBuy() {
            @Override
            public void onClickRaoBtnMyeBuy() {
                FragmentTransaction transaction = mainView.getFragmentTransaction();
                transaction.hide(mainView.getFragment1());
                transaction.hide(mainView.getFragment2());
                transaction.hide(mainView.getFragment3());
                transaction.hide(mainView.getFragment4());
                transaction.show(mainView.getFragment5());
                transaction.commit();
            }
        });
    }
}
