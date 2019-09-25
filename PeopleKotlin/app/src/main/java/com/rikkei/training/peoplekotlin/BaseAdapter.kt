package com.rikkei.training.peoplekotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_people_info.view.*

class BaseAdapter(private val data: ArrayList<People>, private val context: Context) :
    RecyclerView.Adapter<BaseAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_people_info,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.onBind(data[position])
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(item: People) {
            when (item.age) {
                in 0..15 -> itemView.img_item.setImageResource(R.drawable.ic_youth)
                in 16..39 -> itemView.img_item.setImageResource(R.drawable.ic_adolescent)
                in 40..59 -> itemView.img_item.setImageResource(R.drawable.ic_middle_age)
                in 60..100 -> itemView.img_item.setImageResource(R.drawable.ic_older)
            }
            val id = "ID: "
            val age = "Age: "
            val gender = "Gender: "
            val name = "Name: "
            val country = "Country: "
            itemView.text_id.text = id + item.id.toString()
            itemView.text_age.text = age + item.age.toString()
            itemView.text_gender.text = gender + item.gender
            itemView.text_name.text = name + item.name
            itemView.text_country.text = country + item.country
        }
    }
}