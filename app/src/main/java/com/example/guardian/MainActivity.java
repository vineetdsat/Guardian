package com.example.guardian;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText Email,Password;
    Button Login;
    TextView goto_reg;
    ProgressBar progress;
    FirebaseAuth fAuth;
    CheckBox Remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = findViewById(R.id.l_et_email);
        Password = findViewById(R.id.l_et_pass);
        Login = findViewById(R.id.l_bt_login);
        goto_reg = findViewById(R.id.l_tv);
        progress = findViewById(R.id.progressb_login);
        Remember = findViewById(R.id.checkbox_remember);

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");
        if (checkbox.equals("true")){
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else if (checkbox.equals("false")){
            Toast.makeText(MainActivity.this,"Please Sign In", Toast.LENGTH_SHORT).show();
        }



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String pass = Password.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Email.setError("Email is Required");
                }
                if (TextUtils.isEmpty(pass)){
                    Password.setError("Password is Empty");
                }
                if (pass.length() <= 6){
                    Password.setError("Password must be Greater than or Equal to SIX characters!");
                }
                progress.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Logged IN!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Home.class));
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Error Occurred !" + task.getException(), Toast.LENGTH_SHORT).show();
                            progress.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });
        Remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","true");
                    editor.apply();
                    Toast.makeText(MainActivity.this,"Checked",Toast.LENGTH_SHORT).show();

                }
                else if (!buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                    Toast.makeText(MainActivity.this,"Unchecked",Toast.LENGTH_SHORT).show();
                }
            }
        });




        goto_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }
}
