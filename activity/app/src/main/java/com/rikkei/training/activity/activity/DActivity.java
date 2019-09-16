package com.rikkei.training.activity.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.rikkei.training.activity.R;
import com.rikkei.training.activity.base.BaseActivity;

public class DActivity extends BaseActivity {
    private Button mButtonDE;

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {
        mButtonDE = findViewById(R.id.btn_act_de);
        mButtonDE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DActivity.this, EActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_d;
    }
}
