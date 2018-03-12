package com.example.trungspc.greatstorywithpicasso.model;

import java.io.Serializable;

/**
 * Created by Trung's PC on 3/4/2018.
 */

public class StoryCard implements Serializable{

    private int id;
    private String title;
    private String author;
    private String imgUrl;
    private String description;
    private String content;
    private int isBookmarked;

    public StoryCard(int id, String title, String author, String imgUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.imgUrl = imgUrl;
    }

    public StoryCard(int id, String title, String author, String imgUrl, String description, String content, int isBookmarked) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.imgUrl = imgUrl;
        this.description = description;
        this.content = content;
        this.isBookmarked = isBookmarked;
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

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public int getIsBookmarked() {
        return isBookmarked;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setBookmark(int isBookmarked) {
        this.isBookmarked = isBookmarked;
    }

    @Override
    public String toString() {
        return "StoryCard{" +
                "title='" + title + '\'' +
                '}';
    }
}
