package com.rikkei.training.activity;

public class Song {
    private String data;
    private String title;

    public Song(String data, String title) {
        this.data = data;
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public String getTitle() {
        return title;
    }
}
