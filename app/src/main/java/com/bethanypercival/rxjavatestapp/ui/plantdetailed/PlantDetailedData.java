package com.bethanypercival.rxjavatestapp.ui.plantdetailed;

import com.bethanypercival.rxjavatestapp.networking.ApiRequest;
import com.bethanypercival.rxjavatestapp.networking.response.GetPlantDetailsResponse;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by bethanypercival on 12/03/2018.
 */

public class PlantDetailedData {

    private ApiRequest apiRequest;

    PlantDetailedData() {
        this.apiRequest = new ApiRequest();
    }

    public void getPlantDetails(String name, final IPlantDetailedPresenter presenter) {
        apiRequest.getPlantDetails(name)
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<GetPlantDetailsResponse>() {
                    @Override
                    public void accept(GetPlantDetailsResponse getPlantDetailsResponse) throws Exception {
                        presenter.onDataReady(getPlantDetailsResponse);
                    }
                });
    }
}
