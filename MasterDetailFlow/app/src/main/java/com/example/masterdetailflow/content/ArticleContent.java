package com.example.masterdetailflow.content;

import android.content.Context;

import com.example.masterdetailflow.R;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ArticleContent {


    public static final List<Article> ITEMS = new ArrayList<Article>();
    static int articleName = R.raw.text;
    Field[] field = R.raw.class.getFields();

    public static final Map<String, Article> articleMap = new HashMap<String, Article>();
    private static final int COUNT = 3;

    static {
        // Add article Items
        for (int i = 1; i <= COUNT; i++) {
            addItem((createArticle(i)));
        }
    }

    private static void addItem(Article article) {
        ITEMS.add(article);
        articleMap.put(article.id, article);
    }

    private static Article createArticle(int position)
    {
        return new Article(String.valueOf(position), "Article: " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about: ").append(articleName);
        return builder.toString();
    }
    public static class Article {
        public final String id;
        public final String content;
        public final String details;

        public Article(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString()
        {
            return content;
        }
    }
}
