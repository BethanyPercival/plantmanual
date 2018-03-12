package com.bethanypercival.rxjavatestapp.ui.plantdetailed;

import com.bethanypercival.rxjavatestapp.networking.response.GetPlantDetailsResponse;

/**
 * Created by bethanypercival on 12/03/2018.
 */

public interface IPlantDetailedPresenter {
    void onViewReady(String name);

    void onDataReady(GetPlantDetailsResponse getPlantDetailsResponse);
}
