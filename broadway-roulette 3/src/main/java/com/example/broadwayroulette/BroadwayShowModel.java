package com.example.broadwayroulette;

// this is how to create a broadway show
public class BroadwayShowModel {
    private String showName;
    private String date;
    private String time;
    private String id;

    public BroadwayShowModel(String showName, String date, String time) {
        this.showName = showName;
        this.date = date;
        this.time = time;
    }
    
    public BroadwayShowModel(String id, String showName) {
        this.id = id; 
        this.showName = showName;
    }
    
    public String getId() {
        return id;
    }

    public String getShowName() {
        return showName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}