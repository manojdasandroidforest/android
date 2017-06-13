package com.example.manojdas.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import org.apache.http.util.EncodingUtils;

/**
 * Created by MHBL-81 on 16-02-2016.
 */
public class WebViewActivity extends AppCompatActivity {

    private static final String TAG = "WebViewActivity";

    private String mUrl ="",mTitle="";

    WebView mWebView;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        mUrl = getIntent().getStringExtra("URL");


        //Log.e("URL   :-",mUrl);

        if (null != mUrl) {
            mWebView = new WebView(this);
            //byte[] post = EncodingUtils.getBytes("postvariable=value&nextvar=value2", "BASE64");
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.setWebChromeClient(new WebChromeClient());
            //mWebView.postUrl("http://httpbin.org/post", post);
            mWebView.loadUrl(mUrl);
            mWebView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    //mProgressBar.setVisibility(View.VISIBLE);
                }

                public void onPageFinished(WebView view, String url) {
                    //mProgressBar.setVisibility(View.GONE);
                }
            });

            setContentView(mWebView);
        } else {
            finish(); // close this activity
        }
    }


    @Override
    public void onBackPressed() {
        if (mWebView.isFocused() && mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
            finish();
        }
    }



}
