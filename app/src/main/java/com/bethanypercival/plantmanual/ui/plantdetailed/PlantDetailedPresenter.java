package com.bethanypercival.plantmanual.ui.plantdetailed;

import android.content.Context;

import com.bethanypercival.plantmanual.R;
import com.bethanypercival.plantmanual.networking.response.GetPlantDetailsResponse;

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

    @Override
    public void readMoreClicked(String readMoreText, Context context) {
        if(readMoreText.equals(context.getString(R.string.item_read_more))) {
            view.showMoreDetails();
        } else {
            view.hideMoreDetails();
        }
    }
}
