package com.team3.baby.module.fragments_groupBuy.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.team3.baby.R;
import com.youth.banner.loader.ImageLoader;

/**
 * 类用途：
 * 作者：ShiZhuangZhuang
 * 时间：2017/5/23 14:15
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(context)
                .load(path)
                .transform(new GlideRoundTransform(context,20))
                .into(imageView);
    }
}