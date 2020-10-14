package com.example.news_portal_server.reporsitory;

import com.example.news_portal_server.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

//for working with database
public interface NewsReporsitory extends JpaRepository<News,Long> {
    //News findNewsById(Long id);
}
