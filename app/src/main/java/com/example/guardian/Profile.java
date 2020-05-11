package com.example.guardian;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Profile extends AppCompatActivity {
    static final String TAG = "YOUR-TAG-NAME";
    ImageView logo_top;
    EditText Name,em_Name,Email,Phone,em_Email,em_Phone;
    Button Update;
    TextView Top;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        logo_top = findViewById(R.id.logo_top);
        Name = findViewById(R.id.update_name);
        em_Name = findViewById(R.id.update_em_name);
        em_Email = findViewById(R.id.update_em_email);
        em_Phone = findViewById(R.id.update_em_phone);
        Email = findViewById(R.id.update_email);
        Phone = findViewById(R.id.update_phone);

        Update = findViewById(R.id.bt_update);
        Top = findViewById(R.id.top_navig);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                assert documentSnapshot != null;
                Name.setText(documentSnapshot.getString("Name"));
                em_Name.setText(documentSnapshot.getString("Em_Name"));
                Phone.setText(documentSnapshot.getString("Phone"));
                Email.setText(documentSnapshot.getString("Email"));
                em_Email.setText(documentSnapshot.getString("Em_Email"));
                em_Phone.setText(documentSnapshot.getString("Em_Phone"));
            }
        });

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = Email.getText().toString().trim();
                final String u_em_name = em_Name.getText().toString().trim();
                final String u_em_email = em_Email.getText().toString().trim();
                final String u_em_phone = em_Phone.getText().toString().trim();
                final String name = Name.getText().toString().trim();
                final String phone = Phone.getText().toString().trim();
                userID = fAuth.getCurrentUser().getUid();
                DocumentReference documentReference = fStore.collection("users").document(userID);


                Map<String,Object> user = new HashMap<>();
                user.put("Name",name);
                user.put("Email",email);
                user.put("Phone",phone);
                user.put("Em_Name",u_em_name);
                user.put("Em_Email",u_em_email);
                user.put("Em_Phone",u_em_phone);
                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG,"OnSuccess: User Profile is Updated "+ userID);
                        Toast.makeText(Profile.this,"Profile Updated",Toast.LENGTH_SHORT).show();
                    }
                });
                startActivity(new Intent(getApplicationContext(),Home.class));
            }
        });
        logo_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Home.class);
                startActivity(intent);
            }
        });
    }
}
