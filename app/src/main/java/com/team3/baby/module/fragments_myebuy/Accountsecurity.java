package com.team3.baby.module.fragments_myebuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.team3.baby.R;
import com.team3.baby.module.fragments_myebuy.coutoum_circle.MyCircle;
import com.team3.baby.module.main_activity.v.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class Accountsecurity extends FragmentActivity {

    int progress = 100;
    private MyCircle myCircle;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_security_mybey);
        findViewById(R.id.iv_back_security).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        ButterKnife.bind(this);
        myCircle = (MyCircle) findViewById(R.id.coutoum_circle);
        myCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress = 100;
                timer = new Timer();
                timer.schedule(new Mytimer(), 1000, 50);


            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        progress = 100;
        timer = new Timer();
        //100毫秒后，每隔10毫秒发送一个timer任务
        timer.schedule(new Mytimer(), 100, 15);

    }

    class Mytimer extends TimerTask {
        @Override
        public void run() {

            if (progress > 48) {
                progress--;
                myCircle.setProgress(progress);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                timer.cancel();
            }

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
