package com.example.hackinnovatix.controller;

import com.example.hackinnovatix.model.Category;
import com.example.hackinnovatix.model.Suggestion;
import com.example.hackinnovatix.repo.CategoryRepo;
import com.example.hackinnovatix.repo.SuggestionRepo;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    SuggestionRepo suggestionRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("/categories")
    public List<Category> getCategoryList() {
        return categoryRepo.findAll();
    }

    @GetMapping("/suggestions")
    public List<Suggestion> getSuggestionList() {
        return suggestionRepo.findAll();
    }

    @PostMapping("/suggestions")
    public Suggestion createSuggestion(@RequestBody Suggestion suggestion) {

        suggestionRepo.save(suggestion);

        return suggestion;
    }

    @GetMapping("/xxx")
    public String getList(@RequestParam String keywords, @RequestParam String radius) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=51.090731,71.394978" +
                        "&radius=" + radius + "&keyword=" + keywords + "&key=AIzaSyBC7W-H8jvF7FCFbrEHG-grbUjRKFOcbxk"))
                .build();
        HttpResponse<String> response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
