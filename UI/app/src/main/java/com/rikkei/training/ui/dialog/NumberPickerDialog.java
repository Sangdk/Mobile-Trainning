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

public class NumberPickerDialog extends BaseDialogFragment implements NumberPicker.OnValueChangeListener {
    private DialogMessageLimitBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_message_limit, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        final String[] values = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        binding.numberPicker.setDisplayedValues(values);
        binding.numberPicker.setMinValue(1);
        binding.numberPicker.setMaxValue(8);
        binding.numberPicker.setOnValueChangedListener(this);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.number_picker_dialog)
                .setView(inflater.inflate(R.layout.dialog_message_limit, null))
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

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        Toast.makeText(getContext(), numberPicker.getValue(), Toast.LENGTH_SHORT).show();
    }
}
