package com.rikkei.training.ui.model;

import androidx.annotation.DrawableRes;

public class Image {
    private int img;

    public Image(@DrawableRes int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
