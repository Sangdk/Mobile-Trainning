package com.rikkei.training.uikotlin.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initAct()
    }

    protected abstract fun initAct()
    protected abstract fun getLayoutId(): Int

}
