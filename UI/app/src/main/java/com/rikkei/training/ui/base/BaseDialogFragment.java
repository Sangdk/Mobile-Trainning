package com.rikkei.training.ui.base;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.fragment.app.DialogFragment;

public class BaseDialogFragment extends DialogFragment {
    protected LayoutInflater inflater;

    public BaseDialogFragment(Context context) {
        inflater = LayoutInflater.from(context);
    }
}
