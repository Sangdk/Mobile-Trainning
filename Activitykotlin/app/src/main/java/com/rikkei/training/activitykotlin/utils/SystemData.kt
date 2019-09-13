package com.rikkei.training.activitykotlin.utils

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import android.util.Log

class SystemData {
    private var resolver: ContentResolver? = null

    constructor(context: Context) {
        this.resolver = context.contentResolver
    }

    fun readData() {
        var cursor: Cursor? = resolver!!.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            null,
            null,
            null,
            null
        )
        cursor!!.moveToFirst()
        var index: Int = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA)
        while (!cursor.isAfterLast) {
            var data = cursor.getString(index)
            Log.d("Data: ", data)
            cursor.moveToNext()
        }
    }
}