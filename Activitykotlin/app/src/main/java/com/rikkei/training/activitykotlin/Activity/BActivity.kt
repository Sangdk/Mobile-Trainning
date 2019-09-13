package com.rikkei.training.activitykotlin.Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.rikkei.training.activitykotlin.MediaManager
import com.rikkei.training.activitykotlin.R
import kotlinx.android.synthetic.main.activity_b.*

class BActivity : AppCompatActivity(), View.OnClickListener {
    private var link = "/storage/emulated/0/Download/Ket Thuc Lau Roi - Le Bao Binh.mp3"
    private var media: MediaManager? = null

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_bc -> toActC()
            R.id.btn_str_c_finish -> strCAndFinish()
        }
    }

    private fun strCAndFinish() {
        var intent = Intent(this,CActivity::class.java)
        setResult(Activity.RESULT_OK,intent)
        startActivity(intent)
        finish()
    }

    private fun toActC() {
        intent = Intent(this,CActivity::class.java)
        startActivity(intent)
    }

    private val TAG = "BActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "on Create")
        setContentView(R.layout.activity_b)
        initViews()
    }

    private fun initViews() {
        btn_bc.setOnClickListener(this)
        btn_str_c_finish.setOnClickListener(this)
        media = MediaManager(this, link)
        media!!.create()

    }

    override fun onStart() {
        super.onStart()
        media!!.start()
        Log.d(TAG, "on Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "on Resume")
    }

    override fun onPause() {
        super.onPause()
        media!!.stop()
        Log.d(TAG, "on Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "on Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "on Destroy")
    }
}
