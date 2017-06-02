package com.team3.baby.module.fragments_home.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.team3.baby.R;
import com.team3.baby.zxing.activity.CaptureActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeSeekActivity extends AppCompatActivity {

    @BindView(R.id.home_seek_return_image)
    ImageView mHomeSeekReturnImage;
    @BindView(R.id.home_seek_voice_image)
    ImageView mHomeSeekVoiceImage;
    @BindView(R.id.linear_inquire_include)
    LinearLayout mLinearInquireInclude;
    @BindView(R.id.home_seek_search_text)
    TextView mHomeSeekSearchText;
    @BindView(R.id.home_seek_delete_image)
    ImageView mHomeSeekDeleteImage;
    @BindView(R.id.home_recently_seek_rv)
    RecyclerView mHomeRecentlySeekRv;
    @BindView(R.id.home_hot_seek_rv)
    RecyclerView mHomeHotSeekRv;
    @BindView(R.id.home_seek_search_et)
    EditText mHomeSeekSearchEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_seek);
        ButterKnife.bind(this);

        initData();    
    }

    private void initData() {





        mHomeSeekReturnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mHomeSeekVoiceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//6.0动态添加
                Acp.getInstance(HomeSeekActivity.this).request(new AcpOptions.Builder()
                                .setPermissions(Manifest.permission.RECORD_AUDIO)
                /*以下为自定义提示语、按钮文字
                .setDeniedMessage()
                .setDeniedCloseBtn()
                .setDeniedSettingBtn()
                .setRationalMessage()
                .setRationalBtn()*/
                                .build(),
                        new AcpListener() {
                            @Override
                            public void onGranted() {
                                Intent intent = new Intent(HomeSeekActivity.this,VoiceActivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onDenied(List<String> permissions) {
                                Toast.makeText(HomeSeekActivity.this, "权限被拒绝", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
    }


}
