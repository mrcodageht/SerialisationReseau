package com.mrcodage;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class MyHttpClient {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        var articleClient = new Article("Client","Article Client","Article venant du client");
        var articleClientJson = ArticleJsonMapper.toJson(articleClient);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8000/article"))
                .POST(HttpRequest.BodyPublishers.ofString(articleClientJson))
                .timeout(Duration.ofSeconds(5))
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        var articleServeur = ArticleJsonMapper.toArticle(response.body());
        System.out.println("Article venant du serveur : "+articleServeur);
    }
}
