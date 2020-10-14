package com.example.news_portal_server.controllers;

import com.example.news_portal_server.models.NewsList;
import com.example.news_portal_server.responses.ApiResponse;
import com.example.news_portal_server.service.NewsService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewsControllerTest {

    private List<NewsList> newsList = new ArrayList<>(Arrays.asList(
            new NewsList(1, "picture", "Novi rekord u BiH: Na koronavirus pozitivne još 482 osobe", "U protekla 24 sata u Bosni i Hercegovini zaraza koronavirusom je potvrđena kod još 482 osobe. Preminulo je 11 osoba."),
            new NewsList(2, "picture2", "Alonso vozio Renaultov bolid u Barceloni: Nije se lako vratiti, ali osjećaj je sjajan", "Iskusni španski vozač Fernando Alonso ponovo je sjeo u bolid Formule 1, ovog puta za upravljač Renaulta."),
            new NewsList(3, "picture3", "U 77. godini preminula Berta iz humoristične serije \"Dva i po muškarca\"", "Conchata Ferrell, zvijezda serije \"Dva i po muškarca\", preminula je u 77. godini. Ovu tužnu vijest potvrdio je njen menadžer Dan Spilo.")
    ));

    @Test
    void getAllNews() {
        assertEquals(3, newsList.size());
    }

    @Test
    void addNews() {
        NewsService newsService = new NewsService();
        newsService.setNewsList(newsList);
        ApiResponse apiResponse = newsService.save(new NewsList(4, "picture4", "Uhapšen 28-godišnjak zbog krađe dva automobila u Sarajevu", "Pripadnici Uprave policije Ministarstva unutrašnjih poslova Kantona Sarajevo uhapsili su jučer 28-godišnjeg mladića inicijala D. S. zbog krađe automobila iz autokuće \"Pantera\" na Stupu."));
        assertEquals(true, apiResponse.getSuccess());
        assertEquals(4, newsList.size());
    }

    @Test
    void editNews() {
        NewsService newsService = new NewsService();
        newsService.setNewsList(newsList);
        ApiResponse apiResponse = newsService.editNews(1, new NewsList(5, "picture4", "Uhapšen 28-godišnjak zbog krađe dva automobila u Sarajevu", "Pripadnici Uprave policije Ministarstva unutrašnjih poslova Kantona Sarajevo uhapsili su jučer 28-godišnjeg mladića inicijala D. S. zbog krađe automobila iz autokuće \"Pantera\" na Stupu."));
        assertEquals(true, apiResponse.getSuccess());
        assertEquals(5, newsList.get(0).getId());
        assertEquals("Uhapšen 28-godišnjak zbog krađe dva automobila u Sarajevu", newsList.get(0).getTitle());
        assertEquals("Pripadnici Uprave policije Ministarstva unutrašnjih poslova Kantona Sarajevo uhapsili su jučer 28-godišnjeg mladića inicijala D. S. zbog krađe automobila iz autokuće \"Pantera\" na Stupu.", newsList.get(0).getDetails());
    }

    @Test
    void getAllNewsFilteredByTitle() {
        NewsService newsService = new NewsService();
        List<NewsList> pom = newsService.findAllNewsWithTitle("Novi rekord u BiH: Na koronavirus pozitivne još 482 osobe");
        assertEquals(1, pom.size());
    }

    @Test
    void getAllNewsWithPartOfTitle() {
        NewsService newsService = new NewsService();
        List<NewsList> pom = newsService.findAllNewsWithPartTitle("novi");
        assertEquals(1, pom.size());
    }

    @Test
    void getAllNewsWithPartOfDetails() {
        NewsService newsService = new NewsService();
        List<NewsList> pom = newsService.findAllNewsWithPartDetails("ZARAZA");
        assertEquals(1, pom.size());
    }

    @Test
    void getAllNewsWithWord() {
        NewsService newsService = new NewsService();
        List<NewsList> pom = newsService.findAllNewsWithWord("novi");
        assertEquals(1, pom.size());
        List<NewsList> pom2 = newsService.findAllNewsWithWord("ZARAZA");
        assertEquals(1, pom2.size());
        List<NewsList> pom3 = newsService.findAllNewsWithWord("alonSO");
        assertEquals(1, pom2.size());
        List<NewsList> pom4 = newsService.findAllNewsWithWord("novi rekord");
        assertEquals(1, pom.size());
    }
}