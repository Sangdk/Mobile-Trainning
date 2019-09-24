package com.rikkei.training.appbrower.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class History {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "url")
    private String url;
    @ColumnInfo(name = "isBookmark")
    private int isBookmark;

    public History(String url, int isBookmark) {
        this.url = url;
        this.isBookmark = isBookmark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIsBookmark() {
        return isBookmark;
    }

    public void setIsBookmark(int isBookmark) {
        this.isBookmark = isBookmark;
    }
}
