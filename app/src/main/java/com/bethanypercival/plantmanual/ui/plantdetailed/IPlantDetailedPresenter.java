package com.bethanypercival.plantmanual.ui.plantdetailed;

import android.content.Context;

import com.bethanypercival.plantmanual.networking.response.GetPlantDetailsResponse;

/**
 * Created by bethanypercival on 12/03/2018.
 */

public interface IPlantDetailedPresenter {
    void onViewReady(String name);

    void onDataReady(GetPlantDetailsResponse getPlantDetailsResponse);

    void readMoreClicked(String readMoreText, Context context);
}
