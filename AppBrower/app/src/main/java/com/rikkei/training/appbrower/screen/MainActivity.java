package com.rikkei.training.appbrower.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.rikkei.training.appbrower.Presenter.load_url.LoadURLContract;
import com.rikkei.training.appbrower.Presenter.load_url.LoadURLPresenter;
import com.rikkei.training.appbrower.Presenter.save_bookmark.BookmarkContract;
import com.rikkei.training.appbrower.Presenter.save_bookmark.BookmarkPresenter;
import com.rikkei.training.appbrower.R;
import com.rikkei.training.appbrower.adapter.URLAdapter;
import com.rikkei.training.appbrower.adapter.TabAdapter;
import com.rikkei.training.appbrower.dao.AppDatabase;
import com.rikkei.training.appbrower.databinding.ActivityMainBinding;
import com.rikkei.training.appbrower.dialog.DialogBookmark;
import com.rikkei.training.appbrower.dialog.DialogHistory;
import com.rikkei.training.appbrower.model.History;
import com.rikkei.training.appbrower.model.TabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        TabAdapter.OnItemClickListener, PopupMenu.OnMenuItemClickListener, LoadURLContract.Views, BookmarkContract.Views {
    private ActivityMainBinding binding;
    private TabAdapter adapter;
    private List<TabHost> arrTabs = new ArrayList<>();
    private WebViewFragment mFragWebView;
    private List<WebViewFragment> arrWebViews = new ArrayList<>();
    private List<History> mArrHistories = new ArrayList<>();
    private URLAdapter mHistoryAdapter;
    private URLAdapter mBookmarkAdapter;
    private DialogHistory mDialogHistory;
    private DialogBookmark mDialogBookmark;
    private List<History> mArrBookmark = new ArrayList<>();
    private LoadURLPresenter mAddTabPre;
    private BookmarkPresenter mBookmarkPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initViews();
        initData();
        initPresenter();
    }

    private void initPresenter() {
        mAddTabPre = new LoadURLPresenter();
        mAddTabPre.setViews(this);

        mBookmarkPre = new BookmarkPresenter();
        mBookmarkPre.setViews(this);
    }

    private void initData() {
        adapter = new TabAdapter(this);
        adapter.setData(arrTabs);
        binding.recyclerTab.setAdapter(adapter);
        adapter.setListener(this);
        binding.recyclerTab.addItemDecoration(new DividerItemDecoration(binding.recyclerTab
                .getContext(),
                DividerItemDecoration.HORIZONTAL));

        List<History> dataHistory = AppDatabase.getInstance(this).getHistoryDao().getAll();
        if (dataHistory != null) {
            mArrHistories = dataHistory;
            mHistoryAdapter = new URLAdapter(this);
            mHistoryAdapter.setData(mArrHistories);

            for (int i = 0; i < dataHistory.size(); i++) {
                History item = dataHistory.get(i);
                if (item.getIsBookmark() == 1) {
                    mArrBookmark.add(item);
                }
            }
            if (mArrBookmark != null) {
                mBookmarkAdapter = new URLAdapter(this);
                mBookmarkAdapter.setData(mArrBookmark);
            }
        }
    }

    private void initViews() {
        binding.addTab.setOnClickListener(this);
        binding.menu.setOnClickListener(this);
        binding.btnNext.setOnClickListener(this);
        binding.bookmark.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_tab:
                if (arrTabs != null) {
                    for (int i = 0; i < arrTabs.size(); i++) {
                        arrTabs.get(i).setFocus(false);
                    }
                }
                mFragWebView = new WebViewFragment();
                TabHost tab = new TabHost("New tab", true, null, mFragWebView);
                arrTabs.add(tab);
                adapter.setData(arrTabs);

                addFragToAct(mFragWebView);
                if (arrWebViews != null) {
                    for (int i = 0; i < arrWebViews.size(); i++) {
                        hideFragment(arrWebViews.get(i));
                    }
                }
                arrWebViews.add(mFragWebView);
                break;
            case R.id.menu:
                showPopupMenu(view);
                break;
            case R.id.btn_next:
                loadURL();
                break;
            case R.id.bookmark:
                saveBookmark();
                break;
        }
    }

    private void saveBookmark() {
        mBookmarkPre.handleSaveBookmark(this, mFragWebView);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            loadURL();
        }
        return super.dispatchKeyEvent(event);
    }

    public void addFragToAct(WebViewFragment fmAdd) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.label, fmAdd);
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        transaction.commit();
    }

    public void removeFrag(WebViewFragment fmRemove) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(fmRemove);
        transaction.commit();
    }

    public void showFragment(WebViewFragment fmShow) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(fmShow);
        transaction.commit();
    }

    public void hideFragment(WebViewFragment fmHide) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fmHide);
        transaction.commit();
    }

    private void loadURL() {
        mAddTabPre.handleLoadURL(mFragWebView.getUrl());
    }

    private void showPopupMenu(View view) {
        PopupMenu menu = new PopupMenu(this, view);
        menu.inflate(R.menu.menu_bookmark);
        menu.setOnMenuItemClickListener(this);
        menu.show();
    }

    @Override
    public void onItemClicked(TabHost tab) {
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.item_history:
                mDialogHistory = new DialogHistory(this, mHistoryAdapter);
                mDialogHistory.show(getSupportFragmentManager(), "show dialog");
                break;
            case R.id.item_bookmark:
                mDialogBookmark = new DialogBookmark(this, mBookmarkAdapter);
                mDialogBookmark.show(getSupportFragmentManager(), "show dialog");
                break;
        }
        return false;
    }

    @Override
    public void loadSuccess(String url) {
        mFragWebView.loadURL();
        History item = new History(url, 0);
        AppDatabase.getInstance(this).getHistoryDao().insert(item);
        mArrHistories.add(item);
        mHistoryAdapter.setData(mArrHistories);
    }

    @Override
    public void loadFailure() {
        Toast.makeText(this, "Enter URL first", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveSuccess(List<History> listBookmark) {
        mArrBookmark = listBookmark;
        mBookmarkAdapter.setData(mArrBookmark);
        Toast.makeText(this, R.string.bookmark_success, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveFailure() {
        Toast.makeText(this, R.string.bookmark_failure, Toast.LENGTH_SHORT).show();
    }
}
