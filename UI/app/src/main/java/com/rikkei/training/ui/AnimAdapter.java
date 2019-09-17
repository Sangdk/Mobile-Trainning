package com.rikkei.training.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rikkei.training.ui.databinding.ItemAnimBinding;
import com.rikkei.training.ui.model.ItemAnim;

import java.util.List;

public class AnimAdapter extends RecyclerView.Adapter<AnimAdapter.AnimHolder> {
    private LayoutInflater inflater;
    private List<ItemAnim> data;

    public void setData(List<ItemAnim> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public AnimAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AnimHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAnimBinding binding = ItemAnimBinding.inflate(inflater, parent, false);
        return new AnimHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimHolder holder, int position) {
        holder.binding.setItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class AnimHolder extends RecyclerView.ViewHolder {
        ItemAnimBinding binding;

        public AnimHolder(@NonNull ItemAnimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
