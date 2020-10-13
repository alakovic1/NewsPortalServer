package com.example.news_portal_server.controllers;


import com.example.news_portal_server.models.News;
import com.example.news_portal_server.responses.GetNewsResponse;
import com.example.news_portal_server.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/all")
    public List<News> getAllNews(){
        return newsService.findAll();
    }

    @PostMapping("/add")
    public News addNews(@RequestBody News news) {
        return newsService.save(news);
    }
}
