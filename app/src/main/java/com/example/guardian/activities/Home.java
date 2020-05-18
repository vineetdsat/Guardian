package com.example.guardian.activities;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import com.example.guardian.model.GlobalClass;
import com.example.guardian.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


public class Home extends AppCompatActivity {
    ImageView top;
    TextView loc;
    Button Logout;
    CardView Map,Sos,Area,Call,Profile,News;

    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private  static final int REQUEST_CODE = 101;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Map = findViewById(R.id.cardView_map);
        Sos = findViewById(R.id.cardView_sos);
        Area = findViewById(R.id.cardView_area);
        Call = findViewById(R.id.cardView_call);
        Profile = findViewById(R.id.cardView_profile);
        Logout = findViewById(R.id.bt_logout);
        top = findViewById(R.id.logo_top);
        loc = findViewById(R.id.location_address_tv);
        News = findViewById(R.id.cardView_news);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();


        Sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, SOS.class);
                startActivity(intent);
            }
        });
        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Lati = Double.toString(currentLocation.getLatitude());
                String Longi = Double.toString(currentLocation.getLongitude());
                String URL_1 = "https://www.google.com/maps/search/police+station/@"+ Lati + "," + Longi + ",12z/data=!3m1!4b1";

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_1));
                startActivity(browserIntent);
            }
        });
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, emergencyCall.class);
                startActivity(intent);
            }
        });
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Profile.class);
                startActivity(intent);
            }
        });
        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, AreaStats.class);
                startActivity(intent);
            }
        });
        News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, News.class);
                startActivity(intent);
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember","false");
                editor.apply();
                finish();
            }
        });



    }
    private void fetchLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
            return;
        }
        Task<Location> task=fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!= null){
                    currentLocation = location;
                    Toast.makeText(getApplicationContext(),currentLocation.getLatitude()
                            +""+currentLocation.getLongitude(),Toast.LENGTH_SHORT).show();
                    double latitude = currentLocation.getLatitude();
                    double longitude = currentLocation.getLongitude();
                    loc.setText(getAddress(latitude, longitude));

                    final GlobalClass globalVariable =(GlobalClass)getApplicationContext();
                    globalVariable.setLat(latitude);
                    globalVariable.setLng(longitude);


                }
            }
        });

    }
    private String getAddress(double latitude, double longitude) {
        StringBuilder result_1 = new StringBuilder();
        StringBuilder result_2 = new StringBuilder();
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                result_1.append(address.getPostalCode());
                result_2.append(address.getSubLocality());
                final GlobalClass globalVariable =(GlobalClass)getApplicationContext();
                globalVariable.setAdd_pin(result_1);
                globalVariable.setAdd_loc(result_2);

            }
        } catch (IOException e) {
            Log.e("tag", Objects.requireNonNull(e.getMessage()));
        }

        return result_1.toString();



    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchLastLocation();
            }
        }
    }

}