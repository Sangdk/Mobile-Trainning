package com.rikkei.training.uikotlin.dialog


import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.rikkei.training.uikotlin.R
import com.rikkei.training.uikotlin.base.BaseDialogFragment
import com.rikkei.training.uikotlin.databinding.DialogMessageLimitBinding
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.dialog_message_limit.*


class NumberPickerDialog(context: Context) : BaseDialogFragment(context) {
    private var binding: DialogMessageLimitBinding? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_message_limit, null, false);
        binding!!.numberPicker.minValue = 1
        binding!!.numberPicker.maxValue = 8

        val builder = AlertDialog.Builder(activity)
            .setTitle(R.string.number_picker_dialog)
            .setView(binding!!.root)
            .setPositiveButton(
                R.string.ok
            ) { _, _ -> }
            .setNegativeButton(
                R.string.cancel
            ) { _, _ -> }
        return builder.create()
    }
}
