package com.example.news_portal_server.models;

public class Newss {
    private String title;
    private String details;

    public Newss() {
    }

    public Newss(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
