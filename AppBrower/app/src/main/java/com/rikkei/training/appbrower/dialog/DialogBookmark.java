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
import com.rikkei.training.appbrower.adapter.URLAdapter;
import com.rikkei.training.appbrower.databinding.DialogBookmarkBinding;

public class DialogBookmark extends BaseDialog {
    private URLAdapter adapter;
    private DialogBookmarkBinding binding;

    public DialogBookmark(Context context, URLAdapter adapter) {
        super(context);
        this.adapter = adapter;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_bookmark, null, false);
        binding.recyclerBookmark.setAdapter(adapter);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.bookmark)
                .setIcon(R.drawable.ic_bookmark)
                .setView(binding.getRoot())
                .setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }
}
