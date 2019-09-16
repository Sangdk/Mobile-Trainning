package com.rikkei.training.fragment;

import android.content.Context;
import android.media.MediaPlayer;

public class MediaManager {
    private int resId;
    private Context context;
    private MediaPlayer player;

    public MediaManager(int resId, Context context) {
        this.resId = resId;
        this.context = context;
    }

    public void create() {
        player = MediaPlayer.create(context, resId);
    }

    public void start() {
        if (player != null) {
            player.start();
        }
    }

    public void pause() {
        if (player != null) {
            player.pause();
        }
    }

    public void stop() {
        if (player != null) {
            player.stop();
        }
    }

    public void seekTo(int position){
        if (player!= null){
            player.seekTo(position);
        }
    }
    public int getCurrentPosition(){
        if (player!= null){
            return player.getCurrentPosition();
        }
        return 0;
    }
}
