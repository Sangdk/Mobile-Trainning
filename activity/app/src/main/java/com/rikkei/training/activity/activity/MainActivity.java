package com.rikkei.training.activity.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import com.rikkei.training.activity.MediaManager;
import com.rikkei.training.activity.R;
import com.rikkei.training.activity.base.BaseActivity;
import com.rikkei.training.activity.utils.SystemData;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private final String TAG = MainActivity.class.getSimpleName();
    private final int REQUEST_VIDEO_CAPTURE = 1;
    private Button mButtonActA;
    private Button mButtonActR;
    private Button mButtonCmr;
    private MediaManager mMedia;
    private VideoView mVideo;
    private ImageView mImg;
    private String link = "/storage/emulated/0/Download/Di Du Dua Di - Bich Phuong.mp3";
    private final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    private SystemData data;

    @Override
    protected void initData() {
        data.readData();
        handleDisplay();
        mMedia.create();
    }

    @Override
    protected void initViews() {
        Log.d(TAG, "on Create");
        if (checkPermission()) {
            mButtonActA = findViewById(R.id.btn_act_a);
            mButtonActR = findViewById(R.id.btn_act_rotate);
            mButtonCmr = findViewById(R.id.btn_cmr);
            mVideo = findViewById(R.id.video_view);
            mImg = findViewById(R.id.img);
            mMedia = new MediaManager(link, this);
            mButtonActA.setOnClickListener(this);
            mButtonActR.setOnClickListener(this);
            mButtonCmr.setOnClickListener(this);
            data = new SystemData(this);
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


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void handleDisplay() {
        Intent receiveIntent = getIntent();
        String action = receiveIntent.getAction();
        String type = receiveIntent.getType();
        if (action.equals(Intent.ACTION_SEND)) {
            if (type.startsWith("image/")) {
                Uri uri = receiveIntent.getParcelableExtra(Intent.EXTRA_STREAM);
                mVideo.setVisibility(View.GONE);
                mImg.setVisibility(View.VISIBLE);
                mImg.setImageURI(uri);
            } else if (type.startsWith("video/")) {
                Uri uri = receiveIntent.getParcelableExtra(Intent.EXTRA_STREAM);
                mImg.setVisibility(View.GONE);
                mVideo.setVisibility(View.VISIBLE);
                mVideo.setVideoURI(uri);
                mVideo.start();
            }

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMedia.start();
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
        mMedia.stop();
        Log.d(TAG, "on Destroy");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_act_a:
                Intent intentA = new Intent(this, AActivity.class);
                mMedia.pause();
                startActivity(intentA);
                break;
            case R.id.btn_act_rotate:
                Intent intentRotate = new Intent(this, RotateActivity.class);
                mMedia.stop();
                startActivity(intentRotate);
                break;
            case R.id.btn_cmr:
                Log.d("Main", "open camera");
                mMedia.stop();
                Intent intentCmr = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                intentCmr.putExtra("android.intent.extra.durationLimit", 10000);
                if (intentCmr.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intentCmr, REQUEST_VIDEO_CAPTURE);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            mImg.setVisibility(View.GONE);
            Uri uri = data.getData();
            mVideo.setVideoURI(uri);
            mVideo.start();
        }
    }
}
