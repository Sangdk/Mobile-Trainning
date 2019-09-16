package com.rikkei.training.fragmentkotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class  BaseFragment<AC : AppCompatActivity> : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v:View =inflater.inflate(getLayoutId(),container,false);
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    abstract fun initData()

    protected fun getParentActivity():AC{
        return activity as AC
    }

    abstract fun getLayoutId(): Int
}