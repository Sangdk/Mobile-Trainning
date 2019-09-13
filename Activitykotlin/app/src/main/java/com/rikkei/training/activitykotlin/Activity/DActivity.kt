package com.rikkei.training.activitykotlin.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rikkei.training.activitykotlin.R
import kotlinx.android.synthetic.main.activity_d.*

class DActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
        btn_gt_de.setOnClickListener(View.OnClickListener {
            intent = Intent(this, EActivity::class.java)
            startActivity(intent)
        })
    }
}
