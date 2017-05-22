package com.team3.baby.module.fragments_myebuy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.team3.baby.R;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/22
 */
public class RecyclerAddHeader extends RelativeLayout {

    public View inflate;

    public RecyclerAddHeader(Context context) {
        super(context);
        init(context);
    }

    public RecyclerAddHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RecyclerAddHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {

        inflate = inflate(context, R.layout.linearlayout_myebuy_tou, this);
    }

}
