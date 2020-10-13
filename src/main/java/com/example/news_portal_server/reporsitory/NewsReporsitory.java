package com.example.news_portal_server.reporsitory;

import com.example.news_portal_server.models.News;
import com.example.news_portal_server.responses.NewsResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsReporsitory extends JpaRepository<News,Long> {
    News findNewsById(Long id);
    //List<News> findByTitle(final String title);
}
