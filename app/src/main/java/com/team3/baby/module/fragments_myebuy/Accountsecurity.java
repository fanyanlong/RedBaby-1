package com.team3.baby.module.fragments_myebuy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.team3.baby.R;
import com.team3.baby.module.fragments_myebuy.coutoum_circle.MyCircle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/18
 */
public class Accountsecurity extends Activity {

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

        myCircle = (MyCircle) findViewById(R.id.coutoum_circle);
        myCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress = 100;
                timer = new Timer();
                timer.schedule(new Mytimer(), 100, 15);


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





}
