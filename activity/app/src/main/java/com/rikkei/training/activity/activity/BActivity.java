package com.rikkei.training.activity.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.rikkei.training.activity.R;
import com.rikkei.training.activity.base.BaseActivity;

public class BActivity extends BaseActivity {
    private Button mButtonBC;
    private Button mButtonBCFinish;

    @Override
    protected void initData() {
    }

    @Override
    protected void initViews() {
        mButtonBC = findViewById(R.id.btn_act_bc);
        mButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BActivity.this,CActivity.class);
                startActivity(intent);
            }
        });

        mButtonBCFinish = findViewById(R.id.btn_str_c_finish);
        mButtonBCFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BActivity.this,CActivity.class);
                setResult(RESULT_OK,intent);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_b;
    }
}
