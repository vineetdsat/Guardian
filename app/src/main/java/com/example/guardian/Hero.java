package com.example.guardian;

public class Hero {
    String headline, url;

    public Hero(String name, String imageUrl) {
        this.headline = name;
        this.url = imageUrl;
    }

    public String getHeadline() {
        return headline;
    }

    public String getUrl() {
        return url;
    }
}