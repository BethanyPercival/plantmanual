package com.bethanypercival.plantmanual.ui.plantList;

import com.bethanypercival.plantmanual.networking.response.GetAllPlantsResponse;

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
    public void onDataReady(GetAllPlantsResponse plantOverviews) {
        view.populateRecyclerView(plantOverviews.getResults());
    }

    @Override
    public void onListItemClicked(String name) {
        if(name != null) {
            view.openPlantDetails(name);
        }
    }
}
