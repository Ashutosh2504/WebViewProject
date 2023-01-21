package com.services.aiimshyderabadapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.services.aiimshyderabadapplication.R;
import com.services.aiimshyderabadapplication.connection.NetworkConnectivity;
import com.services.aiimshyderabadapplication.fragment.HomeFragment;

public class AboutActivity extends AppCompatActivity {
    ImageView btn_patronDown,btn_organizingdown,btn_OrganizingViceChairperson_down,btn_OrganizingSecretary_down;
    LinearLayout hiddenView, hiddenView1, hiddenView2, hiddenView3;
    CardView cardView,cardView1,cardView2,cardView3;
    LinearLayout back_btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        dialog(false);
        back_btn=findViewById(R.id.layout_back);
        btn_patronDown=findViewById(R.id.patrondown);
        btn_organizingdown=findViewById(R.id.organizingdown);
        btn_OrganizingViceChairperson_down=findViewById(R.id.OrganizingViceChairperson_down);
        btn_OrganizingSecretary_down=findViewById(R.id.OrganizingSecretary_down);
        cardView = findViewById(R.id.base_cardview);
        cardView1=findViewById(R.id.organizing_cardview);
        cardView2=findViewById(R.id.OrganizingViceChairperson_cardview);
        cardView3=findViewById(R.id.OrganizingSecretary_cardview);

        hiddenView = findViewById(R.id.hidden_view);
        hiddenView1=findViewById(R.id.hidden_view1);
        hiddenView2=findViewById(R.id.hidden_view2);
        hiddenView3=findViewById(R.id.hidden_view3);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutActivity.this, DashBordsActivity.class);
                startActivity(intent);
            }
        });

        btn_patronDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView.getVisibility() == View.VISIBLE) {

             //       TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    hiddenView.setVisibility(View.GONE);
                    //btn_patronDown.setImageResource(R.drawable.down);
                } else {
               //     TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    hiddenView.setVisibility(View.VISIBLE);
                  //  btn_patronDown.setImageResource(R.drawable.uparrow);
                }

            }
        });
        btn_organizingdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView1.getVisibility() == View.VISIBLE) {

                    //TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
                    hiddenView1.setVisibility(View.GONE);
                    //btn_patronDown.setImageResource(R.drawable.down);
                } else {
                    //TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
                    hiddenView1.setVisibility(View.VISIBLE);
                //    btn_organizingdown.setImageResource(R.drawable.uparrow);
                }

            }
        });
        btn_OrganizingViceChairperson_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView2.getVisibility() == View.VISIBLE) {

                  //  TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                    hiddenView2.setVisibility(View.GONE);
                    //btn_patronDown.setImageResource(R.drawable.down);
                } else {
                    //TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                    hiddenView2.setVisibility(View.VISIBLE);
                    //    btn_organizingdown.setImageResource(R.drawable.uparrow);
                }

            }
        });
        btn_OrganizingSecretary_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView3.getVisibility() == View.VISIBLE) {

                    //TransitionManager.beginDelayedTransition(cardView3, new AutoTransition());
                    hiddenView3.setVisibility(View.GONE);
                    //btn_patronDown.setImageResource(R.drawable.down);
                } else {
                    //TransitionManager.beginDelayedTransition(cardView3, new AutoTransition());
                    hiddenView3.setVisibility(View.VISIBLE);
                    //    btn_organizingdown.setImageResource(R.drawable.uparrow);
                }
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
        Intent intent = new Intent(AboutActivity.this, DashBordsActivity.class);
        startActivity(intent);

    }
}