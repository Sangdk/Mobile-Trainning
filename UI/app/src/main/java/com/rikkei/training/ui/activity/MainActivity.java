package com.rikkei.training.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rikkei.training.ui.Adapter;
import com.rikkei.training.ui.model.Image;
import com.rikkei.training.ui.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerLinear;
    private RecyclerView recyclerGrid;
    private RecyclerView recyclerStaggered;
    private Adapter adapter;
    private Adapter adapterGrid;
    private List<Image> data;
    private List<Image> dataGrid;
    private Button mButtonToolbar;

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
        data.add(new Image(R.drawable.ic_launcher_background));
        data.add(new Image(R.drawable.ic_launcher_background));
        data.add(new Image(R.drawable.ic_launcher_background));
        data.add(new Image(R.drawable.ic_launcher_background));
        data.add(new Image(R.drawable.ic_launcher_background));
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
        recyclerStaggered.setNestedScrollingEnabled(false);
    }

    private void initView() {
        recyclerLinear = findViewById(R.id.recycler_linear);
        recyclerGrid = findViewById(R.id.recycler_grid);
        recyclerStaggered = findViewById(R.id.recycler_staggered);
        mButtonToolbar = findViewById(R.id.btn_actToolbar);
        mButtonToolbar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ToolbarActivity.class);
        startActivity(intent);
        finish();
    }
}
