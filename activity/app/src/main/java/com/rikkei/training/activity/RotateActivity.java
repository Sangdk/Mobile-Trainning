package com.rikkei.training.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

public class RotateActivity extends AppCompatActivity {
    private MediaPlayer mMedia;
    public static final String POSITION_KEY = "position";

    @Override
    protected void onCreate(Bundle savePosition) {
        super.onCreate(savePosition);
        setContentView(R.layout.activity_rotate);
        mMedia = MediaPlayer.create(this, R.raw.music);
        mMedia.start();
        if (savePosition != null) {
            int position = savePosition.getInt(POSITION_KEY);
            mMedia.seekTo(position);
        }
        Log.d("Rotate", "on Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d("Rotate", "on Pause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Rotate", "on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Rotate", "on Destroy");
        mMedia.pause();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savePosition) {
        super.onRestoreInstanceState(savePosition);
//        int position = savePosition.getInt(POSITION_KEY);
//        mMedia.seekTo(position);
//        Log.d("Rotate", "Restore" + position);
    }

    @Override
    protected void onSaveInstanceState(Bundle savePosition) {
        super.onSaveInstanceState(savePosition);
        int position = currentPosition();
        savePosition.putInt(POSITION_KEY, position);
        Log.d("Rotate", "on Save " + position);
    }

    public int currentPosition() {
        if (mMedia != null) {
            return mMedia.getCurrentPosition();
        }
        return 0;
    }
}
