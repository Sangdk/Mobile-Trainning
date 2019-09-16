package com.rikkei.training.fragmentkotlin.fragment

import android.os.Bundle
import android.view.View
import com.rikkei.training.fragmentkotlin.MainActivity
import com.rikkei.training.fragmentkotlin.MediaManager
import com.rikkei.training.fragmentkotlin.R
import com.rikkei.training.fragmentkotlin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_a.*

class AFragment : BaseFragment<MainActivity>(), View.OnClickListener {
    override fun onClick(p0: View?) {
        getParentActivity().addFragment(getParentActivity().getFragB())
    }

    private var mMedia: MediaManager? = null
    private val mPOSITION_KEY = "position"
    override fun getLayoutId(): Int {
        return R.layout.fragment_a
    }

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        mMedia = MediaManager(R.raw.music_1, context)
        mMedia!!.create()
        if (savedState != null) {
            var position = savedState.getInt(mPOSITION_KEY)
            mMedia!!.seekTo(position)
        }
    }

    override fun initData() {
        btn_gt_fmB.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        mMedia!!.start()
    }

    override fun onPause() {
        super.onPause()
        mMedia!!.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMedia!!.stop()
    }

    override fun onSaveInstanceState(savedState: Bundle) {
        super.onSaveInstanceState(savedState)
        savedState.putInt(mPOSITION_KEY,currentPosition())
    }

    private fun currentPosition(): Int{
        if (mMedia != null){
            return mMedia!!.getCurrentPossition()
        }
        return 0
    }

}