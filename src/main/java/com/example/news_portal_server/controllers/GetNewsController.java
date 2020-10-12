package com.example.news_portal_server.controllers;


import com.example.news_portal_server.responses.GetNewsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class GetNewsController {
    @GetMapping("/all")
    public List<GetNewsResponse> getAllNews(){
        //return bankAccountUserService.findBankAccounts(currentUser.getId());
        return null;
    }
}
