package com.rikkei.training.mvpexample;

public interface SignInContract {
    interface view {
        void signInSuccess();

        void signInFailure(String error);
    }
    interface Presenter{
        void handleSignIn(String username, String password);
    }
}
