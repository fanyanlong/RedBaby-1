package com.team3.baby.app;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/25
 */

public class Qapp extends Application {
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
}

