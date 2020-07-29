package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    String[] web={"https://youtu.be/xXEx0DyIMks","https://youtu.be/kJQP7kiw5Fk","https://youtu.be/AJtDXIazrMo"   };
    WebView web_v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String website=web[getIntent().getIntExtra("code",0)];
        web_v=findViewById(R.id.web_v);
        web_v.setWebViewClient(new WebViewClient());
        web_v.getSettings().setJavaScriptEnabled(true);
        web_v.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        web_v.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        web_v.getSettings().setAppCacheEnabled(true);
        web_v.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web_v.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        web_v.getSettings().setEnableSmoothTransition(true);
        web_v.getSettings().setLoadsImagesAutomatically(true);
        web_v.loadUrl(website);

    }
}
