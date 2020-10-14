package com.example.news_portal_server.controllers;

import com.example.news_portal_server.models.NewsList;
import com.example.news_portal_server.responses.ApiResponse;
import com.example.news_portal_server.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    //for getting all news
    @GetMapping("/all")
    public List<NewsList> getAllNews(){
        return newsService.findAll();
    }

    //for adding news
    @PostMapping("/add")
    public ApiResponse addNews(@RequestBody NewsList news) {
        return newsService.save(news);
    }

    //for editing news with that id
    @PostMapping("/edit/{newsId}")
    public ApiResponse editNews(@PathVariable int newsId, @Valid @RequestBody NewsList newsList){
        return newsService.editNews(newsId, newsList);
    }

    //when you search with full title
    @GetMapping("/filter/{title}")
    public List<NewsList> getAllNewsFilteredByTitle(@PathVariable String title){
        return newsService.findAllNewsWithTitle(title);
    }

    //when you search with only parts of title (one word)
    @GetMapping("/filter/part/{string}")
    public List<NewsList> getAllNewsWithPartOfTitle(@PathVariable String string){
        return newsService.findAllNewsWithPartTitle(string);
    }

    //when you search with only parts of details (one word)
    @GetMapping("/filter/part/details/{string}")
    public List<NewsList> getAllNewsWithPartOfDetails(@PathVariable String string){
        return newsService.findAllNewsWithPartDetails(string);
    }

    //basic search for any news with that word, in title or details
    @GetMapping("/filter/part/search/{string}")
    public List<NewsList> getAllNewsWithWord(@PathVariable String string){
        return newsService.findAllNewsWithWord(string);
    }
}
