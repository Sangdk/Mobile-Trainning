package com.rikkei.training.activitykotlin.Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rikkei.training.activitykotlin.R
import kotlinx.android.synthetic.main.activity_c.*

class CActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        btn_gt_cd.setOnClickListener(View.OnClickListener {
            intent = Intent(this, DActivity::class.java)
            startActivity(intent)
        })
        btn_finish.setOnClickListener(
            View.OnClickListener {
                intent = Intent()
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        )

    }
}
