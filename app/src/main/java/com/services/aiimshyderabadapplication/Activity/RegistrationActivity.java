 package com.services.aiimshyderabadapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.services.aiimshyderabadapplication.R;
import com.services.aiimshyderabadapplication.connection.NetworkConnectivity;

 public class RegistrationActivity extends AppCompatActivity {
     Button btn;

     EditText  editTextmobilenumber;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn_enter);
        editTextmobilenumber=findViewById(R.id.mobilenumber);
         dialog(false);

      PersonRegistration();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextmobilenumber.getText().toString().trim().isEmpty()){
                    dialogus();
                }else if(editTextmobilenumber.getText().toString().trim().length() !=10){
                    Toast.makeText(RegistrationActivity.this,"Type Valid Phone Number ",Toast.LENGTH_SHORT).show();
                }else {
                    String mobileno = editTextmobilenumber.getText().toString();
                    //Intent intent = new Intent(RegistrationActivity.this, ProfileActivity.class);
                   //ntent.putExtra("mobileno",mobileno);
                   //tartActivity(intent);

                }



            }

        });
    }

     private void PersonRegistration() {


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

     private void dialogus() {

         AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity.this);


         builder.setMessage("Please add mobile number");


         builder.setTitle("Error !!!");

         builder.setCancelable(false);
//  builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
//             // When the user click yes button then app will close
//             finish();
//         });


         builder.setNegativeButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
             dialog.cancel();
         });

         AlertDialog alertDialog = builder.create();
         alertDialog.show();
     }
     }
