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

import com.rikkei.training.appbrower.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        TabAdapter.OnItemClickListener, PopupMenu.OnMenuItemClickListener {
    private ActivityMainBinding binding;
    private TabAdapter adapter;
    private List<TabHost> data = new ArrayList<>();
    private WebViewFragment mFragWebView = new WebViewFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initViews();
        initData();
        initPresenter();
    }

    private void initPresenter() {
    }

    private void initData() {
        adapter = new TabAdapter(this);
        adapter.setData(data);
        binding.recyclerTab.setAdapter(adapter);
        adapter.setListener(this);
        binding.recyclerTab.addItemDecoration(new DividerItemDecoration(binding.recyclerTab
                .getContext(),
                DividerItemDecoration.HORIZONTAL));

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.label, mFragWebView);
        transaction.commit();
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
                if (data != null) {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setFocus(false);
                    }
                }
                TabHost tab = new TabHost("New tab", true, null);
                data.add(tab);
                adapter.setData(data);
                break;
            case R.id.menu:
                showPopupMenu(view);
                break;
            case R.id.btn_next:
                showWebView();
                break;
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            showWebView();
        }
        return super.dispatchKeyEvent(event);
    }

    private void showWebView() {
        String url = binding.edtUrl.getText().toString();
        if (!url.equals("")) {
            mFragWebView.showWebView(url);
        } else {
            Toast.makeText(this, "Enter URL first", Toast.LENGTH_SHORT).show();
        }
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
        return false;
    }
}
