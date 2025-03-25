package com.qpc.dashboard.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TwitterController {

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/twittersList/{query}")
    public JsonNode searchtweets(@PathVariable("query") String query) throws URISyntaxException, IOException, InterruptedException{
        String BEARER_TOKEN = System.getenv("DASHBOARD_TOKEN_TWITTER");
        String queryEncoded = URLEncoder.encode(query, "UTF-8");
        HttpRequest request = HttpRequest
                .newBuilder()
                .header("Authorization", "Bearer " + BEARER_TOKEN)
                .uri(new URI("https://api.twitter.com/2/tweets/search/recent?query="+ queryEncoded + "%20-is:retweet%20lang:fr&expansions=author_id&user.fields=name"))
                .GET()
                .build();
        
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readValue(response.body(), JsonNode.class);

        System.out.println(jsonNode.toString());
        
        return jsonNode;
    }
}
