package com.rikkei.training.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ImageHolder> {
    private LayoutInflater inflater;
    private List<Image> data;

    public Adapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<Image> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item,parent,false);

        return new ImageHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        Image item = data.get(position);
        holder.bindData(item);

    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public class ImageHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_item);
        }
        public void bindData(Image item){
            img.setImageResource(item.getImg());
        }
    }
}
