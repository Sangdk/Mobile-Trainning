package com.rikkei.training.appbrower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.rikkei.training.appbrower.Presenter.LoadURLContract;
import com.rikkei.training.appbrower.Presenter.AddTabPresenter;
import com.rikkei.training.appbrower.adapter.HistoryAdapter;
import com.rikkei.training.appbrower.adapter.TabAdapter;
import com.rikkei.training.appbrower.dao.AppDatabase;
import com.rikkei.training.appbrower.databinding.ActivityMainBinding;
import com.rikkei.training.appbrower.databinding.DialogHistoryBinding;
import com.rikkei.training.appbrower.dialog.DialogHistory;
import com.rikkei.training.appbrower.model.History;
import com.rikkei.training.appbrower.model.TabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        TabAdapter.OnItemClickListener, PopupMenu.OnMenuItemClickListener, LoadURLContract.Views {
    private ActivityMainBinding binding;
    private TabAdapter adapter;
    private List<TabHost> arrTabs = new ArrayList<>();
    private WebViewFragment mFragWebView;
    private List<WebViewFragment> arrWebViews = new ArrayList<>();
    private AddTabPresenter mAddTabPre;
    private List<History> mArrHistories = new ArrayList<>();
    private HistoryAdapter mHistoryAdapter;
    private DialogHistory mDialogHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initViews();
        initData();
        initPresenter();
    }

    private void initPresenter() {
        mAddTabPre = new AddTabPresenter();
        mAddTabPre.setmViews(this);
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
        if (dataHistory!=null){
            mArrHistories = dataHistory;
            mHistoryAdapter = new HistoryAdapter(this);
            mHistoryAdapter.setData(mArrHistories);
            Log.d("AAA: ","Data: "+mArrHistories.size());
        }
    }

    private void initViews() {
        binding.addTab.setOnClickListener(this);
        binding.menu.setOnClickListener(this);
        binding.btnNext.setOnClickListener(this);
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
        }
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
        switch (menuItem.getItemId()){
            case R.id.item_history:
                mDialogHistory = new DialogHistory(this,mHistoryAdapter);
                mDialogHistory.show(getSupportFragmentManager(),"show dialog");
                break;
        }
        return false;
    }

    @Override
    public void loadSuccess(String url) {
        mFragWebView.loadURL();
        History item = new History(url, false);
        AppDatabase.getInstance(this).getHistoryDao().insert(item);
        mArrHistories.add(item);
        mHistoryAdapter.setData(mArrHistories);
    }

    @Override
    public void loadFailure() {
        Toast.makeText(this, "Enter URL first", Toast.LENGTH_SHORT).show();
    }
}
