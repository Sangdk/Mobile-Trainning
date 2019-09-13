package com.rikkei.training.activitykotlin.Activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import com.rikkei.training.activitykotlin.*
import com.rikkei.training.activitykotlin.utils.SystemData
import kotlinx.android.synthetic.main.activity_a.*

class AActivity : AppCompatActivity(), View.OnClickListener {
    private var link = "/storage/emulated/0/Download/Di Du Dua Di - Bich Phuong.mp3"
    private var media: MediaManager? = null
    private var data: SystemData? = null
    private val mREQUEST_VIDEO_CAPTURE: Int = 1
    private val mPERMISSION: List<String> =
        listOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
    private val mREQUEST =2

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_ab -> toActB()
            R.id.btn_act_rotate -> toActR()
            R.id.btn_cmr -> openCmr()
            R.id.btn_str_b_for_result -> strBForResult()
        }
    }

    private fun strBForResult() {
        media!!.pause()
        intent = Intent(this,BActivity::class.java)
        startActivityForResult(intent,mREQUEST)
    }

    private fun openCmr() {
        media!!.pause()
        var intentCmr = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        intentCmr.putExtra("android.intent.extra.durationLimit", 10000)
        if (intentCmr.resolveActivity(packageManager) != null) {
            startActivityForResult(intentCmr, mREQUEST_VIDEO_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == mREQUEST_VIDEO_CAPTURE && resultCode == Activity.RESULT_OK) {
            img.visibility = View.GONE
            var uri = data!!.data
            video_view.setVideoURI(uri)
            video_view.start()
        }
        if (requestCode == mREQUEST && resultCode == Activity.RESULT_OK){
            Toast.makeText(this,"Request success",Toast.LENGTH_SHORT).show()
        }
    }

    private fun toActB() {
        Log.d(mTAG, "To act B")
        media!!.pause()
        val intent = Intent(this, BActivity::class.java)
        startActivity(intent)
    }

    private fun toActR() {
        media!!.stop()
        val intent = Intent(this, RotateActivity::class.java)
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (p in mPERMISSION) {
                if (checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(mPERMISSION.toTypedArray(), 0)
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
        btn_ab.setOnClickListener(this)
        btn_act_rotate.setOnClickListener(this)
        btn_cmr.setOnClickListener(this)
        btn_str_b_for_result.setOnClickListener(this)
        media!!.create()
        handleDisplay()
    }

    private fun handleDisplay() {
        var receiverIntent = intent
        var action = receiverIntent.action
        var type = receiverIntent.type
        if (action.equals(Intent.ACTION_SEND)) {
            if (type!!.startsWith("image/")) {
                var uri = receiverIntent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)
                video_view.visibility = View.GONE
                img.visibility = View.VISIBLE
                img.setImageURI(uri)
            } else if (type.startsWith("video/")) {
                var uri = receiverIntent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)
                img.visibility = View.GONE
                video_view.visibility = View.VISIBLE
                video_view.setVideoURI(uri)
                video_view.start()
            }
        }
    }

    override fun onStart() {
        if (media != null) {
            media!!.start()
        }
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
