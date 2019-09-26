package com.rikkei.training.peoplekotlin.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rikkei.training.peoplekotlin.R
import com.rikkei.training.peoplekotlin.model.People
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    companion object {
        var share: SharedPreferences? = null
        fun initSharePrefer(con: Context): SharedPreferences {

            if (share == null) {
                share = con.getSharedPreferences("PeoplePrefer", Context.MODE_PRIVATE)

            }
            return share!!
        }

        const val KEY_VALUE = "key_value"

    }

    private lateinit var arr: Array<String>
    private lateinit var gender: String
    private lateinit var share: SharedPreferences
    private var data: ArrayList<People> = ArrayList()
    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        arr = resources.getStringArray(R.array.gender_array)
        gender = arr[p2]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        share =
            initSharePrefer(
                this
            )
        initView()
        register()
    }

    private fun EditText.getString(): String {
        return this.text.toString()
    }

    private fun SharedPreferences.put(key: String, value: String) {
        val editor: SharedPreferences.Editor = this.edit()
        editor.putString(key, value)
        editor.apply()
    }

    private fun SharedPreferences.get(key: String): String {
        return this.getString(key, "")!!
    }

    private fun register() {
        val dataSaved: String = share.get(KEY_VALUE)
        if (dataSaved != "") {
            val type = object : TypeToken<ArrayList<People>>() {}.type
            data = Gson().fromJson(dataSaved, type)
        }
        btn_create.setOnClickListener {
            if (edt_id.getString() == "" || edt_age.getString() == "" || edt_name.getString() == "" || edt_country.getString() == "") {
                Toast.makeText(this, "Can't not be empty", Toast.LENGTH_SHORT).show()

            } else {
                val id: Int = edt_id.getString().toInt()
                val name: String = edt_name.getString()
                val age: Int = edt_age.getString().toInt()
                val country: String = edt_country.getString()
                val people =
                    People(id, name, gender, age, country)
                data.add(people)
                val json: String = Gson().toJson(data)
                share.put(KEY_VALUE, json)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        btn_list.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initView() {
        initSpinner()
    }

    private fun initSpinner() {
        val spinner: Spinner = findViewById(R.id.spinner_gender)
        ArrayAdapter.createFromResource(
            this,
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this
    }
}
