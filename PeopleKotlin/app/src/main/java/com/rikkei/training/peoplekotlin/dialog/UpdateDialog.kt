package com.rikkei.training.peoplekotlin.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.rikkei.training.peoplekotlin.R
import com.rikkei.training.peoplekotlin.model.People
import kotlinx.android.synthetic.main.dialog_update_people.*
import kotlinx.android.synthetic.main.item_people_info.view.*
import java.lang.ClassCastException

class UpdateDialog(var people: People) : DialogFragment() {
    private lateinit var listener: UpdateDialogListener
    private lateinit var myView: View
    var lastAge: Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return myView
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = android.app.AlertDialog.Builder(context)
        myView = LayoutInflater.from(context).inflate(R.layout.dialog_update_people, null)
        builder.setTitle(R.string.update)
            .setIcon(R.drawable.ic_update)
            .setView(myView)
            .setNegativeButton(R.string.cancel) { _, _ ->
                listener.onUpdateDialogNegativeClick(this)
            }
            .setPositiveButton(R.string.ok) { _, _ ->
                listener.onUpdateDialogPositiveClick(this)
            }
        return builder.create()
    }

    private fun EditText.getString(): String {
        return this.text.toString()
    }

    fun getPeopleUpdate(): People {
        val id: Int = update_id.getString().toInt()
        val name: String = update_name.getString()
        val gender: String = update_gender.selectedItem.toString()
        val age: Int = update_age.getString().toInt()
        val country: String = update_country.getString()
        return People(id, name, gender, age, country)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initSpinner()
        val arr = resources.getStringArray(R.array.gender_array)
        val index = arr.indexOf(people.gender)
        lastAge = people.age

        update_age.setText(people.age.toString())
        update_gender.setSelection(index)
        update_country.setText(people.country)
        update_id.setText(people.id.toString())
        update_name.setText(people.name)
        when (people.age) {
            in 0..15 -> img_item.setImageResource(R.drawable.ic_youth)
            in 16..39 -> img_item.setImageResource(R.drawable.ic_adolescent)
            in 40..59 -> img_item.setImageResource(R.drawable.ic_middle_age)
            in 60..100 -> img_item.setImageResource(R.drawable.ic_older)
        }
    }

    interface UpdateDialogListener {
        fun onUpdateDialogPositiveClick(dialog: DialogFragment)
        fun onUpdateDialogNegativeClick(dialog: DialogFragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as UpdateDialogListener
        } catch (ex: ClassCastException) {
            throw ClassCastException(
                (context.toString()) +
                        "must implement UpdateDialogListener"
            )
        }
    }

    private fun initSpinner() {
        val spinner: Spinner = view!!.findViewById(R.id.update_gender)
        ArrayAdapter.createFromResource(
            context!!,
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }
}