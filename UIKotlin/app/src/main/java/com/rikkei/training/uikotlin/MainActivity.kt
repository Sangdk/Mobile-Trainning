package com.rikkei.training.uikotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.rikkei.training.uikotlin.model.Image
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter: Adapter?=null
    private var data: ArrayList<Image>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {

    }

    private fun initData() {
        data = ArrayList()
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))

        adapter = Adapter(data!!,this)
        recycler_linear!!.adapter = adapter
        recycler_grid!!.adapter = adapter
        recycler_staggered!!.adapter = adapter
    }
}
