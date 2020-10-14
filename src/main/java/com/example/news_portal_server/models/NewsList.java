package com.example.news_portal_server.models;

public class NewsList {

    private int id;
    private String picture;
    private String title;
    private String details;

    public NewsList() {
    }

    public NewsList(String picture, String title, String details) {
        this.picture = picture;
        this.title = title;
        this.details = details;
    }

    public NewsList(int id, String picture, String title, String details) {
        this.id = id;
        this.picture = picture;
        this.title = title;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
