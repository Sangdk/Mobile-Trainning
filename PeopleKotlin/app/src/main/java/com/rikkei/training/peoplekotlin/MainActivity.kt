package com.rikkei.training.peoplekotlin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rikkei.training.peoplekotlin.RegisterActivity.Companion.KEY_VALUE
import com.rikkei.training.peoplekotlin.RegisterActivity.Companion.initSharePrefer
import com.rikkei.training.peoplekotlin.RegisterActivity.Companion.share
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapterAdolescent: BaseAdapter? = null
    private var adapterYouth: BaseAdapter? = null
    private var adapterMiddleAge: BaseAdapter? = null
    private var adapterOlderPeople: BaseAdapter? = null
    private var dataAdolescent: ArrayList<People> = ArrayList()
    private var dataYouth: ArrayList<People> = ArrayList()
    private var dataMiddleAge: ArrayList<People> = ArrayList()
    private var dataOlderPeople: ArrayList<People> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        share = initSharePrefer(this)
    }

    private fun initView() {
        val json: String = share!!.get(KEY_VALUE)
        val type = object : TypeToken<ArrayList<People>>() {}.type
        val data: ArrayList<People> = Gson().fromJson(json, type)
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

        btn_create.setOnClickListener { finish() }
    }

    private fun SharedPreferences.get(key: String): String {
        return this.getString(key, "")!!
    }
}
