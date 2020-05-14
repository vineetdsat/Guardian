package com.example.guardian;

public class List_Data {
    private String headline;
    private String link;


    public List_Data(){}
    public List_Data(String headline, String link){
        this.headline = headline;
        this.link = link;
    }


    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
