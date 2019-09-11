package com.rikkei.training.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG =AActivity.class.getSimpleName();
    private Button mButton;
    private MediaManager media;
    private String link ="/storage/emulated/0/Download/ChungTaKhongThuocVeNhau-SonTungMTP-4528181.mp3";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d(TAG,"on Create");
        initViews();
    }

    private void initViews() {
        mButton = findViewById(R.id.btn_act_main);
        mButton.setOnClickListener(this);
        media = new MediaManager(link,this);
        media.create();
    }

    @Override
    protected void onStart() {
        super.onStart();
        media.start();
        Log.d(TAG,"on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        media.pause();
        Log.d(TAG,"on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"on Destroy");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
