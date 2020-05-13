package com.example.guardian;

public class List_Data {
    private String name;
    private String image_url;

    List_Data(String name, String image_url) {
        this.name = name;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    String getImage_url() {
        return image_url;
    }
}
