package com.mrcodage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ArticleJsonMapper {
    public static Article toArticle(String json) throws JsonProcessingException {
        var object = new ObjectMapper();
        return object.readValue(json,Article.class);

    }

    public static String toJson(Article article) throws JsonProcessingException {
        var object = new ObjectMapper();
        return object.writeValueAsString(article);
    }

}
