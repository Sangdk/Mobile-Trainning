package com.rikkei.training.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;

import com.google.android.material.appbar.AppBarLayout;
import com.rikkei.training.ui.Adapter;
import com.rikkei.training.ui.model.Image;
import com.rikkei.training.ui.R;
import com.rikkei.training.ui.base.BaseActivity;
import com.rikkei.training.ui.databinding.ActivityToolbarBinding;

import java.util.ArrayList;
import java.util.List;

public class ToolbarActivity extends BaseActivity<ActivityToolbarBinding> {
    private Adapter mAdapter;
    private List<Image> data;
    private boolean appBarExpanded = true;
    private Menu collapseMenu;
    @Override
    protected void initAct() {
        data = new ArrayList<>();
        data.add(new Image(R.drawable.image));
        data.add(new Image(R.drawable.image));
        data.add(new Image(R.drawable.image));
        data.add(new Image(R.drawable.image));
        data.add(new Image(R.drawable.image));
        data.add(new Image(R.drawable.image));
        data.add(new Image(R.drawable.image));
        mAdapter = new Adapter(this);
        mAdapter.setData(data);
        binding.recycler.setAdapter(mAdapter);

        binding.appbar.addOnOffsetChangedListener(
                new AppBarLayout.OnOffsetChangedListener() {
                    @Override
                    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                        if (Math.abs(verticalOffset) >200){
                            appBarExpanded = false;
                            invalidateOptionsMenu();
                        }else {
                            appBarExpanded = true;
                            invalidateOptionsMenu();
                        }
                    }
                }
        );
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Bitmap  bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bg_header);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int vibrantColor = palette.getVibrantColor(getResources().getColor(R.color.primary_500));
                binding.collapsingToolbar.setContentScrimColor(vibrantColor);
                binding.collapsingToolbar.setStatusBarScrimColor(getResources().getColor(R.color.black_trans80));
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (collapseMenu != null && (!appBarExpanded || collapseMenu.size() != 1)){
            collapseMenu.add("Add")
                    .setIcon(R.drawable.ic_fab_add)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }else {

        }
        return super.onPrepareOptionsMenu(menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        collapseMenu = menu;
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_toolbar;
    }
}
