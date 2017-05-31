package com.team3.baby.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.team3.baby.R;


/**
 * Created by tianjieyu on 2017/5/19.
 */

public class ImageUtils {

    /**
     * 普通加载图片
     *
     * @param mContext  上下文
     * @param url       图片地址
     * @param imageView imageView控件
     */
    public static void loadImageNormal(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext)
                //加载图片地址
                .load(url)
                //图片加载失败后显示本地图片
                .placeholder(R.mipmap.ahahah)
                //设置渐现效果
                //.crossFade()
                //设置缓存
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //设置给控件
                .into(imageView);
    }

    /**
     * 加载圆形图片
     *
     * @param mContext  上下文
     * @param url       图片地址
     * @param imageView imageView控件
     */
    public static void loadImageCircle(final Context mContext, String url, final ImageView imageView) {
        Glide.with(mContext).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    /**
     * 加载GIF动图
     *
     * @param mContext  上下文
     * @param url       图片地址
     * @param imageView imageView控件
     */
    public static void loadImageGIF(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext).load(url)
                .asGif()
                //设置缓存
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }
}
