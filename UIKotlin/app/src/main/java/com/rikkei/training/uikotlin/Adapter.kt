package com.rikkei.training.uikotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rikkei.training.uikotlin.model.Image
import kotlinx.android.synthetic.main.item.view.*

class Adapter(private var data: ArrayList<Image>, private val context: Context) :
    RecyclerView.Adapter<Adapter.ImageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.onBind(data[position])
    }


    class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemViewType = itemView.img_item
        fun onBind(item: Image){
            itemViewType.setImageResource(item.img!!)
        }
    }
}