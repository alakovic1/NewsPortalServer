package com.example.news_portal_server.models;

import com.example.news_portal_server.requests.NewsRequest;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String picture;
    private String title;
    private String details;

    public News() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setConfig(NewsRequest newsRequest) {
        this.picture = newsRequest.getPicture();
        this.title = newsRequest.getTitle();
        this.details = newsRequest.getDetails();
    }
}
