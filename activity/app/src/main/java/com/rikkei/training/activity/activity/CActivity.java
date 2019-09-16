package com.rikkei.training.activity.activity;


import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.rikkei.training.activity.R;
import com.rikkei.training.activity.base.BaseActivity;

public class CActivity extends BaseActivity {
    private Button mButtonC;
    private Button mButtonAResult;

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {
        mButtonC = findViewById(R.id.btn_act_cd);
        mButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CActivity.this,DActivity.class);
                startActivity(intent);
            }
        });
        mButtonAResult = findViewById(R.id.btn_finish);
        mButtonAResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_c;
    }
}
