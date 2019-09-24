package com.rikkei.training.appbrower.Presenter.save_bookmark;

import android.content.Context;

import com.rikkei.training.appbrower.model.History;
import com.rikkei.training.appbrower.screen.WebViewFragment;

import java.util.List;

public interface BookmarkContract {
    interface Views {
        void saveSuccess(List<History> listBookmark);

        void saveFailure();
    }

    interface Presenter {
        void handleSaveBookmark(Context context, WebViewFragment Fragment);
    }
}
