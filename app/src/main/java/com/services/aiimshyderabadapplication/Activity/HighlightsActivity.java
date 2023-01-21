package com.services.aiimshyderabadapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.services.aiimshyderabadapplication.R;
import com.services.aiimshyderabadapplication.connection.NetworkConnectivity;

public class HighlightsActivity extends AppCompatActivity {
    WebView webView;

    LinearLayout linearLayoutback_btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlights);
        dialog(false);
        webView = findViewById(R.id.highlight_web);


        webView.loadUrl("https://whizsoftwares.in/IAPSM2023Highlights/");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        linearLayoutback_btn = findViewById(R.id.highlights_back);

        linearLayoutback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DashBordsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void dialog(boolean b) {
        boolean networkConectivity = NetworkConnectivity.isConnected(this);
        if (networkConectivity) {
            //loadingDialogBar.setVisibility(View.VISIBLE);
            // Grid(Grid_URL,flag);
        } else {
            NetworkConnectivity.networkConnetivityShowDialog(this);

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HighlightsActivity.this, DashBordsActivity.class);
        startActivity(intent);

    }
}