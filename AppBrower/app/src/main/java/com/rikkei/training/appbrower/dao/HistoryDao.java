package com.rikkei.training.appbrower.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.rikkei.training.appbrower.model.History;

import java.util.List;

@Dao
public interface HistoryDao {
    @Query("SELECT * FROM history")
    List<History> getAll();

    @Insert
    void insert(History item);

    @Insert
    void insertAll(History... history);

    @Query("UPDATE history SET isBookmark =1 WHERE id= :id")
    void setBookmark(long id);
}
