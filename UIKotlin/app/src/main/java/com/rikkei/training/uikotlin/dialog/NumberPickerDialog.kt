package com.rikkei.training.uikotlin.dialog


import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import com.rikkei.training.uikotlin.R
import com.rikkei.training.uikotlin.base.BaseDialogFragment
import kotlinx.android.synthetic.main.dialog_message_limit.*


class NumberPickerDialog(context: Context) : BaseDialogFragment(context),
    NumberPicker.OnValueChangeListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_message_limit, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        val values = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        number_picker.displayedValues = values
        number_picker.minValue = 1
        number_picker.maxValue = 8
        number_picker.setOnValueChangedListener(this)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
            .setTitle(R.string.number_picker_dialog)
            .setView(inflater.inflate(R.layout.dialog_message_limit, null))
            .setPositiveButton(
                R.string.ok
            ) { _, _ -> }
            .setNegativeButton(
                R.string.cancel
            ) { _, _ -> }

        return builder.create()
    }

    override fun onValueChange(numberPicker: NumberPicker, i: Int, i1: Int) {
        Toast.makeText(context, numberPicker.value, Toast.LENGTH_SHORT).show()
    }
}
