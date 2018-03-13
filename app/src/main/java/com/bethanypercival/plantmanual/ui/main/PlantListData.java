package com.bethanypercival.plantmanual.ui.main;

import com.bethanypercival.plantmanual.networking.ApiRequest;
import com.bethanypercival.plantmanual.networking.response.GetAllPlantsResponse;
import com.bethanypercival.plantmanual.ui.main.plantList.IPlantListPresenter;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by bethanypercival on 07/03/2018.
 */

public class PlantListData {

    private ApiRequest apiRequest;

    public PlantListData() {
        this.apiRequest = new ApiRequest();
    }

    public void getAllPlants(final IPlantListPresenter presenter) {
        apiRequest.getAllPlants()
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<GetAllPlantsResponse>() {
                    @Override
                    public void accept(GetAllPlantsResponse plantOverviewList) throws Exception {
                        presenter.onDataReady(plantOverviewList);
                    }
                });


    }
}


