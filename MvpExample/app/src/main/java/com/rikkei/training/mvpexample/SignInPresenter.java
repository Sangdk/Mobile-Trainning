package com.rikkei.training.mvpexample;

import android.util.Log;

public class SignInPresenter implements SignInContract.Presenter {
    private SignInContract.view mViews;

    public void setViews(SignInContract.view mViews) {
        this.mViews = mViews;
    }

    @Override
    public void handleSignIn(String username, String password) {
        Log.d("AAA",username+" "+password);
        if (username.equals("iked") && password.equals("1234")){
            mViews.signInSuccess();
            return;
        }
        mViews.signInFailure("user name or password wrong");
    }
}
