package com.rikkei.training.activity;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public class MediaManager {
    private String link;
    private Context context;
    private MediaPlayer player;

    public MediaManager(String link, Context context) {
        this.link = link;
        this.context = context;
    }

    public void create() {
        Uri uri = Uri.parse(link);
        player = MediaPlayer.create(context, uri);
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
}
