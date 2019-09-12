package com.rikkei.training.activitykotlin

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri

class MediaManager {
    private var link = ""
    private var player: MediaPlayer? = null
    private var context: Context? = null

    constructor(context: Context?, link: String) {
        this.context = context
        this.link = link
    }

    fun create() {
        var uri: Uri = Uri.parse(link)
        player = MediaPlayer.create(context, uri)
    }

    fun start() {
        if (player != null) {
            player!!.start()
        }
    }

    fun pause() {
        if (player != null) {
            player!!.pause()
        }
    }

    fun stop() {
        if (player != null) {
            player!!.stop()
        }
    }
}