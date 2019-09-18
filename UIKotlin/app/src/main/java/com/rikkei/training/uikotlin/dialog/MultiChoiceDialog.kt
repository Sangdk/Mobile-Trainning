package com.rikkei.training.uikotlin.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.rikkei.training.uikotlin.R

import com.rikkei.training.uikotlin.base.BaseDialogFragment

class MultiChoiceDialog(context: Context) : BaseDialogFragment(context) {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
            .setTitle(R.string.pick_toppings)
            .setMultiChoiceItems(
                R.array.pick_toppings, null
            ) { _, i, b ->
                if (b) {
                    val toppings = resources.obtainTypedArray(R.array.pick_toppings)
                    val topping = toppings.getString(i)
                    Toast.makeText(context, topping, Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(
                R.string.cancel
            ) { _, _ -> }
            .setPositiveButton(
                R.string.ok
            ) { _, _ -> }

        return builder.create()
    }
}
