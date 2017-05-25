package com.team3.baby.module.fragments_groupBuy.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.team3.baby.R;

public class WebViewUtils extends AppCompatActivity {
    private WebView mwebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_utils);
        mwebview = (WebView) findViewById(R.id.id_webview);
        mwebview.getSettings().setJavaScriptEnabled(true);//设置WebView属性，能够执行Javascript脚本
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mwebview.loadUrl(url);                  //加载需要显示的网页
        mwebview.setWebViewClient(new HelloWebViewClient());       //设置Web视图
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
