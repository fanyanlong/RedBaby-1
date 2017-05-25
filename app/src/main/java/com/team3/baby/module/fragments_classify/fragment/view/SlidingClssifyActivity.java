package com.team3.baby.module.fragments_classify.fragment.view;

import android.app.Instrumentation;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ExpandableListView;

import com.team3.baby.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/24  19:46
 */

public class SlidingClssifyActivity extends AppCompatActivity {
    @BindView(R.id.v_shadow_slidingmenu)
    View mVShadowSlidingmenu;
    @BindView(R.id.ex_sliding)
    ExpandableListView mExSliding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slidingmenu_classify);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.v_shadow_slidingmenu)
    public void onViewClicked() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Instrumentation inst = new Instrumentation();
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
            }
        }).start();
    }
}
