package com.example.news_portal_server.controllers;

import com.example.news_portal_server.requests.AddNewsRequest;
import com.example.news_portal_server.responses.AddNewsResponse;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AddNewsController {

    @PostMapping("/addNews")
    public AddNewsResponse addNews(@RequestBody AddNewsRequest addNewsRequest) {
        return null;
    }
}


