package com.example.guardian.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guardian.model.GlobalClass;
import com.example.guardian.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class AreaStats extends AppCompatActivity {
    TextView address_pin, address_loc,  assaultPrediction, kidnapPrediction, theftPrediction,warning;
    ImageView graph, logo_top;
    View v1, v2, v3;
   String Morning_Prediction_data = "{\n" +
           "  \"Prediction\": [\n" +
           "    {\n" +
           "      \"Place\": \"Banashankari\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Basavangudi\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"C.K. Achuktu\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"GIRINAGAR PS\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Hanumantha Nagar PS\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"J P NAGAR\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Jayanagar\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"k g nagar\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"K S Layout\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Konanakunte\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Puttenahalli\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Shankarapura\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Siddapura\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Subramanyapura\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Thalaghtapura\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"VV Puram\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    }\n" +
           "  ]\n" +
           "}";
   String Afternoon_Prediction_data = "{\n" +
           "  \"Prediction\": [\n" +
           "    {\n" +
           "      \"Place\": \"Banashankari\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Basavangudi\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"C.K. Achuktu\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"GIRINAGAR PS\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Hanumantha Nagar PS\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"J P NAGAR\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Jayanagar\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"k g nagar\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"K S Layout\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Konanakunte\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Puttenahalli\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Shankarapura\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Siddapura\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Subramanyapura\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Thalaghtapura\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"VV Puram\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    }\n" +
           "  ]\n" +
           "}";
   String Evening_Prediction_data = "{\n" +
           "  \"Prediction\": [\n" +
           "    {\n" +
           "      \"Place\": \"Banashankari\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Basavangudi\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"C.K. Achuktu\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"GIRINAGAR PS\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Hanumantha Nagar PS\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"J P NAGAR\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Jayanagar\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"k g nagar\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"K S Layout\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Konanakunte\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Puttenahalli\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Shankarapura\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Siddapura\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Subramanyapura\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Thalaghtapura\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"VV Puram\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    }\n" +
           "  ]\n" +
           "}";
   String Night_Prediction_data = "{\n" +
           "  \"Prediction\": [\n" +
           "    {\n" +
           "      \"Place\": \"Banashankari\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Basavangudi\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"C.K. Achuktu\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"GIRINAGAR PS\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Hanumantha Nagar PS\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"J P NAGAR\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Jayanagar\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"k g nagar\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"K S Layout\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Konanakunte\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Puttenahalli\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Shankarapura\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Siddapura\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Subramanyapura\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"High\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"Thalaghtapura\",\n" +
           "      \"Assault Predection\": \"High\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"Low\"\n" +
           "    },\n" +
           "    {\n" +
           "      \"Place\": \"VV Puram\",\n" +
           "      \"Assault Predection\": \"Low\",\n" +
           "      \"Kidnap Predection\": \"Low\",\n" +
           "      \"Theft Predection\": \"High\"\n" +
           "    }\n" +
           "  ]\n" +
           "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_stats);

        v1 = findViewById(R.id.view_1);
        v2 = findViewById(R.id.view_2);
        v3 = findViewById(R.id.view_3);

        address_pin = findViewById(R.id.address_pin);
        address_loc = findViewById(R.id.address_loc);
        graph = findViewById(R.id.graph);
        logo_top = findViewById(R.id.logo_top);
        warning = findViewById(R.id.warning);
        assaultPrediction = findViewById(R.id.assault_pre);
        kidnapPrediction = findViewById(R.id.kidnaping_pre);
        theftPrediction = findViewById(R.id.theft_pre);

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

         //To add Checking based on the Postal code of the area
        //String PIN = address_pin.getText().toString().trim();
        // int pin = Integer.parseInt(PIN);

        String Location = address_loc.getText().toString().trim();



        Calendar rightNow = Calendar.getInstance();
        int currentHourIn24Format = rightNow.get(Calendar.HOUR_OF_DAY);

        try
        {int i=0;
            switch (Location) {
                case "Banashankari":
                    i = 0;
                    break;
                case "Basavangudi":
                    i = 1;
                    break;
                case "C.K. Achuktu":
                    i = 2;
                    break;
                case "GIRINAGAR":
                    i = 3;
                    break;
                case "Hanumantha Nagar":
                    i = 4;
                    break;
                case "J. P. Nagar":
                    i = 5;
                    break;
                case "Jayanagar":
                    i = 6;
                    break;
                case "k g nagar":
                    i = 7;
                    break;
                case "K S Layout":
                    i = 8;
                    break;
                case "Konanakunte":
                    i = 9;
                    break;
                case "Puttenahalli":
                    i = 10;
                    break;
                case "Shankarapura":
                    i = 11;
                    break;
                case "Siddapura":
                    i = 12;
                    break;
                case "Subramanyapura":
                    i = 13;
                    break;
                case "Talaghattapura":
                    i = 14;
                    break;
                case "VV Puram":
                    i = 15;
                    break;
                case "null":
                    assaultPrediction.setVisibility(View.INVISIBLE);
                    kidnapPrediction.setVisibility(View.INVISIBLE);
                    theftPrediction.setVisibility(View.INVISIBLE);
                    warning.setVisibility(View.VISIBLE);
                    v1.setVisibility(View.INVISIBLE);
                    v2.setVisibility(View.INVISIBLE);
                    v3.setVisibility(View.INVISIBLE);

            }

            if (currentHourIn24Format >=6 && currentHourIn24Format<12){
                JSONObject jsonObject = new JSONObject(Morning_Prediction_data);

                JSONArray jsonArray = jsonObject.getJSONArray("Prediction");

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String assault = jsonObject1.getString("Assault Predection");
                    String kidnap = jsonObject1.getString("Kidnap Predection");
                    String theft = jsonObject1.getString("Theft Predection");

                    assaultPrediction.setText(String.format("%s %s %s", getString(R.string.assault_msg_1), assault, getString(R.string.msg_2)));
                    kidnapPrediction.setText(String.format("%s %s %s", getString(R.string.kidnap_msg_1), kidnap, getString(R.string.msg_2)));
                    theftPrediction.setText(String.format("%s %s %s", getString(R.string.theft_msg_1), theft, getString(R.string.msg_2)));

            }
            else if(currentHourIn24Format>=12 && currentHourIn24Format<17){
                JSONObject jsonObject = new JSONObject(Afternoon_Prediction_data);
                JSONArray jsonArray = jsonObject.getJSONArray("Prediction");

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String assault = jsonObject1.getString("Assault Predection");
                    String kidnap = jsonObject1.getString("Kidnap Predection");
                    String theft = jsonObject1.getString("Theft Predection");

                    assaultPrediction.setText(String.format("%s %s %s", getString(R.string.assault_msg_1), assault, getString(R.string.msg_2)));
                    kidnapPrediction.setText(String.format("%s %s %s", getString(R.string.kidnap_msg_1), kidnap, getString(R.string.msg_2)));
                    theftPrediction.setText(String.format("%s %s %s", getString(R.string.theft_msg_1), theft, getString(R.string.msg_2)));


            }
            else if (currentHourIn24Format>=17 && currentHourIn24Format<21){
                JSONObject jsonObject = new JSONObject(Evening_Prediction_data);
                JSONArray jsonArray = jsonObject.getJSONArray("Prediction");

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String assault = jsonObject1.getString("Assault Predection");
                    String kidnap = jsonObject1.getString("Kidnap Predection");
                    String theft = jsonObject1.getString("Theft Predection");

                    assaultPrediction.setText(String.format("%s %s %s", getString(R.string.assault_msg_1), assault, getString(R.string.msg_2)));
                    kidnapPrediction.setText(String.format("%s %s %s", getString(R.string.kidnap_msg_1), kidnap, getString(R.string.msg_2)));
                    theftPrediction.setText(String.format("%s %s %s", getString(R.string.theft_msg_1), theft, getString(R.string.msg_2)));


            }
            else {
                JSONObject jsonObject = new JSONObject(Night_Prediction_data);
                JSONArray jsonArray = jsonObject.getJSONArray("Prediction");

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String assault = jsonObject1.getString("Assault Predection");
                    String kidnap = jsonObject1.getString("Kidnap Predection");
                    String theft = jsonObject1.getString("Theft Predection");

                    assaultPrediction.setText(String.format("%s %s %s", getString(R.string.assault_msg_1), assault, getString(R.string.msg_2)));
                    kidnapPrediction.setText(String.format("%s %s %s", getString(R.string.kidnap_msg_1), kidnap, getString(R.string.msg_2)));
                    theftPrediction.setText(String.format("%s %s %s", getString(R.string.theft_msg_1), theft, getString(R.string.msg_2)));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        switch (Location) {
            case "Banashankari":
                graph.setBackgroundResource(R.drawable.bsk_grapk);
                break;
            case "Basavangudi":
                graph.setBackgroundResource(R.drawable.basva_graph);
                break;
            case "C.K. Achuktu":
                graph.setBackgroundResource(R.drawable.ck_ghraph);
                break;
            case "Girinagar":
                graph.setBackgroundResource(R.drawable.giri_graph);
                break;
            case "Hanumantha Nagar":
                graph.setBackgroundResource(R.drawable.hanuman_graph);
                break;
            case "J. P. Nagar":
                graph.setBackgroundResource(R.drawable.jp_graph);
                break;
            case "Jayanagar":
                graph.setBackgroundResource(R.drawable.jaya_graph);
                break;
            case "k g nagar":
                graph.setBackgroundResource(R.drawable.kgn_graph);
                break;
            case "K S Layout":
                graph.setBackgroundResource(R.drawable.ks_graph);
                break;
            case "Konanakunte":
                graph.setBackgroundResource(R.drawable.kk_graph);
                break;
            case "Puttenahalli":
                graph.setBackgroundResource(R.drawable.pth_graph);
                break;
            case "Shankarapura":
                graph.setBackgroundResource(R.drawable.skp_graph);
                break;
            case "Siddapura":
                graph.setBackgroundResource(R.drawable.sidd_graph);
                break;
            case "Subramanyapura":
                graph.setBackgroundResource(R.drawable.sub_graph);
                break;
            case "Talaghattapura":
                graph.setBackgroundResource(R.drawable.tlght_graph);
                break;
            case "VV Puram":
                graph.setBackgroundResource(R.drawable.vvp_graph);
                break;
            default:graph.setVisibility(View.INVISIBLE);

        }

    }
}
