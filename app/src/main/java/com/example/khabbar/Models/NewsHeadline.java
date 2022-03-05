package com.example.khabbar.Models;

import com.example.khabbar.Models.source;

import java.io.Serializable;

public class NewsHeadline implements Serializable {
    com.example.khabbar.Models.source source;
    String author= "";
    String title= "";
    String description= "";
    String url= "";
    String urlToImage= "";
    String publishedAt= "";
    String content= "";

    public com.example.khabbar.Models.source getSource() {
        return source;
    }

    public void setSource(com.example.khabbar.Models.source source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
