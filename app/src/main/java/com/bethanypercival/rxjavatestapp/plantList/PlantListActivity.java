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

    @BindView(R.id.recyclerViewAllPlants)
    RecyclerView recyclerViewAllPlants;

    private IPlantListPresenter presenter;
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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewAllPlants.setLayoutManager(layoutManager);
    }

    @Override
    public void populateRecyclerView(List<PlantOverview> plantOverviewList) {
        recyclerViewAllPlants.setAdapter(new PlantListRecyclerAdapter(plantOverviewList));
    }
}
