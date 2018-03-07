package com.bethanypercival.rxjavatestapp.plantList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bethanypercival.rxjavatestapp.R;

import butterknife.ButterKnife;

public class PlantListActivity extends AppCompatActivity implements IPlantListView {

    private IPlantListPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);
        ButterKnife.bind(this);
        initialiseActivity();
    }

    private void initialiseActivity() {

        presenter = new PlantListPresenter(this, new PlantListData());
        presenter.onViewReady();
    }

    //prepare viewpager

    //prepare recyclerview

    //give data to recyclerview
}
