package com.bethanypercival.plantmanual.ui.plantdetailed;

import com.bethanypercival.plantmanual.networking.response.GetPlantDetailsResponse;

/**
 * Created by bethanypercival on 12/03/2018.
 */

public interface IPlantDetailedPresenter {
    void onViewReady(String name);

    void onDataReady(GetPlantDetailsResponse getPlantDetailsResponse);
}
