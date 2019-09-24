package com.rikkei.training.appbrower.Presenter.load_url;

public class LoadURLPresenter implements LoadURLContract.Presenter {
    private LoadURLContract.Views mViews;

    public void setViews(LoadURLContract.Views mViews) {
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
