package com.example.guardian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    EditText Name,Email,Password,Phone,DOB,em_Name,em_Email,em_Phone;
    Button Register;
    TextView goto_login;

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


        goto_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
