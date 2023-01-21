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

public class OrganizingCommiteeActivity extends AppCompatActivity {
    WebView webView;
    LinearLayout linearLayoutback_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizing_commitee);
        linearLayoutback_btn=findViewById(R.id.organizationcommittee_back);
        dialog(false);

        webView = findViewById(R.id.oraganisingcommitee_web);
        webView.loadUrl("https://www.iapsmcon2023.com/organizing_committee.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        linearLayoutback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrganizingCommiteeActivity.this,CommiteeActivity.class);
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
        Intent intent = new Intent(OrganizingCommiteeActivity.this,CommiteeActivity.class);
        startActivity(intent);

    }
}