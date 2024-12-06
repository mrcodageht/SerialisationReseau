package com.mrcodage.model;

import org.junit.Test;

import java.io.*;
import java.time.OffsetDateTime;

import static org.junit.Assert.assertEquals;


public class ArticleTestSerializable {

    @Test
    public void serializableSuccesfully() throws IOException, ClassNotFoundException {
        var article = new Article("id","title","content", OffsetDateTime.now());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        out.writeObject(article);

        var articleBytes = byteArrayOutputStream.toByteArray();
        var objectIn = new ObjectInputStream(new ByteArrayInputStream(articleBytes));
        Article articleDeserialize =(Article) objectIn.readObject();

        assertEquals(article,articleDeserialize);
    }

}
