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

public class BrightnessDialogFragment extends BaseDialogFragment {

    public BrightnessDialogFragment(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.bright_dialog_message)
                .setIcon(R.drawable.ic_settings)
                .setView(inflater.inflate(R.layout.dialog_brightness, null))
                .setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
