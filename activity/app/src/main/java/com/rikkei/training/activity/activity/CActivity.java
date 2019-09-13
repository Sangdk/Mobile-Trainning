package com.rikkei.training.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rikkei.training.activity.R;

public class CActivity extends AppCompatActivity {
    private Button mButtonC;
    private Button mButtonAResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
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
}
