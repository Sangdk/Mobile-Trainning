package com.rikkei.training.appbrower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rikkei.training.appbrower.R;
import com.rikkei.training.appbrower.databinding.ItemUrlBinding;
import com.rikkei.training.appbrower.model.History;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {
    private LayoutInflater inflater;
    private List<History> data;

    public HistoryAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<History> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUrlBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_url, parent, false);
        return new HistoryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {
        History item = data.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        ItemUrlBinding binding;

        public HistoryHolder(@NonNull ItemUrlBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(History item) {
            binding.textUrl.setText(item.getUrl());
        }
    }
}
