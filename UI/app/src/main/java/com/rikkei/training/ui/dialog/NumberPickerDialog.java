package com.rikkei.training.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.rikkei.training.ui.R;
import com.rikkei.training.ui.base.BaseDialogFragment;
import com.rikkei.training.ui.databinding.DialogMessageLimitBinding;

public class NumberPickerDialog extends BaseDialogFragment {
    private DialogMessageLimitBinding binding;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_message_limit, null, false);
        binding.numberPicker.setMinValue(1);
        binding.numberPicker.setMaxValue(8);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.number_picker_dialog)
                .setView(binding.getRoot())
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }

    public NumberPickerDialog(Context context) {
        super(context);
    }
}
