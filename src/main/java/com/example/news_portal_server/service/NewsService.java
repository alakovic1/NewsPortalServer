package com.example.news_portal_server.service;

import com.example.news_portal_server.models.News;
import com.example.news_portal_server.reporsitory.NewsReporsitory;
import com.example.news_portal_server.requests.NewsRequest;
import com.example.news_portal_server.responses.ApiResponse;
import com.example.news_portal_server.responses.NewsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public News findBankAccountUserById(Long id) {
        return newsReporsitory.findNewsById(id);
    }

    public ApiResponse editNews(Long newsId, NewsRequest newsRequest){
        News news = findBankAccountUserById(newsId);
        news.setConfig(newsRequest);
        save(news);
        return new ApiResponse(true, "You have successfully edited this news!");
    }

    public List<NewsResponse> findAllNewsWithTitle(String title) {
        return newsReporsitory.findAll()
                .stream()
                .filter(news -> news.getTitle().equals(title))
                .map(news -> {
                    return new NewsResponse(news.getId(),
                            news.getPicture(),
                            news.getTitle(),
                            news.getDetails());
                })
                .collect(Collectors.toList());
    }
}
