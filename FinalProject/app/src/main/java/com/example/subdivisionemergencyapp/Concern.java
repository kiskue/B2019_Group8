package com.example.subdivisionemergencyapp;

public class Concern {
    String concern;
    String items;

    public Concern(String concern, String items){
        this.concern = concern;
        this.items = items;
    }

    public String getConcern() {
        return concern;
    }

    public String getItems() {
        return items;
    }
}
