package com.bethanypercival.rxjavatestapp.plantList;

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

    }

    @Override
    public void onDataReady() {

    }

    //onViewReady - get data

    //onDataReady - give data
}
