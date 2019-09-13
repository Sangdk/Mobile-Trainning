package com.rikkei.training.activitykotlin.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rikkei.training.activitykotlin.R
import kotlinx.android.synthetic.main.activity_e.*

class EActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e)
        btn_gt_ec.setOnClickListener(View.OnClickListener {
            intent = Intent(this, CActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        })
    }
}
