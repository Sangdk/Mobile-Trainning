package com.rikkei.training.appbrower;

import android.view.View;

import androidx.annotation.Nullable;

public class TabHost {
    private String mName;
    private Boolean mIsFocus;
    @Nullable
    private View mButtonDel;

    public TabHost(String name, Boolean isFocus, View mButtonDel) {
        this.mName = name;
        this.mIsFocus = isFocus;
        this.mButtonDel = mButtonDel;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public Boolean getFocus() {
        return mIsFocus;
    }

    public void setFocus(Boolean focus) {
        mIsFocus = focus;
    }

    @Nullable
    public View getButtonDel() {
        return mButtonDel;
    }

    public void setButtonDel(@Nullable View mButtonDel) {
        this.mButtonDel = mButtonDel;
    }
}
