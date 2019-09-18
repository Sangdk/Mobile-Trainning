package com.rikkei.training.uikotlin.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.rikkei.training.uikotlin.R
import com.rikkei.training.uikotlin.base.BaseDialogFragment

class BrightnessDialogFragment(context: Context) : BaseDialogFragment(context) {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(R.string.bright_dialog_message)
            .setIcon(R.drawable.ic_settings)
            .setView(inflater.inflate(R.layout.dialog_brightness, null))
            .setPositiveButton(
                R.string.cancel
            ) { _, _ -> }
            .setNegativeButton(
                R.string.ok
            ) { _, _ ->
                Toast.makeText(
                    context,
                    "OK",
                    Toast.LENGTH_SHORT
                ).show()
            }
        return builder.create()
    }
}
