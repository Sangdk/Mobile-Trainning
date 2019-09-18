package com.rikkei.training.uikotlin.base

import android.content.Context
import android.view.LayoutInflater

import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment(context: Context) : DialogFragment() {
    protected var inflater: LayoutInflater = LayoutInflater.from(context)

}
