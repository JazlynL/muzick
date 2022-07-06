package com.careerdevs.muzick.controllers;

import com.careerdevs.muzick.payloads.ApiResponses.Article;
import com.careerdevs.muzick.payloads.ApiResponses.NewsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/news")
public class NewsController {


    //we can also use Rest template as a field.
    @Autowired
    private RestTemplate restTemplate;


    //
    @Value("${API-KEY}")
    private String apiKey;

    @GetMapping("/test")
    public ResponseEntity<String> testRoute(){
        return new ResponseEntity<>("This test is gucci ", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getMethod(){
        String url = "https://newsapi.org/v2/everything?apikey="+ apiKey+"q=music";
        NewsApi response = restTemplate.getForObject(url, NewsApi.class);


        List<Article> newArticle = new ArrayList<>();
        for(Article article: response.getArticles()){
            if (article.getSourceName().equals("Wired")) {
                newArticle.add(article);

            }
        }
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }
}
