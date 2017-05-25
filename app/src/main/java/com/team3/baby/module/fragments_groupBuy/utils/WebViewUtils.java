package com.team3.baby.module.fragments_groupBuy.utils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.team3.baby.R;

/**
 * webview
 */
public class WebViewUtils extends AppCompatActivity {
    private WebView mwebview;
    private ImageView webview_webviewutils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_utils);
        initView();
        mwebview = (WebView) findViewById(R.id.id_webview);
        mwebview.getSettings().setJavaScriptEnabled(true);//设置WebView属性，能够执行Javascript脚本
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mwebview.loadUrl(url);                  //加载需要显示的网页
        mwebview.setWebViewClient(new HelloWebViewClient());       //设置Web视图
    }

    private void initView() {
        webview_webviewutils = (ImageView) findViewById(R.id.webview_webviewutils);
        webview_webviewutils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
