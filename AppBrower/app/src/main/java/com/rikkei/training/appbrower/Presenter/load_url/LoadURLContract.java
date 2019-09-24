package com.rikkei.training.appbrower.Presenter.load_url;

public interface LoadURLContract {
    interface Views{
        void loadSuccess(String url);
        void loadFailure();
    }

    interface Presenter{
        void handleLoadURL(String url);
    }

}
