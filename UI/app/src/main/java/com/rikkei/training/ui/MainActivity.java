package com.rikkei.training.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerLinear;
    private RecyclerView recyclerGrid;
    private RecyclerView recyclerStaggered;
    private Adapter adapter;
    private Adapter adapterGrid;
    private List<Image> data;
    private List<Image> dataGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new Image(R.drawable.ic_launcher_background));
        data.add(new Image(R.drawable.ic_launcher_background));
        data.add(new Image(R.drawable.ic_launcher_background));
        data.add(new Image(R.drawable.ic_launcher_background));
        data.add(new Image(R.drawable.ic_launcher_background));
        data.add(new Image(R.drawable.ic_launcher_background));
        data.add(new Image(R.drawable.ic_launcher_background));

        dataGrid = new ArrayList<>();
        dataGrid.add(new Image(R.drawable.image));
        dataGrid.add(new Image(R.drawable.image));
        dataGrid.add(new Image(R.drawable.image));
        dataGrid.add(new Image(R.drawable.image));
        dataGrid.add(new Image(R.drawable.image));
        dataGrid.add(new Image(R.drawable.image));
        dataGrid.add(new Image(R.drawable.image));
        dataGrid.add(new Image(R.drawable.image));
        dataGrid.add(new Image(R.drawable.image));
        dataGrid.add(new Image(R.drawable.image));

        adapter = new Adapter(this);
        adapter.setData(data);
        adapterGrid = new Adapter(this);
        adapterGrid.setData(dataGrid);
        recyclerLinear.setAdapter(adapter);
        recyclerGrid.setAdapter(adapterGrid);
        recyclerStaggered.setAdapter(adapter);
    }

    private void initView() {
        recyclerLinear = findViewById(R.id.recycler_linear);
        recyclerGrid = findViewById(R.id.recycler_grid);
        recyclerStaggered = findViewById(R.id.recycler_staggered);
    }
}
