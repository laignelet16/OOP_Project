package com.example.broadwayroulette;

// this is how to create a broadway show
public class BroadwayShowModel {
    private String showName;
    private String date;
    private String time;
    private String id;
    private String description;

    public BroadwayShowModel(String showName, String date, String time, String description) {
        this.showName = showName;
        this.date = date;
        this.time = time;
        this.description = description;
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
    public String getDescription() {
        return description;
    }
}