package com.rikkei.training.fragmentkotlin

import android.content.Context
import android.media.MediaPlayer

class MediaManager {
    private var resId: Int = 0
    private var mContext: Context? = null
    private var mPlayer: MediaPlayer? = null

    constructor(resId: Int, mContext: Context?) {
        this.resId = resId
        this.mContext = mContext
    }

    fun create() {
        mPlayer = MediaPlayer.create(mContext,resId)
    }

    fun start() {
        if (mPlayer != null) {
            mPlayer!!.start()
        }
    }

    fun pause() {
        if (mPlayer != null) {
            mPlayer!!.pause()
        }

    }

    fun stop() {
        if (mPlayer != null) {
            mPlayer!!.stop()
        }

    }

    fun seekTo(position: Int) {
        if (mPlayer != null) {
            mPlayer!!.seekTo(position)
        }
    }

    fun getCurrentPossition(): Int {
        if (mPlayer != null) {
            return mPlayer!!.currentPosition
        }
        return 0
    }
}