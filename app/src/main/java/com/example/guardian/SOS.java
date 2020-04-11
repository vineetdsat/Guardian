package com.example.guardian;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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

public class SOS extends AppCompatActivity {
    ImageView logo_top;
    TextView name, email,phone;
    Button sos;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        ActivityCompat.requestPermissions(SOS.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        logo_top = findViewById(R.id.logo_top);
        name = findViewById(R.id.tv_disp_name);
        email = findViewById(R.id.tv_disp_email);
        phone = findViewById(R.id.tv_disp_phone);
        sos = findViewById(R.id.bt_sos);
        textMessage = findViewById(R.id.text_msg);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                phone.setText(documentSnapshot.getString("Em_Phone"));
                name.setText(documentSnapshot.getString("Em_Name"));
                email.setText(documentSnapshot.getString("Em_Email"));
            }
        });
        logo_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SOS.this, Home.class);
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
