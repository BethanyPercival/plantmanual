package com.bethanypercival.plantmanual.ui.plantList;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bethanypercival.plantmanual.R;
import com.bethanypercival.plantmanual.model.PlantOverview;
import com.bethanypercival.plantmanual.ui.plantdetailed.PlantDetailedActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlantListActivity extends AppCompatActivity implements IPlantListView {

    public static final String EXTRA_NAME = "com.bethanypercival.rxjavatestapp.ui.plantlist.name";

    private IPlantListPresenter presenter;
    private PlantListRecyclerAdapter adapter;
    private List<PlantOverview> plantOverviewList;

    @BindView(R.id.recyclerViewAllPlants)
    RecyclerView recyclerViewAllPlants;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initialiseActivity();
    }

    @Override
    public void populateRecyclerView(final List<PlantOverview> plantOverviewList) {
        this.plantOverviewList = plantOverviewList;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerViewAllPlants.setAdapter(new PlantListRecyclerAdapter(plantOverviewList, presenter, getBaseContext()));
            }
        });
    }

    @Override
    public void openPlantDetails(String name) {
        Intent intent = new Intent(this, PlantDetailedActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        startActivity(intent);
    }

    private void initialiseActivity() {
        setUpRecyclerView();
        presenter = new PlantListPresenter(this, new PlantListData());
        presenter.onViewReady();
    }

    private void setUpRecyclerView() {
        adapter = new PlantListRecyclerAdapter(plantOverviewList, presenter, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewAllPlants.setLayoutManager(layoutManager);
        recyclerViewAllPlants.setAdapter(adapter);
    }
}
