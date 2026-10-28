package com.springai.entity;

public class Tut {
    private String title;
    private String content;
    private String createdYear;

    public Tut(String content, String title, String createdYear) {
        this.content = content;
        this.title = title;
        this.createdYear = createdYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(String createdYear) {
        this.createdYear = createdYear;
    }
}
