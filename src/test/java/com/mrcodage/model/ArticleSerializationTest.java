package com.mrcodage.model;

import java.io.*;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArticleSerializationTest {

    @Test
    public void serialize_and_deserialize_should_be_same() throws IOException , ClassNotFoundException{

        Article article = new Article("1", "Article 1", "Content", OffsetDateTime.now());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(article);

        var articleBytes = byteArrayOutputStream.toByteArray();

        var objectIn = new ObjectInputStream(new ByteArrayInputStream(articleBytes));
        Article article_deserialize = (Article) objectIn.readObject();

        assertEquals(article,article_deserialize);
    }

}