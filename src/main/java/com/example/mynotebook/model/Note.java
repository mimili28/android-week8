package com.example.mynotebook.model;

import java.io.Serializable;

public class Note implements Serializable {
    private String headline;
    private String text;


    public Note(String headline, String text){
        this.headline=headline;
        this.text=text;
    }
    public Note(){}

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
