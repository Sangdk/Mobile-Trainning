package com.rikkei.training.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rikkei.training.activity.MediaManager;
import com.rikkei.training.activity.R;
import com.rikkei.training.activity.base.BaseActivity;

public class AActivity extends BaseActivity implements View.OnClickListener {
    private final String TAG = AActivity.class.getSimpleName();
    private Button mButtonMain;
    private Button mButtonAB;
    private Button mButtonBForResult;
    private MediaManager media;
    private String link = "/storage/emulated/0/Download/Ket Thuc Lau Roi - Le Bao Binh.mp3";
    public final int REQUEST_A = 5;

    @Override
    protected void initViews() {
        Log.d(TAG, "on Create");
        mButtonMain = findViewById(R.id.btn_act_main);
        mButtonAB = findViewById(R.id.btn_act_ab);
        mButtonBForResult = findViewById(R.id.btn_str_b_for_result);
        mButtonAB.setOnClickListener(this);
        mButtonMain.setOnClickListener(this);
        mButtonBForResult.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        media = new MediaManager(link, this);
        media.create();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_a;
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
        media.pause();
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
        Log.d(TAG, "on Destroy");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_act_main:
                media.stop();
                finish();
                break;
            case R.id.btn_act_ab:
                Intent intent = new Intent(this, BActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_str_b_for_result:
                Intent intentForResult = new Intent(this, BActivity.class);
                startActivityForResult(intentForResult, REQUEST_A);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_A) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "request success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "result false", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "request false", Toast.LENGTH_SHORT).show();
        }
    }
}
