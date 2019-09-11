package com.rikkei.training.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;

public class SystemData {
    private ContentResolver resolver;

    public SystemData(Context context) {
        resolver = context.getContentResolver();

    }
    public ArrayList<Song> getData(){
        ArrayList<Song> arr = new ArrayList<>();
        Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        int indexTitle = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
        int indexData = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);

        while (cursor.isAfterLast() == false) {

            String data = cursor.getString(indexData);
            String name = cursor.getString(indexTitle);
//            Song song = new Song(data,name);
//            arr.add(song);
            Log.d("Data: ",data);
            cursor.moveToNext();
        }
        return arr;
    }
}
