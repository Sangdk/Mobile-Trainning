package com.rikkei.training.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.rikkei.training.fragment.fragment.AFragment;
import com.rikkei.training.fragment.fragment.BFragment;

public class MainActivity extends AppCompatActivity {
    private AFragment mFragA = new AFragment();
    private BFragment mFragB = new BFragment();
    private final String mISRUNNING_KEY = "isRunning";

    @Override
    protected void onCreate(Bundle outState) {
        super.onCreate(outState);
        setContentView(R.layout.activity_main);

        if (outState == null) {
            addFragment(mFragA);
        }
    }

    public void addFragment(Fragment fmAdd) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fmAdd == mFragA) {
            transaction.remove(mFragB);
        } else {
            transaction.remove(mFragA);
        }
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        transaction.add(R.id.panel, fmAdd);
        transaction.addToBackStack("add fragment");
        transaction.commit();
    }

    public AFragment getFragA() {
        return mFragA;
    }

    public void setFragA(AFragment mFragA) {
        this.mFragA = mFragA;
    }

    public BFragment getFragB() {
        return mFragB;
    }

    public void setFragB(BFragment mFragB) {
        this.mFragB = mFragB;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(mISRUNNING_KEY, true);
    }
}
