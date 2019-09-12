package com.rikkei.training.activitykotlin

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RotateActivity : AppCompatActivity() {
    private var mMedia: MediaPlayer? = null
    private val POSITION_KEY = "position"

    override fun onCreate(savedPosition: Bundle?) {
        super.onCreate(savedPosition)
        setContentView(R.layout.activity_rotate)
        mMedia = MediaPlayer.create(this, R.raw.music)
        mMedia!!.start()
        if (savedPosition != null) {
            var position = savedPosition.getInt(POSITION_KEY)
            mMedia!!.seekTo(position)
        }
    }

    override fun onSaveInstanceState(savedPosition: Bundle) {
        super.onSaveInstanceState(savedPosition)
        var position = mMedia!!.currentPosition
        savedPosition.putInt(POSITION_KEY,position)
    }

    override fun onDestroy() {
        super.onDestroy()
        mMedia!!.pause()
    }
}
