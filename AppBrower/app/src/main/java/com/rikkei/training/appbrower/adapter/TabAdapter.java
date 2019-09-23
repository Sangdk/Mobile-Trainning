package com.rikkei.training.appbrower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rikkei.training.appbrower.MainActivity;
import com.rikkei.training.appbrower.R;
import com.rikkei.training.appbrower.WebViewFragment;
import com.rikkei.training.appbrower.databinding.ItemTabBinding;
import com.rikkei.training.appbrower.model.TabHost;

import java.util.List;

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.TabHolder> {
    private LayoutInflater inflater;
    private List<TabHost> data;
    private OnItemClickListener mListener;

    public TabAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<TabHost> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public TabHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTabBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_tab, parent, false);
        return new TabHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TabHolder holder, int position) {
        final TabHost item = data.get(position);
        holder.bindData(item, position);

        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClicked(item);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class TabHolder extends RecyclerView.ViewHolder {
        private ItemTabBinding binding;

        public TabHolder(@NonNull ItemTabBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(final TabHost item, final int position) {
            binding.itemTab.setText(item.getName());
            item.setButtonDel(binding.btnDelTab);
            binding.btnDelTab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity main = (MainActivity) data.get(position).getWebViewFragment().getActivity();
                    main.removeFrag((WebViewFragment) data.get(position).getWebViewFragment());
                    if (position > 0) {
                        main.showFragment((WebViewFragment) data.get(position - 1).getWebViewFragment());
                        data.get(position - 1).setFocus(true);
                        data.get(position - 1).getButtonDel().setVisibility(View.VISIBLE);
                    }
                    data.remove(position);
                    notifyDataSetChanged();
                }
            });
            if (!item.getFocus()) {
                binding.btnDelTab.setVisibility(View.GONE);
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(TabHost tab);
    }

}
