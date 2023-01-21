package com.services.aiimshyderabadapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.services.aiimshyderabadapplication.R;
import com.services.aiimshyderabadapplication.connection.NetworkConnectivity;
import com.services.aiimshyderabadapplication.fragment.HomeFragment;
import com.services.aiimshyderabadapplication.navigation.ContactUsActivity;
import com.services.aiimshyderabadapplication.navigation.HelpSportsActivity;
import com.services.aiimshyderabadapplication.navigation.KeyNosActivity;
import com.services.aiimshyderabadapplication.navigation.ParticipantActivity;

public class DashBordsActivity extends AppCompatActivity {
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    TextView nametext,mobileNumbertxt;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_bords);

        dialog(false);


        drawerLayout=findViewById(R.id.drawer);
        Toolbar toolbar=findViewById(R.id.toolsbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        //navigationView=findViewById(R.id.navmenu);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navmenu);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectFragment=null;
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                getSupportActionBar().setHomeButtonEnabled(true);
                switch (item.getItemId()) {

                    case R.id.home:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.participants:
                        Intent intent1 = new Intent(getApplicationContext(), ParticipantActivity.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;


                    case R.id.keynos:
                        Intent keynosIntent = new Intent(getApplicationContext(), KeyNosActivity.class);
                        startActivity(keynosIntent);

                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.contactus:

                        Intent contactintent = new Intent(getApplicationContext(), ContactUsActivity.class);
                        startActivity(contactintent);

                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.help:

                        Intent intenthelp = new Intent(getApplicationContext(), HelpSportsActivity.class);
                        startActivity(intenthelp);

                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }
                return true;
            }
        });


    }
    @Override
    public void onBackPressed() {

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
       // AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //        builder.setCancelable(false);
        //        builder.setTitle("Exit");
        //        builder.setMessage("Do you want to Exit?");
        //        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        //            @Override
        //            public void onClick(DialogInterface dialog, int which) {
        //                Intent a = new Intent(Intent.ACTION_MAIN);
        //                a.addCategory(Intent.CATEGORY_HOME);
        //                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //                startActivity(a);
        //                finish();
        //            }
        //        });
        //        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
        //            @Override
        //            public void onClick(DialogInterface dialog, int which) {
        //                //if user select "No", just cancel this dialog and continue with app
        //                dialog.cancel();
        //            }
        //        });
        //        AlertDialog alert=builder.create();
        //        alert.show();
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



}