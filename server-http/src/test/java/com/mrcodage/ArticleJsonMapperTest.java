package com.mrcodage;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class ArticleJsonMapperTest {

    public static final String ARTICLE_JSON = """
            {"id":"id","title":"title","content":"content"}
            """.trim();

    @Test
    public void toArticle() {

    }

    @Test
    public void toJson_should_return_json_string() throws JsonProcessingException {
        var article = new Article("id","title","content");
        var result = ArticleJsonMapper.toJson(article);
        assertThat(result).isEqualTo(ARTICLE_JSON);
    }

    @Test
    public void toArticle_should_return_article() throws JsonProcessingException {
        var expectedArticle = new Article("id","title","content");
        var result = ArticleJsonMapper.toArticle(ARTICLE_JSON);
        assertThat(expectedArticle).isEqualTo(result);

    }

}