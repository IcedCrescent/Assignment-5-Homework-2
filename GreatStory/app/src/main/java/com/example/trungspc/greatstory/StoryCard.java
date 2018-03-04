package com.example.trungspc.greatstory;

/**
 * Created by Trung's PC on 3/4/2018.
 */

public class StoryCard {

    private int id;
    private String title;
    private String author;
    private String imgUrl;

    public StoryCard(int id, String title, String author, String imgUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "StoryCard{" +
                "title='" + title + '\'' +
                '}';
    }
}
