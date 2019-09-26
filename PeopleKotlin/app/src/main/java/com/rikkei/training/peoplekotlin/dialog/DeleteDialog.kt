package com.rikkei.training.peoplekotlin.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.rikkei.training.peoplekotlin.R
import java.lang.ClassCastException

class DeleteDialog : DialogFragment() {
    private lateinit var listener: DeleteDialogListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(R.string.warning)
            .setIcon(R.drawable.ic_warning)
            .setMessage(R.string.alert_dialog_content)
            .setNegativeButton(R.string.cancel) { _, _ ->
                listener.onDelDialogNegativeClick(this)
            }
            .setPositiveButton(R.string.ok) { _, _ ->
                listener.onDelDialogPositiveClick(this)
                Toast.makeText(context, "People info have been delete", Toast.LENGTH_SHORT).show()
            }
        return builder.create()
    }

    interface DeleteDialogListener {
        fun onDelDialogPositiveClick(dialog: DialogFragment)
        fun onDelDialogNegativeClick(dialog: DialogFragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as DeleteDialogListener
        } catch (ex: ClassCastException) {
            throw ClassCastException(
                (context.toString()) +
                        "must implement DeleteDialogListener"
            )
        }
    }
}