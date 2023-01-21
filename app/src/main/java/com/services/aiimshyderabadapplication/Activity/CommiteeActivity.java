package com.services.aiimshyderabadapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.services.aiimshyderabadapplication.R;
import com.services.aiimshyderabadapplication.connection.NetworkConnectivity;

public class CommiteeActivity extends AppCompatActivity {
    LinearLayout back_btn;
    CardView organizingcommittee_cardView,officebrares_cardView,natinalAdvisoryboard_cardView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commitee);
        back_btn=findViewById(R.id.commiteelayout_back);
        organizingcommittee_cardView=findViewById(R.id.organizingcommittee_cardView);
        officebrares_cardView=findViewById(R.id.officebrares_cardView);
        natinalAdvisoryboard_cardView=findViewById(R.id.natinalAdvisoryboard_cardView);
        dialog(false);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommiteeActivity.this, DashBordsActivity.class);
                startActivity(intent);
            }
        });

        organizingcommittee_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommiteeActivity.this, OrganizingCommiteeActivity.class);
                startActivity(intent);
            }
        });
        officebrares_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommiteeActivity.this, OfficeBrareActivitys.class);
                startActivity(intent);
            }
        });

        natinalAdvisoryboard_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommiteeActivity.this, NationalAdvisoryBoardActivity.class);
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
        Intent intent = new Intent(CommiteeActivity.this, DashBordsActivity.class);
        startActivity(intent);

    }
}