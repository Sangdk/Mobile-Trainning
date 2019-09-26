package com.rikkei.training.peoplekotlin.activity

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rikkei.training.peoplekotlin.BaseAdapter
import com.rikkei.training.peoplekotlin.R
import com.rikkei.training.peoplekotlin.activity.RegisterActivity.Companion.KEY_VALUE
import com.rikkei.training.peoplekotlin.activity.RegisterActivity.Companion.initSharePrefer
import com.rikkei.training.peoplekotlin.activity.RegisterActivity.Companion.share
import com.rikkei.training.peoplekotlin.dialog.DeleteDialog
import com.rikkei.training.peoplekotlin.dialog.UpdateDialog
import com.rikkei.training.peoplekotlin.model.People
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    BaseAdapter.ItemClickListener,
    DeleteDialog.DeleteDialogListener,
    UpdateDialog.UpdateDialogListener, PopupMenu.OnMenuItemClickListener {
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_sb_name -> {
                sortByName()
            }
            R.id.action_sb_age -> {
                sortByAge()
            }
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun sortByAge() {
    }

    private fun sortByName() {
        dataYouth = dataYouth.sortedWith(compareBy { it.name }).toCollection(ArrayList())
        dataAdolescent = dataAdolescent.sortedWith(compareBy { it.name }).toCollection(ArrayList())
        dataOlderPeople =
            dataOlderPeople.sortedWith(compareBy { it.name }).toCollection(ArrayList())
        dataMiddleAge = dataMiddleAge.sortedWith(compareBy { it.name }).toCollection(ArrayList())


        Log.d("Main sort ", "${dataYouth[1].name}")
        adapterOlderPeople!!.notifyDataSetChanged()
        adapterAdolescent!!.notifyDataSetChanged()
        adapterMiddleAge!!.notifyDataSetChanged()
        adapterYouth!!.notifyDataSetChanged()
    }

    private lateinit var currentDataType: String
    private lateinit var dataAll: ArrayList<People>
    private var currentPosition: Int? = null
    private var updateDialog: UpdateDialog? = null
    private var adapterAdolescent: BaseAdapter? = null
    private var adapterYouth: BaseAdapter? = null
    private var adapterMiddleAge: BaseAdapter? = null
    private var adapterOlderPeople: BaseAdapter? = null
    private var dataAdolescent: ArrayList<People> = ArrayList()
    private var dataYouth: ArrayList<People> = ArrayList()
    private var dataMiddleAge: ArrayList<People> = ArrayList()
    private var dataOlderPeople: ArrayList<People> = ArrayList()

    override fun onUpdateDialogPositiveClick(dialog: DialogFragment) {
        val people = updateDialog!!.getPeopleUpdate()
        val lastAge = updateDialog!!.lastAge
        when (people.age) {
            in 0..15 -> updateInfo(people, dataYouth, adapterYouth!!, lastAge!!)
            in 16..39 -> updateInfo(people, dataAdolescent, adapterAdolescent!!, lastAge!!)
            in 40..59 -> updateInfo(people, dataMiddleAge, adapterMiddleAge!!, lastAge!!)
            in 60..100 -> updateInfo(people, dataOlderPeople, adapterOlderPeople!!, lastAge!!)
        }
    }

    override fun onUpdateDialogNegativeClick(dialog: DialogFragment) {
    }

    override fun onDelDialogPositiveClick(dialog: DialogFragment) {
        when (currentDataType) {
            "youth" -> deleteItem(dataYouth, currentPosition!!, adapterYouth!!)
            "adolescent" -> deleteItem(dataAdolescent, currentPosition!!, adapterAdolescent!!)
            "middleAge" -> deleteItem(dataMiddleAge, currentPosition!!, adapterMiddleAge!!)
            "older" -> deleteItem(dataOlderPeople, currentPosition!!, adapterOlderPeople!!)
        }
    }

    private fun updateInfo(
        people: People,
        data: ArrayList<People>,
        adapter: BaseAdapter,
        lastAge: Int
    ) {
        if ((lastAge in 0..15 && people.age in 0..15) ||
            (lastAge in 16..39 && people.age in 16..39) ||
            (lastAge in 40..59 && people.age in 40..59) ||
            (lastAge in 60..100 && people.age in 60..100)
        ) {
            val index = dataAll.indexOf(data[currentPosition!!])
            dataAll[index] = people
            val json: String = Gson().toJson(dataAll)
            share!!.put(KEY_VALUE, json)

            data[currentPosition!!] = people
            adapter.notifyItemChanged(currentPosition!!)
        }

    }

    private fun SharedPreferences.put(key: String, value: String) {
        val editor: SharedPreferences.Editor = this.edit()
        editor.putString(key, value)
        editor.apply()
    }

    private fun deleteItem(data: ArrayList<People>, position: Int, adapter: BaseAdapter) {
        dataAll.remove(data[position])
        val json: String = Gson().toJson(dataAll)
        share!!.put(KEY_VALUE, json)
        data.removeAt(position)
        adapter.notifyItemRemoved(position)
        adapter.notifyItemRangeChanged(position, data.size)
    }

    override fun onDelDialogNegativeClick(dialog: DialogFragment) {
    }

    override fun onItemClickListener(position: Int, type: String) {
        currentPosition = position
        when (type) {
            "youth" -> updateDialog = UpdateDialog(dataYouth[position])
            "adolescent" -> updateDialog = UpdateDialog(dataAdolescent[position])
            "middleAge" -> updateDialog = UpdateDialog(dataMiddleAge[position])
            "older" -> updateDialog = UpdateDialog(dataOlderPeople[position])
        }
        updateDialog!!.show(supportFragmentManager, "show update dialog")
    }

    override fun onItemLongClickListener(position: Int, typeData: String): Boolean {
        currentDataType = typeData
        currentPosition = position
        val deleteDialog = DeleteDialog()
        deleteDialog.show(supportFragmentManager, "show delete dialog")
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        share = initSharePrefer(this)
    }

    private fun initView() {
        val json: String = share!!.get(KEY_VALUE)
        if (json != "") {
            val type = object : TypeToken<ArrayList<People>>() {}.type
            val data: ArrayList<People> = Gson().fromJson(json, type)
            dataAll = data
            for (i in 0 until data.size) {
                val people: People = data[i]
                when (people.age) {
                    in 0..15 -> dataYouth.add(people)
                    in 16..39 -> dataAdolescent.add(people)
                    in 40..59 -> dataMiddleAge.add(people)
                    in 60..100 -> dataOlderPeople.add(people)
                }
            }
            adapterYouth = BaseAdapter(dataYouth, this)
            adapterAdolescent = BaseAdapter(dataAdolescent, this)
            adapterMiddleAge = BaseAdapter(dataMiddleAge, this)
            adapterOlderPeople = BaseAdapter(dataOlderPeople, this)
            recycler_youth.adapter = adapterYouth
            recycler_adolescent.adapter = adapterAdolescent
            recycler_middle_age.adapter = adapterMiddleAge
            recycler_older_people.adapter = adapterOlderPeople

            adapterYouth!!.itemClickListener = this
            adapterAdolescent!!.itemClickListener = this
            adapterMiddleAge!!.itemClickListener = this
            adapterOlderPeople!!.itemClickListener = this

        } else {
            Toast.makeText(this, "data null", Toast.LENGTH_SHORT).show()
        }
        btn_create.setOnClickListener { finish() }
        btn_sort.setOnClickListener { sortList() }
    }

    private fun sortList() {
        val popup = PopupMenu(this, btn_sort)
        popup.inflate(R.menu.menu_sort)
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    private fun SharedPreferences.get(key: String): String {
        return this.getString(key, "")!!
    }
}
