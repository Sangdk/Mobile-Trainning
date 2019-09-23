package com.rikkei.training.appbrower.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.rikkei.training.appbrower.R;
import com.rikkei.training.appbrower.adapter.HistoryAdapter;
import com.rikkei.training.appbrower.databinding.DialogHistoryBinding;

public class DialogHistory extends BaseDialog {
    private DialogHistoryBinding binding;
    private HistoryAdapter adapter;

    public DialogHistory(Context context, HistoryAdapter adapter) {
        super(context);
        this.adapter = adapter;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_history, null, false);
        binding.recyclerHistory.setAdapter(adapter);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.history)
                .setIcon(R.drawable.ic_history)
                .setView(binding.getRoot())
                .setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        return builder.create();
    }
}
