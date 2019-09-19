package com.rikkei.training.inputandroid;

import android.widget.TextView;

import androidx.annotation.Nullable;

public class Key {
    private String name;
    private int keyCode;
    private TextView view;
    @Nullable
    private Key key_up;
    @Nullable
    private Key key_down;
    @Nullable
    private Key key_left;
    @Nullable
    private Key key_right;

    public Key(TextView view, String name, int keyCode, @Nullable Key key_up, @Nullable Key key_down, @Nullable Key key_left, @Nullable Key key_right) {
        this.name = name;
        this.keyCode = keyCode;
        this.key_up = key_up;
        this.key_down = key_down;
        this.key_left = key_left;
        this.key_right = key_right;
        this.view = view;
    }

    public TextView getView() {
        return view;
    }

    public void setView(TextView view) {
        this.view = view;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public Key getKey_up() {
        return key_up;
    }

    public void setKey_up(Key key_up) {
        this.key_up = key_up;
    }

    public Key getKey_down() {
        return key_down;
    }

    public void setKey_down(Key key_down) {
        this.key_down = key_down;
    }

    public Key getKey_left() {
        return key_left;
    }

    public void setKey_left(Key key_left) {
        this.key_left = key_left;
    }

    public Key getKey_right() {
        return key_right;
    }

    public void setKey_right(Key key_right) {
        this.key_right = key_right;
    }
}
