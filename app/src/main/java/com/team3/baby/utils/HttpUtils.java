package com.team3.baby.utils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/23  19:00
 */

public class HttpUtils {
    public static void getData(String url, StringCallback callback) {
        OkGo.get(url).execute(callback);
    }
}
