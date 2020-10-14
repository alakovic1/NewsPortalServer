package com.example.news_portal_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class NewsPortalServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsPortalServerApplication.class, args);
    }

}
