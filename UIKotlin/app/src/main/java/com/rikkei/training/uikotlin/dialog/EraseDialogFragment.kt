package com.rikkei.training.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.rikkei.training.uikotlin.R
import com.rikkei.training.uikotlin.base.BaseDialogFragment

class EraseDialogFragment(context: Context) : BaseDialogFragment(context) {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(R.string.erase_dialog_title)
            .setMessage(R.string.erase_dialog_message)
            .setIcon(R.drawable.ic_warning)
            .setNegativeButton(
                R.string.cancel
            ) { _, _ -> }
            .setPositiveButton(
                R.string.ok
            ) { _, _ ->
                Toast.makeText(
                    context,
                    "All photo and media have been delete!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        return builder.create()
    }
}
