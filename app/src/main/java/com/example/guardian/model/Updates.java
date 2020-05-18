package com.example.guardian.model;

public class Updates {
    private String Headline;
    private String Link;

    public Updates(){
    }

    public Updates(String headline, String link) {
        Headline = headline;
        Link = link;
    }

    public String getHeadline() {
        return Headline;
    }

    public void setHeadline(String headline) {
        Headline = headline;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
