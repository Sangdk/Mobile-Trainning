package com.rikkei.training.appbrower.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rikkei.training.appbrower.model.History;

@Database(entities = History.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase database;

    public static AppDatabase getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context,
                    AppDatabase.class,
                    "history-Database")
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }

    public abstract HistoryDao getHistoryDao();
}
