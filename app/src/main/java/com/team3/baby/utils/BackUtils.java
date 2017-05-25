package com.team3.baby.utils;

import android.app.Instrumentation;
import android.view.KeyEvent;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/25  10:06
 */

public class BackUtils {
    public static void toBack() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Instrumentation inst = new Instrumentation();
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
            }
        }).start();
    }
}
