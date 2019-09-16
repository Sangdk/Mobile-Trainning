package com.rikkei.training.activity.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.rikkei.training.activity.R;
import com.rikkei.training.activity.base.BaseActivity;

public class EActivity extends BaseActivity {
    private Button mButtonEC;

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {
        mButtonEC = findViewById(R.id.btn_act_ec);
        mButtonEC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EActivity.this, CActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_e;
    }
}
