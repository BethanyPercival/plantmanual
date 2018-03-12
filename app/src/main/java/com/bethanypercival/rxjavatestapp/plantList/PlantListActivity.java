package com.bethanypercival.rxjavatestapp.plantList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bethanypercival.rxjavatestapp.R;
import com.bethanypercival.rxjavatestapp.model.PlantOverview;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlantListActivity extends AppCompatActivity implements IPlantListView {

    private IPlantListPresenter presenter;
    private PlantListRecyclerAdapter adapter;
    private List<PlantOverview> plantOverviewList;

    @BindView(R.id.recyclerViewAllPlants)
    RecyclerView recyclerViewAllPlants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);
        ButterKnife.bind(this);
        initialiseActivity();
    }

    private void initialiseActivity() {
        setUpRecyclerView();
        presenter = new PlantListPresenter(this, new PlantListData());
        presenter.onViewReady();
    }

    private void setUpRecyclerView() {
        adapter = new PlantListRecyclerAdapter(plantOverviewList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewAllPlants.setLayoutManager(layoutManager);
        recyclerViewAllPlants.setAdapter(adapter);
    }

    @Override
    public void populateRecyclerView(final List<PlantOverview> plantOverviewList) {
        this.plantOverviewList = plantOverviewList;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerViewAllPlants.setAdapter(new PlantListRecyclerAdapter(plantOverviewList));
            }
        });
    }
}
