package com.dexmp.corclub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView main_corclub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.main_corclub.canGoBack()) {
            this.main_corclub.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void show() {
        main_corclub.setVisibility(View.VISIBLE);
        main_corclub.getSettings().setJavaScriptEnabled(true);
        WebSettings webSettings = main_corclub.getSettings();
        webSettings.setJavaScriptEnabled(true);

        SimpleWebClientForCor webViewClient = new SimpleWebClientForCor(this);
        main_corclub.setWebViewClient(webViewClient);

        main_corclub.loadUrl("https://corclub.best");
    }

    private void initData() {
        main_corclub = findViewById(R.id.main_corclub);
    }
}