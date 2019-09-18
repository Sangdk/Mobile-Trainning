package com.rikkei.training.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rikkei.training.ui.R;
import com.rikkei.training.ui.base.BaseDialogFragment;

public class EraseDialogFragment extends BaseDialogFragment {
    public EraseDialogFragment(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.erase_dialog_title)
                .setMessage(R.string.erase_dialog_message)
                .setIcon(R.drawable.ic_warning)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "All photo and media have been delete!", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
