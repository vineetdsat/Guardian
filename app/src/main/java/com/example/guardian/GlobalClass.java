package com.example.guardian;

import android.app.Application;

public class GlobalClass extends Application {
    private double Lat;
    private double Lng;
    private StringBuilder add_pin;
    private StringBuilder add_loc;

    public StringBuilder getAdd_loc() {
        return add_loc;
    }
    public void setAdd_loc(StringBuilder Add){
        add_loc = Add;
    }
    public StringBuilder getAdd_pin(){
        return add_pin;
    }
    public void setAdd_pin(StringBuilder Loc){
        add_pin = Loc;
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
