package com.rikkei.training.fragment.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.rikkei.training.fragment.MainActivity;
import com.rikkei.training.fragment.MediaManager;
import com.rikkei.training.fragment.R;
import com.rikkei.training.fragment.base.BaseFragment;

public class BFragment extends BaseFragment<MainActivity> implements View.OnClickListener {
    private Button btn_gt_fmA;
    private final String TAG = "Fragment B";
    private MediaManager mMedia;

    @Override
    protected void initData() {
        mMedia = new MediaManager(R.raw.music_2, getContext());
        mMedia.create();
        mMedia.start();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        Log.d(TAG, "on Create");
        btn_gt_fmA = findViewById(R.id.btn_gt_fmA);
        btn_gt_fmA.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_b;
    }

    @Override
    public void onClick(View view) {
        getParentActivity().addFragment(getParentActivity().getFragA());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "on Start");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "on Resume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "on Pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        mMedia.stop();
        Log.d(TAG, "on Stop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "on Destroy");
    }
}
