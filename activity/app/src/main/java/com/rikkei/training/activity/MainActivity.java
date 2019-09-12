package com.rikkei.training.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mButton;
    private MediaManager media;
    private String link = "/storage/emulated/0/Download/Di Du Dua Di - Bich Phuong.mp3";
    private final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    private SystemData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "on Create");
        setContentView(R.layout.activity_main);
        if (checkPermission()) {
            initViews();
        }
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : PERMISSIONS) {
                if (checkSelfPermission(p) != getPackageManager().PERMISSION_GRANTED) {
                    requestPermissions(PERMISSIONS, 0);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()) {
            initViews();
        } else {
            finish();
        }
    }

    private void initViews() {
        mButton = findViewById(R.id.btn_act_a);
        mButton.setOnClickListener(this);

        data = new SystemData(this);
        data.readData();
        media = new MediaManager(link,this);
        media.create();
    }

    @Override
    protected void onStart() {
        super.onStart();
        media.start();
        Log.d(TAG, "on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        media.stop();
        Log.d(TAG, "on Destroy");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, AActivity.class);
        media.pause();
        startActivity(intent);
    }
}
