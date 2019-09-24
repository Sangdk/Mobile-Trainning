package com.rikkei.training.appbrower.Presenter.save_bookmark;

import android.content.Context;

import com.rikkei.training.appbrower.dao.AppDatabase;
import com.rikkei.training.appbrower.model.History;
import com.rikkei.training.appbrower.screen.WebViewFragment;

import java.util.ArrayList;
import java.util.List;

public class BookmarkPresenter implements BookmarkContract.Presenter {
    private BookmarkContract.Views mViews;
    private long mCurrentId;

    public void setViews(BookmarkContract.Views mViews) {
        this.mViews = mViews;
    }

    @Override
    public void handleSaveBookmark(Context context, WebViewFragment fragment) {
        if (context != null && fragment != null) {
            String url = fragment.getUrl();
            if (!url.equals("")) {
                List<History> current = AppDatabase.getInstance(context).getHistoryDao().getAll();
                mCurrentId = current.get(current.size() - 1).getId();
                AppDatabase.getInstance(context).getHistoryDao().setBookmark(mCurrentId);
                List<History> listAll = AppDatabase.getInstance(context).getHistoryDao().getAll();
                List<History> listBookmark = new ArrayList<>();
                for (int i = 0; i < listAll.size(); i++) {
                    if (listAll.get(i).getIsBookmark() == 1) {
                        listBookmark.add(listAll.get(i));
                    }
                }
                mViews.saveSuccess(listBookmark);
            } else {
                mViews.saveFailure();
            }
        } else {
            mViews.saveFailure();
        }
    }
}
