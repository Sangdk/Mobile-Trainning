package com.rikkei.training.appbrower.dialog;


import android.content.Context;
import android.view.LayoutInflater;

import androidx.fragment.app.DialogFragment;

public class BaseDialog extends DialogFragment {
    protected LayoutInflater inflater;

    public BaseDialog(Context context) {
        inflater = LayoutInflater.from(context);
    }
}

