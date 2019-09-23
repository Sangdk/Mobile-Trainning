package com.rikkei.training.appbrower.Presenter;

public interface LoadURLContract {
    interface Views{
        void loadSuccess(String url);
        void loadFailure();
    }

    interface Presenter{
        void handleLoadURL(String url);
    }

}
