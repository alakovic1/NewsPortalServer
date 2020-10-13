package com.example.news_portal_server.reporsitory;

import com.example.news_portal_server.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsReporsitory extends JpaRepository<News,Long> {
}
