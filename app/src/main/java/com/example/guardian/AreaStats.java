package com.example.guardian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class AreaStats extends AppCompatActivity {
    TextView address_pin, address_loc,  assaultPrediction, kidnapPrediction, theftPrediction;
    ImageView graph, logo_top;
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

        address_pin = findViewById(R.id.address_pin);
        address_loc = findViewById(R.id.address_loc);
        graph = findViewById(R.id.graph);
        logo_top = findViewById(R.id.logo_top);

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

        String PIN = address_pin.getText().toString().trim();
        String Location = address_loc.getText().toString().trim();

       // int pin = Integer.parseInt(PIN);


        Calendar rightNow = Calendar.getInstance();
        int currentHourIn24Format = rightNow.get(Calendar.HOUR_OF_DAY);



        try
        {int i=0;
            switch (Location) {
                case "Banshankari":
                    i = 0;
                    break;
                case "Basavangudi":
                    i = 1;
                    break;
                case "C.K. Achuktu":
                    i = 2;
                    break;
                case "GIRINAGAR PS":
                    i = 3;
                    break;
                case "Hanumantha Nagar PS":
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
            }



            if (currentHourIn24Format >=6 && currentHourIn24Format<12){
                JSONObject jsonObject = new JSONObject(Morning_Prediction_data);

                JSONArray jsonArray = jsonObject.getJSONArray("Prediction");

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String place = jsonObject1.getString("Place");
                    String assault = jsonObject1.getString("Assault Predection");
                    String kidnap = jsonObject1.getString("Kidnap Predection");
                    String theft = jsonObject1.getString("Theft Predection");

                    assaultPrediction.setText(String.format("%s%s%s", getString(R.string.assault_msg_1), assault, getString(R.string.msg_2)));
                    kidnapPrediction.setText(String.format("%s%s%s", getString(R.string.kidnap_msg_1), kidnap, getString(R.string.msg_2)));
                    theftPrediction.setText(String.format("%s%s%s", getString(R.string.theft_msg_1), theft, getString(R.string.msg_2)));

            }
            else if(currentHourIn24Format>=12 && currentHourIn24Format<17){
                JSONObject jsonObject = new JSONObject(Afternoon_Prediction_data);
                JSONArray jsonArray = jsonObject.getJSONArray("Prediction");

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String place = jsonObject1.getString("Place");
                    String assault = jsonObject1.getString("Assault Predection");
                    String kidnap = jsonObject1.getString("Kidnap Predection");
                    String theft = jsonObject1.getString("Theft Predection");

                    assaultPrediction.setText(String.format("%s%s%s", getString(R.string.assault_msg_1), assault, getString(R.string.msg_2)));
                    kidnapPrediction.setText(String.format("%s%s%s", getString(R.string.kidnap_msg_1), kidnap, getString(R.string.msg_2)));
                    theftPrediction.setText(String.format("%s%s%s", getString(R.string.theft_msg_1), theft, getString(R.string.msg_2)));


            }
            else if (currentHourIn24Format>=17 && currentHourIn24Format<21){
                JSONObject jsonObject = new JSONObject(Evening_Prediction_data);
                JSONArray jsonArray = jsonObject.getJSONArray("Prediction");

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String place = jsonObject1.getString("Place");
                    String assault = jsonObject1.getString("Assault Predection");
                    String kidnap = jsonObject1.getString("Kidnap Predection");
                    String theft = jsonObject1.getString("Theft Predection");

                    assaultPrediction.setText(String.format("%s%s%s", getString(R.string.assault_msg_1), assault, getString(R.string.msg_2)));
                    kidnapPrediction.setText(String.format("%s%s%s", getString(R.string.kidnap_msg_1), kidnap, getString(R.string.msg_2)));
                    theftPrediction.setText(String.format("%s%s%s", getString(R.string.theft_msg_1), theft, getString(R.string.msg_2)));


            }
            else {
                JSONObject jsonObject = new JSONObject(Night_Prediction_data);
                JSONArray jsonArray = jsonObject.getJSONArray("Prediction");

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String place = jsonObject1.getString("Place");
                    String assault = jsonObject1.getString("Assault Predection");
                    String kidnap = jsonObject1.getString("Kidnap Predection");
                    String theft = jsonObject1.getString("Theft Predection");

                    assaultPrediction.setText(String.format("%s%s%s", getString(R.string.assault_msg_1), assault, getString(R.string.msg_2)));
                    kidnapPrediction.setText(String.format("%s%s%s", getString(R.string.kidnap_msg_1), kidnap, getString(R.string.msg_2)));
                    theftPrediction.setText(String.format("%s%s%s", getString(R.string.theft_msg_1), theft, getString(R.string.msg_2)));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        if(Location.equals("Banshankari")){
            graph.setBackgroundResource(R.drawable.graph_1);
        }
        else if(Location.equals("Basavangudi")){
            graph.setBackgroundResource(R.drawable.graph_2);
        }
        else if(Location.equals("C.K. Achuktu")){
            graph.setBackgroundResource(R.drawable.graph_3);
        }

    }
}
