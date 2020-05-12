package com.example.guardian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class emergencyCall extends AppCompatActivity {
    ImageView top_logo;
    CardView Senior, Women, Traffic, Auto, Commissioner, Tourist, Eme_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_call);

        top_logo = findViewById(R.id.logo_top);
        Senior = findViewById(R.id.cardView_call_senior);
        Women = findViewById(R.id.cardView_call_women);
        Traffic = findViewById(R.id.cardView_call_traffic);
        Auto = findViewById(R.id.cardView_call_auto);
        Commissioner = findViewById(R.id.cardView_call_commissioner);
        Tourist = findViewById(R.id.cardView_call_tourist);
        Eme_1 = findViewById(R.id.cardView_call_em_1);

        top_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(emergencyCall.this, Home.class);
                startActivity(intent);
            }
        });
        Eme_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                final GlobalClass globalVariable =(GlobalClass)getApplicationContext();
                String em1_phone = globalVariable.getEm_1();
                callIntent.setData(Uri.parse("tel:" + em1_phone));
                startActivity(callIntent);
            }
        });

        Senior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + 1090));
                startActivity(callIntent);
            }
        });
        Women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + 1099));
                startActivity(callIntent);
            }
        });
        Traffic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ 8022943030L));
                startActivity(callIntent);
            }
        });
        Auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ 8025588444L));
                startActivity(callIntent);
            }
        });
        Commissioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ 22256242));
                startActivity(callIntent);
            }
        });
        Tourist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ 22212901));
                startActivity(callIntent);
            }
        });
    }
}
