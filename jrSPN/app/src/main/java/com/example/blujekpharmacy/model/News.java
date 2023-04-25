package com.example.blujekpharmacy.model;

import com.example.blujekpharmacy.controller.Login;

public class News {


    private int id;
    private String news;
    private String title;

    public News(int id, String news, String title) {
        this.id = id;
        this.news = news;
        this.title = title;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static News getNewsData(int id){
        for (News n : Login.newsList) {
            if (n.getId() == id){
                return n;
            }
        }
        return null;
    }
}
