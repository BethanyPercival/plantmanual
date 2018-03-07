package com.bethanypercival.rxjavatestapp.plantList;

import com.bethanypercival.rxjavatestapp.model.Plant;

import java.util.List;

/**
 * Created by bethanypercival on 07/03/2018.
 */

public class PlantListPresenter implements IPlantListPresenter {

    private IPlantListView view;
    private PlantListData data;

    PlantListPresenter(IPlantListView view, PlantListData data) {
        this.view = view;
        this.data = data;
    }

    @Override
    public void onViewReady() {
        data.getAllPlants(this);
    }

    @Override
    public void onDataReady(List<Plant> plants) {

    }
}
