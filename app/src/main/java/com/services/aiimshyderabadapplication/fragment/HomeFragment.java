package com.services.aiimshyderabadapplication.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.services.aiimshyderabadapplication.Activity.AboutActivity;
import com.services.aiimshyderabadapplication.Activity.AccomodationActivity;
import com.services.aiimshyderabadapplication.Activity.CommiteeActivity;
import com.services.aiimshyderabadapplication.Activity.ESouvenirActivity;
import com.services.aiimshyderabadapplication.Activity.HighlightsActivity;
import com.services.aiimshyderabadapplication.Activity.ScientificProgramActivity;
import com.services.aiimshyderabadapplication.Activity.SponsorsActivity;
import com.services.aiimshyderabadapplication.R;
import com.services.aiimshyderabadapplication.Activity.VenueActivity;
import com.services.aiimshyderabadapplication.connection.NetworkConnectivity;

public class HomeFragment extends Fragment {

    CardView about_btn,committee_btn,venue_btn,accoumodation_btn,scientificprogram_btn,highlights_btn,
    sponsors_btn,eSouvenir;

    ViewFlipper viewFlipper;
    int imgarray[] = {R.drawable.ramujifilm, R.drawable.hussin, R.drawable.chairminar,R.drawable.gongafort,R.drawable.statuofequality,R.drawable.kutubtom};


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        about_btn=view.findViewById(R.id.about);
        committee_btn=view.findViewById(R.id.commitee);
        venue_btn=view.findViewById(R.id.venue_cardview);
        accoumodation_btn=view.findViewById(R.id.accomodation_card);
        scientificprogram_btn=view.findViewById(R.id.scientificprogram_card);
        highlights_btn=view.findViewById(R.id.highlights_card);
        sponsors_btn=view.findViewById(R.id.sponsors_card);
        eSouvenir=view.findViewById(R.id.eSouvenir_card);
        dialog(false);

        //card button

        sponsors_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getContext(), SponsorsActivity.class);
                startActivity(intent1);
            }
        });
        eSouvenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getContext(), ESouvenirActivity.class);
                startActivity(intent1);
            }
        });

        highlights_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getContext(), HighlightsActivity.class);
                startActivity(intent1);
            }
        });

        scientificprogram_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getContext(), ScientificProgramActivity.class);
                startActivity(intent1);
            }
        });

        accoumodation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getContext(), AccomodationActivity.class);
                startActivity(intent1);
            }
        });

        venue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getContext(), VenueActivity.class);
                startActivity(intent1);
            }
        });
        committee_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CommiteeActivity.class);
                startActivity(intent);
            }
        });

        about_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AboutActivity.class);
                startActivity(intent);

            }
        });


        //slider
        viewFlipper = view.findViewById(R.id.filpeer);
        for (int i = 0; i < imgarray.length; i++) {
            setFlipperImage(imgarray[i]);

        }

    return view;
    }

    private void dialog(boolean b) {

        boolean networkConectivity = NetworkConnectivity.isConnected(getContext());
        if (networkConectivity) {

        } else {
            NetworkConnectivity.networkConnetivityShowDialog(getContext());

        }
    }

    private void setFlipperImage(int res) {

        ImageView image = new ImageView(getContext());
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

    }
}