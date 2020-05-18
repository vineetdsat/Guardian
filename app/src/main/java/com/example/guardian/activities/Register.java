package com.example.guardian.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guardian.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    static final String TAG = "YOUR-TAG-NAME";
    EditText Name,Email,Password,Phone,DOB,em_Name,em_Email,em_Phone;
    Button Register;
    TextView goto_login;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Name = findViewById(R.id.r_et_name);
        Email = findViewById(R.id.r_et_email);
        Password = findViewById(R.id.r_et_pass);
        Phone = findViewById(R.id.r_et_phone);
        DOB = findViewById(R.id.r_et_dob);
        em_Name = findViewById(R.id.r_et_em_name);
        em_Email = findViewById(R.id.r_et_em_email);
        em_Phone = findViewById(R.id.r_et_em_phone);
        Register = findViewById(R.id.r_bt_reg);
        goto_login = findViewById(R.id.r_tv);



        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressb_register);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),Home.class));
            finish();
        }


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = Email.getText().toString().trim();
                String pass = Password.getText().toString().trim();
                final String name = Name.getText().toString().trim();
                final String phone = Phone.getText().toString().trim();
                final String dob = DOB.getText().toString().trim();
                final String em_name = em_Name.getText().toString().trim();
                final String em_email = em_Email.getText().toString().trim();
                final String em_phone = em_Phone.getText().toString().trim();


                if (TextUtils.isEmpty(email)){
                    Email.setError("Email is Required");
                }
                if (TextUtils.isEmpty(pass)){
                    Password.setError("Password is Empty");
                }
                if (pass.length() <= 6){
                    Password.setError("Password must be Greater than or Equal to SIX characters!");
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("Name",name);
                            user.put("Email",email);
                            user.put("Phone",phone);
                            user.put("D.O.B",dob);
                            user.put("Em_Name",em_name);
                            user.put("Em_Email",em_email);
                            user.put("Em_Phone",em_phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"OnSuccess: User Profile is Created for "+ userID);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else {
                            Toast.makeText(Register.this, "Error Occurred !" + task.getException(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });


        goto_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
