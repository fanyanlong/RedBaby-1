package com.team3.baby.module.fragments_myebuy.otheractivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.team3.baby.R;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class Accountsecurity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.accountsecurity);
        findViewById(R.id.iv_back_myebuy_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
