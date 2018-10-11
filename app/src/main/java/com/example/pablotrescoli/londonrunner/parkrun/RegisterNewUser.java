package com.example.pablotrescoli.londonrunner.parkrun;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.pablotrescoli.londonrunner.R;
@SuppressLint("SetJavaScriptEnabled")
public class RegisterNewUser extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        WebView webView = findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getString(R.string.parkrun_register_url));

    }

}