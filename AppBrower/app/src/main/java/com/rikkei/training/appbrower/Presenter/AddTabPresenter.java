package com.rikkei.training.appbrower.Presenter;

public class AddTabPresenter implements LoadURLContract.Presenter {
    private LoadURLContract.Views mViews;

    public void setmViews(LoadURLContract.Views mViews) {
        this.mViews = mViews;
    }

    @Override
    public void handleLoadURL(String url) {
        if (url.equals("")) {
            mViews.loadFailure();
            return;
        } else {
            mViews.loadSuccess(url);
        }
    }
}
