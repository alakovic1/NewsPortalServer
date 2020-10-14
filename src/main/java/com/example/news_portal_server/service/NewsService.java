package com.example.news_portal_server.service;

import com.example.news_portal_server.models.NewsList;
import com.example.news_portal_server.responses.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NewsService {
    private List<NewsList> newsList = new ArrayList<>(Arrays.asList(
            new NewsList(1, "picture", "Novi rekord u BiH: Na koronavirus pozitivne još 482 osobe", "U protekla 24 sata u Bosni i Hercegovini zaraza koronavirusom je potvrđena kod još 482 osobe. Preminulo je 11 osoba."),
            new NewsList(2, "picture2", "Alonso vozio Renaultov bolid u Barceloni: Nije se lako vratiti, ali osjećaj je sjajan", "Iskusni španski vozač Fernando Alonso ponovo je sjeo u bolid Formule 1, ovog puta za upravljač Renaulta."),
            new NewsList(3, "picture3", "U 77. godini preminula Berta iz humoristične serije \"Dva i po muškarca\"", "Conchata Ferrell, zvijezda serije \"Dva i po muškarca\", preminula je u 77. godini. Ovu tužnu vijest potvrdio je njen menadžer Dan Spilo.")
    ));

    public List<NewsList> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsList> newsList) {
        this.newsList = newsList;
    }

    /*private final NewsReporsitory newsReporsitory;

    public NewsService(NewsReporsitory newsReporsitory) {
        this.newsReporsitory = newsReporsitory;
    }*/

    public List<NewsList> findAll() {
        //return newsReporsitory.findAll();
        return newsList;
    }

    public ApiResponse save(NewsList news) {
        //return newsReporsitory.save(news);
        newsList.add(news);
        return new ApiResponse(true, "You have successfully added this news!");
    }

    /*public News findBankAccountUserById(Long id) {
        return newsReporsitory.findNewsById(id);
    }*/

    public ApiResponse editNews(int newsId, NewsList newslist){
        /*News news = findBankAccountUserById(newsId);
        news.setConfig(newsRequest);
        save(news);*/

        int counter = 0;
        for(NewsList nl : newsList){
            if(nl.getId() == newsId){
                newsList.set(counter, newslist);
            }
            counter++;
        }

        return new ApiResponse(true, "You have successfully edited this news!");
    }

    public List<NewsList> findAllNewsWithTitle(String title) {
        /*return newsReporsitory.findAll()
                .stream()
                .filter(news -> news.getTitle().equals(title))
                .map(news -> {
                    return new NewsResponse(news.getId(),
                            news.getPicture(),
                            news.getTitle(),
                            news.getDetails());
                })
                .collect(Collectors.toList());*/

        List<NewsList> pom = new ArrayList<>();
        for(NewsList nl : newsList){
            if(nl.getTitle().equals(title)){
                pom.add(nl);
            }
        }
        return pom;
    }

    public List<NewsList> findAllNewsWithPartTitle(String string) {

        List<NewsList> pom = new ArrayList<>();
        for(NewsList nl : newsList){
            if(nl.getTitle().toLowerCase().contains(string.toLowerCase())){
                pom.add(nl);
            }
        }
        return pom;
    }

    public List<NewsList> findAllNewsWithPartDetails(String string) {

        List<NewsList> pom = new ArrayList<>();
        for(NewsList nl : newsList){
            if(nl.getDetails().toLowerCase().contains(string.toLowerCase())){
                pom.add(nl);
            }
        }
        return pom;
    }

    public List<NewsList> findAllNewsWithWord(String string) {

        List<NewsList> pom = new ArrayList<>();
        for(NewsList nl : newsList){
            if(nl.getTitle().toLowerCase().contains(string.toLowerCase()) || nl.getDetails().toLowerCase().contains(string.toLowerCase())){
                pom.add(nl);
            }
        }
        return pom;
    }
}
