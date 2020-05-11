package com.example.guardian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AreaStats extends AppCompatActivity {
    TextView address_pin, address_loc;
    ImageView graph, logo_top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_stats);

        address_pin = findViewById(R.id.address_pin);
        address_loc = findViewById(R.id.address_loc);
        graph = findViewById(R.id.graph);
        logo_top = findViewById(R.id.logo_top);
        logo_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AreaStats.this, Home.class);
                startActivity(intent);
            }
        });

        final GlobalClass globalVariable = (GlobalClass)getApplicationContext();
        address_pin.setText(globalVariable.getAdd_pin());
        address_loc.setText(globalVariable.getAdd_loc());
        String PIN = address_pin.getText().toString().trim();
        int pin = Integer.parseInt(PIN);



        if(pin == 560070 || pin== 560085){
            graph.setBackgroundResource(R.drawable.graph_1);
        }
        else
            graph.setBackgroundResource(R.drawable.graph_2);

    }
}
