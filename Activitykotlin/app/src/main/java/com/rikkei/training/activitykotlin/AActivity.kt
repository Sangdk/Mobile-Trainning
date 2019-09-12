package com.rikkei.training.activitykotlin

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_a.*

class AActivity : AppCompatActivity(), View.OnClickListener {
    private var link = "/storage/emulated/0/Download/Di Du Dua Di - Bich Phuong.mp3"
    private var media: MediaManager? = null
    private var data: SystemData? = null
    private val mPERMISSION: List<String> = listOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)

    override fun onClick(p0: View?) {
        media!!.pause()
        var intent = Intent(this, BActivity::class.java)
        startActivity(intent)
    }

    private val mTAG = "AActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(mTAG, "on Create")
        if (checkPermission()) {
            initViews()
        }
    }

    private fun checkPermission(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            for ( p in mPERMISSION){
                if (checkSelfPermission(p)!= PackageManager.PERMISSION_GRANTED){
                    requestPermissions(mPERMISSION.toTypedArray(),0)
                    return false
                }
            }
        }
        return true
    }

    private fun initViews() {
        data = SystemData(this)
        data!!.readData()
        media = MediaManager(this, link)
        setContentView(R.layout.activity_a)
        btn_act_a.setOnClickListener(this)
        media!!.create()
    }

    override fun onStart() {
        media!!.start()
        super.onStart()
        Log.d(mTAG, "on Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d(mTAG, "on Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(mTAG, "on Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(mTAG, "on Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        media!!.stop()
        Log.d(mTAG, "on Destroy")
    }
}
