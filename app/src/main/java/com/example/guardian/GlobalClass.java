package com.example.guardian;

import android.app.Application;
import android.widget.TextView;

public class GlobalClass extends Application {
    private double Lat;
    private double Lng;
    private TextView em_1;

    public TextView getEm_1(){
        return em_1;
    }
    public void setEm_1(TextView em_11){
        em_1 = em_11;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double Lati) {
        Lat = Lati;
    }

    public double getLng() {
        return Lng;
    }

    public void setLng(double Lngi) {
        Lng = Lngi;

    }

}
