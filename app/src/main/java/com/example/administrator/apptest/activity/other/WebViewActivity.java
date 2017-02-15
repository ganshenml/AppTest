package com.example.administrator.apptest.activity.other;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.example.administrator.apptest.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView webview;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view2);
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);

        webview = new WebView(getApplicationContext());
        webview.getSettings().setJavaScriptEnabled(true);
        linearLayout.addView(webview);

        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setBlockNetworkImage(false);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://mtest.zczj.com/zhongchou/appDetail/1273");
//          webview.loadUrl("https://www.baidu.com");

    }
}
