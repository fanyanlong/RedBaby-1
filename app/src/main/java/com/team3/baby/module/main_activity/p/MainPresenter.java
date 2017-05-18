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
   /* HomeFragment homeFragment = (HomeFragment) mainView.getFragment1();
    ClassifyFragment classFragment = (ClassifyFragment) mainView.getFragment2();

    GroupBuyFragment groupBuyFragment = (GroupBuyFragment) mainView.getFragment3();
    ShoppingFragment shoppingFragment = (ShoppingFragment) mainView.getFragment4();
    MyebuyFragment myebuyFragment = (MyebuyFragment) mainView.getFragment5();
*/
    public MainPresenter(MainView mainView) {
        this.mainModule = new MainModuleImpl();
        this.mainView = mainView;
    }

    public void addFragment() {
        mainModule.addFragment(mainView.getLayout(),mainView.getFragmentTransaction(),
                mainView.getFragment1(),mainView.getFragment2(),mainView.getFragment3(),
                mainView.getFragment4(),mainView.getFragment5());
    }

    public void setMainOnListenerHome() {
        mainModule.setShowAndHideView(new MainOnListenerHome() {
            @Override
            public void onClickRaoBtnHome() {
                FragmentTransaction transaction = mainView.getFragmentTransaction();
                /*transaction.show(homeFragment);
                transaction.hide(classFragment);
                transaction.hide(groupBuyFragment);
                transaction.hide(myebuyFragment);
                transaction.hide(shoppingFragment);*/
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
                /*transaction.hide(homeFragment);
                transaction.show(classFragment);
                transaction.hide(groupBuyFragment);
                transaction.hide(myebuyFragment);
                transaction.hide(shoppingFragment);*/
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
                /*transaction.hide(homeFragment);
                transaction.hide(classFragment);
                transaction.show(groupBuyFragment);
                transaction.hide(myebuyFragment);
                transaction.hide(shoppingFragment);*/
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
                /*transaction.hide(homeFragment);
                transaction.hide(classFragment);
                transaction.hide(groupBuyFragment);
                transaction.hide(myebuyFragment);
                transaction.show(shoppingFragment);*/
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
                /*transaction.hide(homeFragment);
                transaction.hide(classFragment);
                transaction.hide(groupBuyFragment);
                transaction.show(myebuyFragment);
                transaction.hide(shoppingFragment);*/
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
