package com.rikkei.training.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rikkei.training.activity.R;

public class DActivity extends AppCompatActivity {
    private Button mButtonDE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        mButtonDE = findViewById(R.id.btn_act_de);
        mButtonDE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DActivity.this, EActivity.class);
                startActivity(intent);
            }
        });
    }
}
