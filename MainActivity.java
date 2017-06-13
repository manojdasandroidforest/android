package com.example.manojdas.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import org.apache.http.util.EncodingUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=new Intent(getBaseContext(),WebViewActivity.class);
        i.putExtra("URL","http://www.google.com");
        startActivity(i);

        /*String uri = Uri.parse("http://httpbin.org/post")
                .buildUpon()
                .appendQueryParameter("param1", "param1")
                .appendQueryParameter("param2", "parma2")
                .build().toString();
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(browserIntent);*/
    }
}
