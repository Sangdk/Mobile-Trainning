package com.rikkei.training.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rikkei.training.activity.R;

public class BActivity extends AppCompatActivity {
    private Button mButtonBC;
    private Button mButtonBCFinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
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
}
