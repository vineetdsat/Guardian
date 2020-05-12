package com.example.guardian;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;

public class SOS extends AppCompatActivity {

    ImageView logo_top;
    TextView name, email,phone;
    Button sos, call;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    TextView textMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        ActivityCompat.requestPermissions(SOS.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS,Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);

        logo_top = findViewById(R.id.logo_top);
        name = findViewById(R.id.tv_disp_name);
        email = findViewById(R.id.tv_disp_email);
        phone = findViewById(R.id.tv_disp_phone);
        sos = findViewById(R.id.bt_sos);
        call = findViewById(R.id.bt_em_call);
        textMessage = findViewById(R.id.text_msg);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();

        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                assert documentSnapshot != null;
                phone.setText(documentSnapshot.getString("Em_Phone"));

                final GlobalClass globalVariable = (GlobalClass)getApplicationContext();
                final double Latitude = globalVariable.getLat();
                final double Longitude = globalVariable.getLng();


                name.setText(documentSnapshot.getString("Em_Name"));
                email.setText(documentSnapshot.getString("Em_Email"));

                String Longi = Double.toString(Longitude);
                String Lati = Double.toString(Latitude);
                textMessage.setText(String.format("%s%s,%s", getString(R.string.msg), Lati, Longi));
            }
        });


        logo_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SOS.this, Home.class);
                startActivity(intent);

            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final GlobalClass globalVariable =(GlobalClass)getApplicationContext();
                String em_number =  phone.getText().toString().trim();
                globalVariable.setEm_1(em_number);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + em_number));
                startActivity(intent);
            }
        });
    }
    public void sendSMS(View view){

        String message = textMessage.getText().toString();
        String number = phone.getText().toString();

        SmsManager mySmsManager = SmsManager.getDefault();
        mySmsManager.sendTextMessage(number,null, message, null, null);
    }
}
