package com.mrcodage;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Article article = new Article("1","Les evades","Six evades du prison fox river");
        System.out.println("Article en format JSON\n");
        System.out.println(ArticleJsonMapper.toJson(article));
    }
}
