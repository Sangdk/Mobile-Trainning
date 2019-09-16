package com.rikkei.training.fragment.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rikkei.training.fragment.MainActivity;
import com.rikkei.training.fragment.MediaManager;
import com.rikkei.training.fragment.R;
import com.rikkei.training.fragment.base.BaseFragment;

public class AFragment extends BaseFragment<MainActivity> implements View.OnClickListener {
    private Button btn_gt_fragB;
    private final String TAG = "Fragment A ";
    private MediaManager mMedia;


    @Override
    protected void initData() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMedia = new MediaManager(R.raw.music_1, getContext());
        mMedia.create();
    }

    @Override
    protected void initView() {
        Log.d(TAG, "on Create");
        btn_gt_fragB = findViewById(R.id.btn_gt_fmB);
        btn_gt_fragB.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    public void onClick(View view) {
        getParentActivity().addFragment(getParentActivity().getFragB());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "on Start");
        mMedia.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "on Resume");
    }

    @Override
    public void onPause() {
        mMedia.pause();
        super.onPause();
        Log.d(TAG, "on Pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "on Stop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "on Destroy");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle saveState) {
        super.onSaveInstanceState(saveState);
    }
}
