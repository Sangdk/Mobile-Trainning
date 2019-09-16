package com.rikkei.training.fragmentkotlin.fragment

import android.view.View
import com.rikkei.training.fragmentkotlin.MainActivity
import com.rikkei.training.fragmentkotlin.MediaManager
import com.rikkei.training.fragmentkotlin.R
import com.rikkei.training.fragmentkotlin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_b.*

class BFragment : BaseFragment<MainActivity>(), View.OnClickListener {
    override fun onClick(p0: View?) {
        getParentActivity().addFragment(getParentActivity().getFragA())
    }

    private var mMedia: MediaManager?= null
    override fun initData() {
        btn_gt_fmA.setOnClickListener(this)
        mMedia = MediaManager(R.raw.music_2,context)
        mMedia!!.create()
        mMedia!!.start()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_b

    }

    override fun onStop() {
        super.onStop()
        mMedia!!.stop()
    }

}