package com.mrcodage;

import com.mrcodage.model.Article;

import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Article article = new Article("1","New article","Article content", OffsetDateTime.now());
        System.out.println(article);
    }
}