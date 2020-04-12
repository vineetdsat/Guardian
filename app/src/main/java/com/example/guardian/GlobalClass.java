package com.example.guardian;

import android.app.Application;

public class GlobalClass extends Application {
    private double Lat;
    private double Lng;

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
