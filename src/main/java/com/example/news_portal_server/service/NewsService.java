package com.example.news_portal_server.service;

import com.example.news_portal_server.models.News;
import com.example.news_portal_server.reporsitory.NewsReporsitory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsReporsitory newsReporsitory;

    public NewsService(NewsReporsitory newsReporsitory) {
        this.newsReporsitory = newsReporsitory;
    }

    public List<News> findAll() {
        return newsReporsitory.findAll();
    }

    public News save(News news) {
        return newsReporsitory.save(news);
    }

}
