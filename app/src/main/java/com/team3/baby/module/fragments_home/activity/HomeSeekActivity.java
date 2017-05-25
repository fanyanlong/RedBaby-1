package com.team3.baby.module.fragments_home.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.team3.baby.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeSeekActivity extends AppCompatActivity {

    @BindView(R.id.home_seek_return_image)
    ImageView mHomeSeekReturnImage;
    @BindView(R.id.home_seek_voice_text)
    ImageView mHomeSeekVoiceText;
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
    }


}
