package com.example.news_portal_server.responses;

public class NewsResponse {
    private Long id;

    private String picture;

    private String title;

    private String details;

    public NewsResponse() {
    }

    public NewsResponse(Long id, String picture, String title, String details) {
        this.id = id;
        this.picture = picture;
        this.title = title;
        this.details = details;
    }

    public NewsResponse(String picture, String title, String details) {
        this.picture = picture;
        this.title = title;
        this.details = details;
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
