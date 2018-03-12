package com.bethanypercival.rxjavatestapp.ui.plantdetailed;

import com.bethanypercival.rxjavatestapp.model.PlantDetailed;
import com.bethanypercival.rxjavatestapp.networking.response.GetPlantDetailsResponse;

/**
 * Created by bethanypercival on 12/03/2018.
 */

public class PlantDetailedPresenter implements IPlantDetailedPresenter {

    private IPlantDetailedView view;
    private PlantDetailedData data;

    PlantDetailedPresenter(IPlantDetailedView view, PlantDetailedData data) {
        this.view = view;
        this.data = data;
    }

    @Override
    public void onViewReady(String name) {
        data.getPlantDetails(name, this);
    }

    @Override
    public void onDataReady(GetPlantDetailsResponse getPlantDetailsResponse) {
        view.populateFields(getPlantDetailsResponse.getPlantDetailedList().get(0));
    }
}
