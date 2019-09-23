package com.rikkei.training.appbrower.model;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabHost {
    private String mName;
    private Boolean mIsFocus;
    @Nullable
    private View mButtonDel;
    private Fragment mWebViewFragment;

    public TabHost(String name, Boolean isFocus, View mButtonDel, Fragment mWebViewFragment) {
        this.mName = name;
        this.mIsFocus = isFocus;
        this.mButtonDel = mButtonDel;
        this.mWebViewFragment = mWebViewFragment;
    }

    public Fragment getWebViewFragment() {
        return mWebViewFragment;
    }

    public void setWebViewFragment(Fragment mWebViewFragment) {
        this.mWebViewFragment = mWebViewFragment;
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
